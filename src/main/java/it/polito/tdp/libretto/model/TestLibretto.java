package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		
		Libretto lib = new Libretto();
		
		lib.aggiungiVoto(new Voto("Chimica", 26, LocalDate.of(2023, 9, 8)));
		lib.aggiungiVoto(new Voto("Sistemi Telematici", 25, LocalDate.of(2023, 9, 14)));
		lib.aggiungiVoto(new Voto("Analisi 1", 29, LocalDate.of(2023, 9, 14)));

		lib.stampaPuntiFiltro(25);
		Voto v = lib.cercaVotoPerNome("Chimica");
		System.out.println(v);
		
		Voto a1 = new Voto("Analisi 1", 29, LocalDate.of(2025, 9, 18));
		Voto a2 = new Voto("Analisi 1", 30, LocalDate.of(2025, 9, 18));
		System.out.println(a1 + " è duplicato " + lib.esisteVotoNelLibretto(a1));
		System.out.println(a2 + " è duplicato " + lib.esisteVotoNelLibretto(a2));
		
		try {
		lib.aggiungiVoto(new Voto("Analisi 1", 29, LocalDate.of(2023, 6, 14)));
		}catch(IllegalArgumentException e){
			System.out.println("Errore nell'inserimento voto!");
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n\nLibretto Originario");
		lib.stampa();
		
		Libretto migliore = lib.librettoMigliorato();
		System.out.println("\nLibretto Migliorato");
		migliore.stampa();
		
		
		
		System.out.println("\nLIBRETTO ORIGINARIO DI NUOVO") ;
		lib.stampa(); 

		
		
		System.out.println("\n");
		lib.ordineAlfabetico().stampa();
		
		System.out.println("\n");
		lib.ordineDecrescenteVoto().stampa();
	
	}

}
