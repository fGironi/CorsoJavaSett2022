// Scrivere un programma Java10_01 che stampi a video 10 numeri casuali compresi fra 1 e 10 (estremi inclusi)

package srl.neotech.java10_01;
import java.util.*;

public class Startup {

	public static void main (String[] args) {
		Random rnd=new Random();
		for (int i=0; i<1000; i++) {
			int numero=rnd.nextInt(11-1)+1;
			System.out.println(numero);
		}
	}
}
