package srl.neotech.calcoloEsameReviewed;

import java.util.Scanner;

public class Ricerca {
	
	public void ricercaRisultati(Scanner scan, Esame e) {
		System.out.println("Inserisci il nome dello studente partecipante per visualizzare i voti ottenuti");
		System.out.println("scrivi \"tutti\" per visualizzare tutti i partecipanti con relativi voti o scrivi \"quit\" per uscire");
		System.out.println("puoi scrivere anche \"promosso\" o \"bocciato\" per avere chi soddisfa quelle caratteristiche");
		System.out.println("qualsiasi comando non riconosciuto restituisce la lista dei nomi dei partecipanti");
		String input=null;
		Boolean userAttivo=true;
		while (userAttivo==true) {
			input=scan.nextLine();
			if (e.getStudEsaminati().containsKey(input)) {
				Studente stud=e.getStudEsaminati().get(input);
				System.out.println(stud);
				System.out.println("serve altro?");
			}
			else if (input.equals("tutti")) {
				for (Studente stud:e.getStudEsaminati().values()) {
					System.out.println(stud);
				}
				System.out.println("serve altro?");
			}
			else if (input.equals("quit")) {
				System.out.println("arrivederci");
				userAttivo=false;
			}
			else if (input.equals("promosso")) {
				for (Studente stud:e.getStudEsaminati().values()) {
					if (stud.getRisultato().equals("promosso") || stud.getRisultato().equals("promosso con lode!")) {
						System.out.println(stud);
					}
				}
			}
			
			else if (input.equals("bocciato")) {
				for (Studente stud:e.getStudEsaminati().values()) {
					if (stud.getRisultato().equals("bocciato")) {
						System.out.println(stud);
					}
				}
			}
			
			else {
				System.out.println("nome non riconosciuto, inserisci uno dei nomi degli studenti riportati in seguito:");
				for (String nome:e.getStudEsaminati().keySet()) {
					System.out.println(nome);
				}
				
			}
			System.out.println();
			
		}
	}

}
