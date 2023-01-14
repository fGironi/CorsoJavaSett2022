package srl.neotech.model;

public enum Costruttore {

	FIAT("Fiat"),
	ALFAROMEO("Alfa Romeo"),
	LANCIA("Lancia"),
	FERRARI("Ferrari"),
	MASERATI("Maserati"),
	LAMBORGHINI("Lamborghini"),
	DALLARA("Dallara");
	
	private final String nome;
	 
	private Costruttore(String nome) {
	      this.nome = nome;
	   }
	 
	public String getNome() {
		return nome;
	}
}
