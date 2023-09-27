package it.polito.tdp.libretto.model;

import java.util.Comparator;

public class ComparatoreVotoDecrescente implements Comparator<Voto> {

	@Override
	public int compare(Voto o1, Voto o2) {
		return (o2.getVoto_ottenuto()-o1.getVoto_ottenuto());
	}

}
