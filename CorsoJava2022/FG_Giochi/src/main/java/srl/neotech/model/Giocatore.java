package srl.neotech.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Giocatore {

	private String id;
	private String nome;
	private String icona;
	private ArrayList<PunteggioParola> punteggi;
	private HashMap<String, PartitaParolaDTO> partiteParola;
	private HashMap<String, PartitaParolaDTO> partiteInCorso;

	public Giocatore() {
		this.punteggi=new ArrayList<PunteggioParola>();
		this.partiteParola=new HashMap<String, PartitaParolaDTO>();
		this.partiteInCorso=new HashMap<String, PartitaParolaDTO>();
	}
	
	
	
	public Giocatore(String id, String nome) {
		this.id=id;
		this.nome = nome;
		this.punteggi=new ArrayList<PunteggioParola>();
		this.partiteParola=new HashMap<String, PartitaParolaDTO>();
		this.partiteInCorso=new HashMap<String, PartitaParolaDTO>();
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<PunteggioParola> getPunteggi() {
		return punteggi;
	}
	public void setPunteggi(ArrayList<PunteggioParola> punteggi) {
		this.punteggi = punteggi;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getIcona() {
		return icona;
	}


	public void setIcona(String icona) {
		this.icona = icona;
	}



	public HashMap<String, PartitaParolaDTO> getPartiteParola() {
		return partiteParola;
	}



	public void setPartiteParola(HashMap<String, PartitaParolaDTO> partiteParola) {
		this.partiteParola = partiteParola;
	}



	public HashMap<String, PartitaParolaDTO> getPartiteInCorso() {
		return partiteInCorso;
	}



	public void setPartiteInCorso(HashMap<String, PartitaParolaDTO> partiteInCorso) {
		this.partiteInCorso = partiteInCorso;
	}
	
	
}
