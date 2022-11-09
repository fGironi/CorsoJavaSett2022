package srl.neotech.calcoloEsameReviewed;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Esame e=new Esame();
		HashMap<String, Studente> studEsaminati=e.getStudEsaminati();
		
		Studente s1=new Studente("Rossi Marco"); studEsaminati.put(s1.getNome(), s1);
		Studente s2=new Studente("Bianchi Giovanni"); studEsaminati.put(s2.getNome(), s2);
		Studente s3=new Studente("Neri Andrea"); studEsaminati.put(s3.getNome(), s3);
		
		//loop per assegnare un voto e valutare tutti gli studenti partecipanti
		for (Studente s: studEsaminati.values()) {
			s.prendiVotoRandom();
			e.valuta(s);
			System.out.println(s); //syso eliminabile se si usa lo scanner qua sotto
		}
		
		
		
		System.out.println(); System.out.println("----------------------"); System.out.println();
		//Test: massimizzo il voto di Rossi Marco
			System.out.println("A scopo di testing il voto di Rossi Marco e' stato ora massimizzato");
			s1.setVotoOrale(24); s1.setVotoScritto(8); e.valuta(s1);	
			
		Scanner scan=new Scanner(System.in);
		Ricerca r=new Ricerca();
		r.ricercaRisultati(scan, e);
		scan.close();
	}

}
