package srl.neotech.java07;

public class Arciere extends Umano {

	private String nomeClasse= "l'arciere";
	
	@Override
	public void attacca() {
		System.out.println(this.nomeClasse+" scocca una freccia");
	}
	
	@Override
	public void difendi() {
		System.out.println(this.nomeClasse+" schiva abilmente il colpo");
	}

	@Override
	public void muori() {
		System.out.println(this.nomeClasse+" lascia cadere l'arco e crolla a terra");
	}
	@Override
	public void mangia() {
		System.out.println(this.nomeClasse+" mangia una mela");
	}
	
	public void dormi() {
		System.out.println(this.nomeClasse+" dorme nel letto");
	}

	
}
