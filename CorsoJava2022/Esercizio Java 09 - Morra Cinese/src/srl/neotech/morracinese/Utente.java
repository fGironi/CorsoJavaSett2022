package srl.neotech.morracinese;
import java.util.*;

public class Utente {
	
	private String morraUtente;
	Boolean gioca=true;
	
	public String getMorraUtente() {
		return morraUtente;
	}

	public void setMorraUtente(String morraUtente) {
		this.morraUtente = morraUtente;
	}

	public void scegliMorra(){
		Scanner userInput=new Scanner(System.in);
		int i=0;

		while (i==0) {
			System.out.println("scrivi 'sasso', 'carta' o 'forbice', scrivi 'stop' in qualsiasi momento per smettere");
			String str=userInput.nextLine();
			if (str.equals("sasso") || str.equals("carta") || str.equals("forbice")) {
				this.morraUtente=str;
				i=1;
			}
			else if (str.equals("drago")){
				System.out.println("Wow! conosci la mossa segreta del drago! Ma sarebbe troppo per la macchina, per favore usa una mossa normale");
			}
			else if (str.equals("stop")) {
				System.out.println("torna presto a giocare!");
				this.morraUtente=str;
				i=1;
				this.gioca=false;
				if(userInput!=null)  userInput.close();
			}
			else {System.out.println("scelta non riconosciuta");}
			}

	}
	
	
}
