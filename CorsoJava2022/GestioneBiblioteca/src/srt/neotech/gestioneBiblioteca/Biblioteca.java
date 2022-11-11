package srt.neotech.gestioneBiblioteca;

import java.util.HashMap;

public class Biblioteca {

	private HashMap<String, Libro> listaLibri;
	private HashMap<String, Associato> listaAssociati;
	
	
	
	public Biblioteca() {
		super();
		this.listaLibri = new HashMap<String, Libro>();
		this.listaAssociati = new HashMap<String, Associato>();
		
	}
	public HashMap<String, Libro> getListaLibri() {
		return listaLibri;
	}
	public void setListaLibri(HashMap<String, Libro> listaLibri) {
		this.listaLibri = listaLibri;
	}
	public HashMap<String, Associato> getListaAssociati() {
		return listaAssociati;
	}
	public void setListaAssociati(HashMap<String, Associato> listaAssociati) {
		this.listaAssociati = listaAssociati;
	}
	
	
}
