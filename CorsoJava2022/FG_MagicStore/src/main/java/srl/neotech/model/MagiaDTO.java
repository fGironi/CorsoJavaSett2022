package srl.neotech.model;

import java.util.HashMap;

public class MagiaDTO {

	private String id;
	private String nome;
	private HashMap<TipologiaEff, EffettoMag> effetti;
	
	
	public MagiaDTO() {
		this.setEffetti(new HashMap<TipologiaEff, EffettoMag>());
	}
	
	public MagiaDTO(EffettoMag calore, EffettoMag solidita, EffettoMag salute) {
		this.setEffetti(new HashMap<TipologiaEff, EffettoMag>());
		this.getEffetti().put(TipologiaEff.CALORE, calore);
		this.getEffetti().put(TipologiaEff.SOLIDITA, solidita);
		this.getEffetti().put(TipologiaEff.SALUTE, salute);
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
	public HashMap<TipologiaEff, EffettoMag> getEffetti() {
		return effetti;
	}
	public void setEffetti(HashMap<TipologiaEff, EffettoMag> effetti) {
		this.effetti = effetti;
	}

	
	
}
