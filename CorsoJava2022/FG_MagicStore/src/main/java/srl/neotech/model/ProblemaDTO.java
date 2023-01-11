package srl.neotech.model;

import java.util.ArrayList;

public class ProblemaDTO {

	private String oggetto;
	private ArrayList<Stato> listaStati;
	private Integer calore;
	private Integer solidita;
	private Integer salute;
	
	
	public ProblemaDTO() {
		this.listaStati=new ArrayList<Stato>();
	}
	
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

	public Integer getCalore() {
		return calore;
	}

	public void setCalore(Integer calore) {
		this.calore = calore;
	}

	public Integer getSolidita() {
		return solidita;
	}

	public void setSolidita(Integer solidita) {
		this.solidita = solidita;
	}

	public Integer getSalute() {
		return salute;
	}

	public void setSalute(Integer salute) {
		this.salute = salute;
	}
	
	
}
