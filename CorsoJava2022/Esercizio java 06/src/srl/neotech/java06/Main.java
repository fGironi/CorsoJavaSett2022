package srl.neotech.java06;

public class Main {

	public static void main(String[] args) {

		Eroe eroe=new Eroe(10);
		Licantropo lican=new Licantropo(8, 12, false);
		Vampiro vamp=new Vampiro(11);

		System.out.println(lican.showForza());
		lican.attacca();
		lican.trasforma();
		System.out.println(lican.showForza());
		lican.attacca();
		lican.trasforma();
		
		System.out.println("--------------");
		
		System.out.println(eroe.showForza());
		eroe.combatti();
		
		System.out.println("--------------");
		
		System.out.println(vamp.showForza());
		vamp.azzanna();
		
	}

}
