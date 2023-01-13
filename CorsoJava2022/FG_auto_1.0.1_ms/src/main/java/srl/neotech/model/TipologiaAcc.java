package srl.neotech.model;

public enum TipologiaAcc {

	CERCHI("Cerchi", "Esterni"),
	ENTERTAINMENT("Entertainmnet", "Altro"),
	SEDILI("Sedili","Altro");
	
	private final String nome;
	private final String categoria;
	 
	private TipologiaAcc(String nome, String categoria) {
	      this.nome = nome;
	      this.categoria = categoria;
	   }
	 
	public String getNome() {
		return nome;
	}

	public String getCategoria() {
		return categoria;
	}
}
