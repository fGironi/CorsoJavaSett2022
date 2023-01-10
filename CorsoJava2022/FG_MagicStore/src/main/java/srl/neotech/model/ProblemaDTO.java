package srl.neotech.model;

import java.util.ArrayList;

public class ProblemaDTO {

	private String oggetto;
	private ArrayList<Stato> listaStati;
	
	public String getOggetto() {
		return oggetto;
	}
	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}
	public ArrayList<Stato> getListaStati() {
		return listaStati;
	}
	public void setListaStati(ArrayList<Stato> listaStati) {
		this.listaStati = listaStati;
	}
	
	
}
