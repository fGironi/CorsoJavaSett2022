package srl.neotech.model;

import java.util.ArrayList;
import java.util.HashMap;

public class PartitaParolaDTO {

	private String ID;
	private String categoria;
	private Integer currentStreak;
	private Giocatore giocatore;
	private HashMap <String, Integer> paroleIndovinateEdErrori;
	private ArrayList <String> listaParole;
	private String parolaInCorso;
	private Integer vite;
	private String parolaSconfitta;
	
	public PartitaParolaDTO(String categoria, Giocatore giocatore) {
		this.paroleIndovinateEdErrori=new HashMap <String, Integer>();
		this.currentStreak=0;
		this.vite=9;
		this.categoria = categoria;
		this.giocatore = giocatore;
		
	}
	
	public PartitaParolaDTO() {
		this.paroleIndovinateEdErrori=new HashMap <String, Integer>();
		this.currentStreak=0;
		this.vite=9;
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

	public ArrayList <String> getListaParole() {
		return listaParole;
	}

	public void setListaParole(ArrayList <String> listaParole) {
		this.listaParole = listaParole;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getParolaInCorso() {
		return parolaInCorso;
	}

	public void setParolaInCorso(String parolaInCorso) {
		this.parolaInCorso = parolaInCorso;
	}

	public Integer getVite() {
		return vite;
	}

	public void setVite(Integer erroriTotali) {
		this.vite = erroriTotali;
	}

	public String getParolaSconfitta() {
		return parolaSconfitta;
	}

	public void setParolaSconfitta(String parolaSconfitta) {
		this.parolaSconfitta = parolaSconfitta;
	}
	
	
	
}
