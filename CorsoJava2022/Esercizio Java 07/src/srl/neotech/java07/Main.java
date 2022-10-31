package srl.neotech.java07;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		/*
		ArrayList<Giocatore> giocatori= new ArrayList<Giocatore>();
			Giocatore g1=new Guerriero(); giocatori.add(g1);
			Giocatore g2=new Arciere();	giocatori.add(g2);
			Giocatore g3=new Mago(); giocatori.add(g3);
			Giocatore g4=new Vampiro(); giocatori.add(g4);
			Giocatore g5=new Orco(); giocatori.add(g5);
			
		for (Giocatore g:giocatori) {	
			g.attacca(); g.difendi(); g.muori();
			if (g instanceof Umano) { 
				((Umano) g).mangia(); ((Umano) g).dormi();
				}
			else if (g instanceof Mostro) {	
				((Mostro) g).caccia(); ((Mostro) g).vaInLetargo();
				}
			System.out.println();
		}
		*/
		
		//riscrittura del codice utilizzando la classe HashMap
		
		HashMap<String, Giocatore> mapGiocatori= new HashMap<String, Giocatore>();
			Giocatore g1=new Guerriero(); mapGiocatori.put(g1.getNomeClasse(), g1);
			Giocatore g2=new Arciere();	mapGiocatori.put(g2.getNomeClasse(), g2);
			Giocatore g3=new Mago(); mapGiocatori.put(g3.getNomeClasse(), g3);
			Giocatore g4=new Vampiro(); mapGiocatori.put(g4.getNomeClasse(), g4);
			Giocatore g5=new Orco(); mapGiocatori.put(g5.getNomeClasse(), g5);
		
				
		Set<String> classi= mapGiocatori.keySet();
		
		/* iterazione tramite for each
		for (String classe:classi) {
			mapGiocatori.get(classe).attacca(); mapGiocatori.get(classe).difendi(); mapGiocatori.get(classe).muori();
			if (mapGiocatori.get(classe) instanceof Umano) { 
				((Umano) mapGiocatori.get(classe)).mangia(); ((Umano) mapGiocatori.get(classe)).dormi();
				}
			else if (mapGiocatori.get(classe) instanceof Mostro) {	
				((Mostro) mapGiocatori.get(classe)).caccia(); ((Mostro) mapGiocatori.get(classe)).vaInLetargo();
				}
		}
		*/
		
		/*iterazione usando l'interfaccia Iterator*/
		Iterator<String> iter= classi.iterator();
		while(iter.hasNext()) {
			String classeIter=iter.next();
			mapGiocatori.get(classeIter).attacca(); mapGiocatori.get(classeIter).difendi(); mapGiocatori.get(classeIter).muori();
			if (mapGiocatori.get(classeIter) instanceof Umano) { 
				((Umano) mapGiocatori.get(classeIter)).mangia(); ((Umano) mapGiocatori.get(classeIter)).dormi();
				}
			else if (mapGiocatori.get(classeIter) instanceof Mostro) {	
				((Mostro) mapGiocatori.get(classeIter)).caccia(); ((Mostro) mapGiocatori.get(classeIter)).vaInLetargo();
				}
		}
		
		
	}
}