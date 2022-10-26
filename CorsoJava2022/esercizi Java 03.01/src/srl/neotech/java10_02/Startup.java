// Scrivere un programma Java10_02 che continua a stampare interi casuali compresi fra 1 e 10 fino a che non esce un numero che sia divisibile divisibile per 3

package srl.neotech.java10_02;
import java.util.*;

public class Startup {
	public static void main(String[] args) {
		Random rnd=new Random();
		
		while (true) {
			int numero=rnd.nextInt(11-1)+1;
			System.out.println(numero);
			if (numero%3==0) break;
		}
		
		System.out.println();
		
		//versione corretta
		int numero2=rnd.nextInt(11-1)+1;
		System.out.println(numero2);
		while (numero2%3!=0) {
			numero2=rnd.nextInt(11-1)+1;
			System.out.println(numero2);
		}
	}
}
