package srl.neotech.java07;

public class Orco extends Mostro {

	private String nomeClasse="l'orco";

	
	
	public String getNomeClasse() {
		return nomeClasse;
	}

	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}

	@Override
	public void attacca() {
		System.out.println(this.nomeClasse+" colpisce con la clava");
		
	}

	@Override
	public void difendi() {
		System.out.println(this.nomeClasse+" non viene scalfito dal colpo");
	}

	@Override
	public void muori() {
		System.out.println(this.nomeClasse+" muore lanciando un tremendo ruggito");
	}

	@Override
	public void caccia() {
		System.out.println(this.nomeClasse+" divora un povero viandante");
	}

	@Override
	public void vaInLetargo() {
		System.out.println(this.nomeClasse+" si rifugia nella sua tana");
	}
	
	
	
}
