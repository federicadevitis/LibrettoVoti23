package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Libretto {

	private List<Voto> voti; // un elenco di voti

	public Libretto() {// quando creo un libretto questo nasce vuoto, ecco perchè il costruttore è
						// senza argomenti
		this.voti = new ArrayList<Voto>();
	}

	public boolean aggiungiVoto(Voto v) {
		if (esisteConflitto(v) || esisteVotoNelLibretto(v)) {
			// non lo aggiungo
			throw new IllegalArgumentException("Voto errato: " + v);
		}
		return voti.add(v);
	}// add restituisce boolean

	public void stampa() {
		for (Voto v : voti) {
			System.out.println(v);
		}
	}// occorre un toString in Voto per evitare di stampare sequenze strane

	public void stampaPuntiFiltro(int valore) {// in Test gli passo il valore che voglio
		for (Voto v : this.voti) {
			if (v.getVoto_ottenuto() == valore) {
				System.out.println(v);
			}
		}
	}

	public Voto cercaVotoPerNome(String nomeCorso) {
		for (Voto v : this.voti) {
			if (v.getCorso().equals(nomeCorso)) {
				return v;
			}
		}
		// return null; //così ritorno un valore
		throw new RuntimeException("Corso non trovato");
	}

	// già presente? (stesso esame stesso voto)
	public boolean esisteVotoNelLibretto(Voto votoNuovo) {
		for (Voto v : this.voti) {
			if (v.isDuplicato(votoNuovo)) {
				return true;
			}
		}
		return false;
	}

	// conflitto? (stesso esame e voto diverso)
	public boolean esisteConflitto(Voto votoNuovo) {
		for (Voto v : this.voti) {
			if (v.isConflitto(votoNuovo)) {
				return true;
			}
		}
		return false;
	}

	// Creare un nuovo libretto con i voti migliorati
	public Libretto librettoMigliorato() {
		Libretto migliore = new Libretto();
		migliore.voti = new ArrayList<>();
		for (Voto v : voti) {
			migliore.voti.add(v.clone());
		}
		for (Voto v : migliore.voti) {
			v.setVoto_ottenuto(v.getVoto_ottenuto() + 2);
		}

		return migliore;
	}

	// cancellare dal libretto tutti i voti inferiori a 'punti'
	public void cancellaVotiInferiori(int punti) {
		List<Voto> daCancellare = new ArrayList<Voto>();
		for (Voto v : voti) {
			if (v.getVoto_ottenuto() < punti) {
				daCancellare.add(v); // mi salvo i valori da scartare
			}
		}

		for (Voto votiDaCancellare : daCancellare) {
			this.voti.remove(votiDaCancellare);
		} // MEGLIO al posto del for: voti.removeall(votiDaCancellare);
	}

	// ordinamento alfabetico
	public Libretto ordineAlfabetico() {
		Libretto ordinato = new Libretto();
		ordinato.voti = new ArrayList<Voto>(this.voti);

		Collections.sort(ordinato.voti, new ComparatoreAlfabetico());
		return ordinato;
	}

	public Libretto ordineDecrescenteVoto() {
		Libretto ordinato = new Libretto();
		ordinato.voti = new ArrayList<Voto>(this.voti);

		Collections.sort(ordinato.voti, new ComparatoreVotoDecrescente());
		return ordinato;
	}

	
	//per la stampa nella casella di testo
	public String toString() {
		String txt = "";
		for(Voto v: this.voti) {
			txt = txt + v.toString() + "\n";
		}
		return txt;

	}
}
