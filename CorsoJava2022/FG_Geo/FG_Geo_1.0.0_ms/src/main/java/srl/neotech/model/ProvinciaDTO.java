package srl.neotech.model;

public class ProvinciaDTO {

	private String sigla;
	private String nome;
	
	public ProvinciaDTO(String sigla, String nome) {
		super();
		this.sigla = sigla;
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
}
