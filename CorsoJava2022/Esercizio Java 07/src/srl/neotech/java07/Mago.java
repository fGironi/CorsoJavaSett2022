package srl.neotech.java07;

public class Mago extends Umano{

	private String nomeClasse="il mago";

	
	
	public String getNomeClasse() {
		return nomeClasse;
	}

	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}

	@Override
	public void attacca() {
		System.out.println(this.nomeClasse+" scaglia un dardo di fuoco");
	}
	
	@Override
	public void difendi() {
		System.out.println(this.nomeClasse+" si protegge con una barriera");
		
	}

	@Override
	public void muori() {
		System.out.println("la magia abbandona "+this.nomeClasse+" morente");
	}
	
	@Override
	public void mangia() {
		System.out.println(this.nomeClasse+" mangia una mela");
	}
	
	public void dormi() {
		System.out.println(this.nomeClasse+" dorme nel letto");
	}
	
	
}
