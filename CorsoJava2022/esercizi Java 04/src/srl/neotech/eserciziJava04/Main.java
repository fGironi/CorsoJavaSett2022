package srl.neotech.eserciziJava04;
import java.text.ParseException;
import java.util.*;

public class Main {
	
	public static ArrayList<Prodotto> catalogo=new ArrayList<Prodotto>();
	
	public static void main(String[] args) throws ParseException{	
		for (int i=0; i<200; i++) {
			
			Random rnd1=new Random();
			boolean Ali=rnd1.nextBoolean();

			if (Ali==true) {
				ProdAlimentare prodAlim=new ProdAlimentare();
				prodAlim.setAlimentare(true);
				prodAlim.setScadenza("25-11-2023");
				
				prodAlim.setNome("Prodotto "+(i));
				
				Random rnd=new Random();
				prodAlim.setPrezzo(rnd.nextInt(21-1)+1);
				
				catalogo.add(prodAlim);
			}
				
			else {
				ProdNonAlim prodNAlim=new ProdNonAlim();
				prodNAlim.setAlimentare(false);
				prodNAlim.setMateriale("plastica");
				prodNAlim.setNome("Prodotto "+(i));
				Random rnd=new Random();
				prodNAlim.setPrezzo(rnd.nextInt(21-1)+1);
				
				catalogo.add(prodNAlim);
			}
				

				
			
		}


			for (Prodotto prod:catalogo) {
				System.out.println(prod.getNome());
				System.out.println("prezzo originale: € "+prod.getPrezzo());
				if (prod instanceof ProdAlimentare) System.out.println("il prodotto è alimentare");
				else if (prod instanceof ProdNonAlim) System.out.println("il prodotto non è alimentare");
				System.out.println(prod.info());
				//System.out.println("prezzo scontato 1: € "+Prodotto.applicaSconto1(prod.getPrezzo()));
				prod.applicaSconto2(prod);
				System.out.println("prezzo scontato 2: € "+prod.getPrezzo());
				System.out.println();
					}
				
			
	
		
	}
}
