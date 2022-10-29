package srl.neotech.java07;

public abstract class Mostro implements Giocatore {
	
	private String nomeClasse;
	
	public void caccia() {
		System.out.println(this.nomeClasse+" caccia");	
	}
	
	public void vaInLetargo() {
		System.out.println(this.nomeClasse+" va in letargo");
		
	};
	
}
