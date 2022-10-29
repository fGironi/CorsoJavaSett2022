package srl.neotech.java07;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		ArrayList<Giocatore> giocatori= new ArrayList<Giocatore>();
			Giocatore g1=new Guerriero(); giocatori.add(g1);
			Giocatore g2=new Arciere();	giocatori.add(g2);
			Giocatore g3=new Mago(); giocatori.add(g3);
			Giocatore g4=new Vampiro(); giocatori.add(g4);
			Giocatore g5=new Orco(); giocatori.add(g5);
				
		for (Giocatore g:giocatori) {	g.attacca(); g.difendi(); g.muori();
			if (g instanceof Umano) { ((Umano) g).mangia(); ((Umano) g).dormi();}
			else if (g instanceof Mostro) {	((Mostro) g).caccia(); ((Mostro) g).vaInLetargo();}
			System.out.println();
		}
	}
}