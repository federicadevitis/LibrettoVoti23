package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class Voto {
	private String corso;
	private int voto_ottenuto; // da 18 a 31
	private LocalDate dataEsame;

	// costruttore base
	public Voto(String corso, int voto_ottenuto, LocalDate dataEsame) {
		super();
		this.corso = corso;
		this.voto_ottenuto = voto_ottenuto;
		this.dataEsame = dataEsame;
	}

	public Voto(Voto v) {
		this.corso = v.corso;
		this.voto_ottenuto = v.voto_ottenuto;
		this.dataEsame = v.dataEsame;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public int getVoto_ottenuto() {
		return voto_ottenuto;
	}

	public void setVoto_ottenuto(int voto_ottenuto) {
		this.voto_ottenuto = voto_ottenuto;
	}

	public LocalDate getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(LocalDate dataEsame) {
		this.dataEsame = dataEsame;
	}

	@Override
	public String toString() {
		return corso + " (" + voto_ottenuto + "pt)" + " in data " + dataEsame;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corso == null) ? 0 : corso.hashCode());
		result = prime * result + ((dataEsame == null) ? 0 : dataEsame.hashCode());
		result = prime * result + voto_ottenuto;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (corso == null) {
			if (other.corso != null)
				return false;
		} else if (!corso.equals(other.corso))
			return false;
		if (dataEsame == null) {
			if (other.dataEsame != null)
				return false;
		} else if (!dataEsame.equals(other.dataEsame))
			return false;
		if (voto_ottenuto != other.voto_ottenuto)
			return false;
		return true;
	}

	// stesso esame stesso voto
	public boolean isDuplicato(Voto v) {
		return this.getCorso().equals(v.getCorso()) && this.getVoto_ottenuto() == v.getVoto_ottenuto();
	}

	// stesso esame voto diverso
	public boolean isConflitto(Voto v) {
		return this.getCorso().equals(v.getCorso()) && this.getVoto_ottenuto() != v.getVoto_ottenuto();
	}

	public Voto clone() {
		return new Voto(corso, voto_ottenuto, dataEsame);
	}

	
}
