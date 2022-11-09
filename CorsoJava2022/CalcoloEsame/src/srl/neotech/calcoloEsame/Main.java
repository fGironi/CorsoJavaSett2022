package srl.neotech.calcoloEsame;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> voti =new ArrayList<Integer>();
		Random rnd=new Random();
		Integer votoScritto=rnd.nextInt(-8, 9);
		Integer votoOrale=rnd.nextInt(0, 25);
		voti.add(votoOrale);
		voti.add(votoScritto);
		Integer votoTotale=0;
		for (Integer v: voti) {	votoTotale+=v;	}
		
		if (votoScritto<=0) {
			System.out.println("lo studente e' bocciato.");
			System.out.println("voto totale: "+votoTotale+", voto scritto: "+votoScritto+", voto orale: "+votoOrale);
		}
		if (votoTotale<18) {
			System.out.println("lo studente e' bocciato.");
			System.out.println("voto totale: "+votoTotale+", voto scritto: "+votoScritto+", voto orale: "+votoOrale);
		}
		else if (votoTotale>18&&votoTotale<=30) {
			System.out.println("lo studente e' promosso.");
			System.out.println("voto totale: "+votoTotale+", voto scritto: "+votoScritto+" voto orale: "+votoOrale);
		}
		else {
			System.out.println("lo studente e' promosso con lode!");
			System.out.println("voto totale: "+votoTotale+", voto scritto: "+votoScritto+", voto orale: "+votoOrale);
		}
	}

}
