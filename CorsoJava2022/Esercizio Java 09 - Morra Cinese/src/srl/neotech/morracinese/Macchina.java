package srl.neotech.morracinese;
import java.util.*;

public class Macchina {

	private String morraMacchina;

	public String getMorraMacchina() {
		return morraMacchina;
	}

	public void setMorraMacchina(String morraMacchina) {
		this.morraMacchina = morraMacchina;
	}
	
	public void faiMorra() {
		Random rnd=new Random();
		int i=rnd.nextInt(3);
		if (i==0) {this.morraMacchina="sasso";}
		else if (i==1) {this.morraMacchina="carta";}
		else if (i==2) {this.morraMacchina="forbice";}
		else {System.out.println("devo aver sbagliato qualcosa");}		
	}
}
