package srl.neotech.model;

import java.util.ArrayList;
import java.util.HashMap;

public class PartitaParolaDTO {

	private String categoria;
	private Integer currentStreak;
	private Giocatore giocatore;
	private HashMap <String, Integer> paroleIndovinateEdErrori;
	private ArrayList <String> listaParole;
	private Boolean inCorso;
	
	public PartitaParolaDTO(String categoria, Giocatore giocatore) {
		this.paroleIndovinateEdErrori=new HashMap <String, Integer>();
		this.currentStreak=0;
		this.inCorso=true;
		this.categoria = categoria;
		this.giocatore = giocatore;
	}
	
	public PartitaParolaDTO() {
		this.paroleIndovinateEdErrori=new HashMap <String, Integer>();
		this.currentStreak=0;
		this.inCorso=true;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Integer getCurrentStreak() {
		return currentStreak;
	}
	public void setCurrentStreak(Integer currentStreak) {
		this.currentStreak = currentStreak;
	}
	public Giocatore getGiocatore() {
		return giocatore;
	}
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}
	public HashMap<String, Integer> getParoleIndovinateEdErrori() {
		return paroleIndovinateEdErrori;
	}
	public void setParoleIndovinateEdErrori(HashMap<String, Integer> paroleIndovinateEdErrori) {
		this.paroleIndovinateEdErrori = paroleIndovinateEdErrori;
	}

	public Boolean getInCorso() {
		return inCorso;
	}

	public void setInCorso(Boolean inCorso) {
		this.inCorso = inCorso;
	}

	public ArrayList <String> getListaParole() {
		return listaParole;
	}

	public void setListaParole(ArrayList <String> listaParole) {
		this.listaParole = listaParole;
	}
	
	
	
}
