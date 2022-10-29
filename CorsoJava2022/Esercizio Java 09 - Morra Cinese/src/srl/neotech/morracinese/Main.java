package srl.neotech.morracinese;

//Scrivere un programma Java_09, che imposti  due stringhe, le stringhe possono valere solo: “carta”, “forbice” o “sasso”. 
//Il programma dovrà quindi effettuare i dovuti controlli e dichiarare il vincitore secondo le note regole della “morra cinese” 
//(forbice vince su carta, carta vince su sasso, sasso vince su forbice).

public class Main {

	public static void main(String[] args) {
		Macchina m=new Macchina();
		Utente u=new Utente();


		System.out.println("Benvenuto ad una banale partita di morra cinese!");

		while (u.gioca==true) {
			System.out.println();
			m.faiMorra();
			u.scegliMorra();
	
			if (m.getMorraMacchina().equals("sasso")) {
				if (u.getMorraUtente().equals("forbice")) {
					System.out.println("la macchina ha scelto "+m.getMorraMacchina()+", hai perso!");
					}
				if (u.getMorraUtente().equals("sasso")) {
					System.out.println("la macchina ha scelto "+m.getMorraMacchina()+", pareggio!");
				}
				if (u.getMorraUtente().equals("carta")) {
					System.out.println("la macchina ha scelto "+m.getMorraMacchina()+", hai vinto!");
				}
			}
			if (m.getMorraMacchina().equals("carta")) {
				if (u.getMorraUtente().equals("sasso")) { 
					System.out.println("la macchina ha scelto "+m.getMorraMacchina()+", hai perso!");
				}
				if (u.getMorraUtente().equals("carta")) {
					System.out.println("la macchina ha scelto "+m.getMorraMacchina()+", pareggio!");
				}
				if (u.getMorraUtente().equals("forbice")) {
					System.out.println("la macchina ha scelto "+m.getMorraMacchina()+", hai vinto!");
				}
			}
			if (m.getMorraMacchina().equals("forbice")) {
				if (u.getMorraUtente().equals("carta")) {
					System.out.println("la macchina ha scelto "+m.getMorraMacchina()+", hai perso!");
				}
				if (u.getMorraUtente().equals("forbice")) {
					System.out.println("la macchina ha scelto "+m.getMorraMacchina()+", pareggio!");
				}
				if (u.getMorraUtente().equals("sasso")) {
					System.out.println("la macchina ha scelto "+m.getMorraMacchina()+", hai vinto!");
				}
			
			
		}
	}
	}

}
