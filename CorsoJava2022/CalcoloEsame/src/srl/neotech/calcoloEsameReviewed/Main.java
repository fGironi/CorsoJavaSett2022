package srl.neotech.calcoloEsameReviewed;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import com.github.javafaker.Faker;

public class Main {

	public static void main(String[] args) {
		Esame e=new Esame();
		HashMap<String, Studente> studEsaminati=e.getStudEsaminati();
		Faker faker=new Faker();
		Random rnd=new Random();
		for (int i=0; i<rnd.nextInt(10,21); i++) {
			Studente s=new Studente(faker.name().fullName()); studEsaminati.put(s.getNome(), s);
		}
				
		//loop per assegnare un voto e valutare tutti gli studenti partecipanti
		for (Studente s: studEsaminati.values()) {
			s.prendiVotoRandom();
			e.valuta(s);
			//syso superflua se si usa lo scanner qua sotto
			//System.out.println(s); 
		}
		
		System.out.println(); System.out.println("----------------------"); System.out.println();
					
		Scanner scan=new Scanner(System.in);
		Ricerca r=new Ricerca();
		r.ricercaRisultati(scan, e);
		scan.close();
	}

}
