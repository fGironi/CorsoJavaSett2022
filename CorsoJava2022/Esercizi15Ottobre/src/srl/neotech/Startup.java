package srl.neotech;

import java.util.*;

public class Startup {

	public static void main(String[] args) {
		
//Numero Random da 1 a 100		
//		Random rnd=new Random();
//		
//		for(int i=0; i<10; i++) {
//								//  (max - min)+min
//			int numeroScelto= rnd.nextInt(100-1)+1;
//			System.out.println("E' uscito il "+numeroScelto);
//		}
//Stampare 100 colori casuali
		
		Random rnd=new Random();
		for (int j=0; j<100; j++) {	
			int numero= rnd.nextInt(6-1)+1;
			
			//switch può sostituire una serie di if se si stanno paragonando numeri o stringhe
			switch(numero) {
				case 1:	{System.out.println("rosso"); break;}
				case 2: {System.out.println("verde"); break;}
				case 3: {System.out.println("giallo"); break;}
				case 4: {System.out.println("nero"); break;}
				case 5: {System.out.println("blu"); break;}
				case 6: {System.out.println("viola"); break;}
			}
		}
	}
}
