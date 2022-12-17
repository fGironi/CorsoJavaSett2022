package srl.neotech.model;

import java.util.ArrayList;

public class Giocatore {

	private String id;
	private String nome;
	private String icona;
	private ArrayList<PunteggioParola> punteggi;
	private ArrayList<PartitaParolaDTO> partiteParola;

	public Giocatore() {
		this.punteggi=new ArrayList<PunteggioParola>();
		this.partiteParola=new ArrayList<PartitaParolaDTO>();
	}
	
	
	
	public Giocatore(String id, String nome) {
		this.id=id;
		this.nome = nome;
		this.punteggi=new ArrayList<PunteggioParola>();
		this.partiteParola=new ArrayList<PartitaParolaDTO>();
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



	public ArrayList<PartitaParolaDTO> getPartiteParola() {
		return partiteParola;
	}



	public void setPartiteParola(ArrayList<PartitaParolaDTO> partiteParola) {
		this.partiteParola = partiteParola;
	}
	
	
}
