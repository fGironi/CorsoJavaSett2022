package srl.neotech.java07;

public class Guerriero extends Umano{

	private String nomeClasse="il guerriero";
	
	@Override
	public void attacca() {
		System.out.println(this.nomeClasse+" attacca con una serie di fendenti");
		
	}	
	@Override
	public void difendi() {
		System.out.println(this.nomeClasse+" devia l'attacco con il suo scudo");
		
	}

	@Override
	public void muori() {
		System.out.println(this.nomeClasse+" cade a terra sconfitto");
	}

	@Override
	public void mangia() {
		System.out.println(this.nomeClasse+" mangia una mela");
	}
	
	@Override
	public void dormi() {
		System.out.println(this.nomeClasse+" dorme nel letto");
	}


}
