package srl.neotech.model;

import java.util.ArrayList;

public class MagiaDTO {

	private String id;
	private String nome;
	private EffettoDTO effetto;
	private ArrayList<iconaMag> icone;
	
	public MagiaDTO() {
		this.icone = new ArrayList<iconaMag>();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public EffettoDTO getEffetto() {
		return effetto;
	}
	public void setEffetto(EffettoDTO effetto) {
		this.effetto = effetto;
	}
	public ArrayList<iconaMag> getIcone() {
		return icone;
	}
	public void setIcone(ArrayList<iconaMag> icone) {
		this.icone = icone;
	}
	
	
}
