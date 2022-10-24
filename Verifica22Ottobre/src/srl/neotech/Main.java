package srl.neotech;


public class Main {

	public static void main(String[] args) {
		Campo c=new Campo();
		TagliaErba t=new TagliaErba();
		
		c.creaStrisce();
		
		for (Striscia s:c.getStrisce()) {
			t.tagliastriscia(s);
		}
		
		t.setStato("spento");
		System.out.println("FINE CAMPO  stato: "+t.getStato());
		
	}
}
		
		
	



