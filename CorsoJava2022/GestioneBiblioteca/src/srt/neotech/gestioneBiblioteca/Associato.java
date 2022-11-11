package srt.neotech.gestioneBiblioteca;

import java.util.HashMap;

public class Associato {

	private String idAssociato;
	private String nominativo;
	private StatoAssociato stato;
	private HashMap<String, Libro> libriPresi;
	
	public String getIdAssociato() {
		return idAssociato;
	}
	public void setIdAssociato(String idAssociato) {
		this.idAssociato = idAssociato;
	}
	public String getNominativo() {
		return nominativo;
	}
	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}
	public StatoAssociato getStato() {
		return stato;
	}
	public void setStato(StatoAssociato stato) {
		this.stato = stato;
	}
	public HashMap<String, Libro> getLibriPresi() {
		return libriPresi;
	}
	public void setLibriPresi(HashMap<String, Libro> libriPresi) {
		this.libriPresi = libriPresi;
	}
	
	@Override
	public String toString() {
		return "Associato [idAssociato=" + idAssociato + ", nominativo=" + nominativo + ", stato=" + stato
				+ ", libriPresi=" + libriPresi.keySet() +"]";
	}
	
	
	
}
