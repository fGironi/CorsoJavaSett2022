//Scrivere un programma Java10_03 che inizializzi un array (ArrayList) con 10 numeri casuali compresi fra due numeri. stampare l'array

package srl.neotech.java10_03;
import java.util.*;

public class Startup {
	
	public static void main (String[] args) {
		
		ArrayList<Integer> numeriRnd=new ArrayList<Integer>();
		Random rnd=new Random();
			for (int i=0; i<10; i++) {
				int numero=rnd.nextInt(101-9)+9;
				numeriRnd.add(numero);
			}
		//opzione stampa 1
		System.out.println(numeriRnd);
		
		//opzione stampa 2
		for(int numero:numeriRnd) System.out.println(numero);
		
		
		
	}
	
}
