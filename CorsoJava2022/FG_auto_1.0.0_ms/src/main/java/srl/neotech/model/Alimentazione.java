package srl.neotech.model;

public enum Alimentazione {

	BENZINA("Benzina"),
	DIESEL("Diesel"),
	METANO("Metano"),
	GPL("GPL"),
	ELETTRICA("Elettrica"),
	IBRIDA("Ibrida");
	
	private final String nome;
	 
	private Alimentazione(String nome) {
	      this.nome = nome;
	   }

	public String getNome() {
		return nome;
	}
}
