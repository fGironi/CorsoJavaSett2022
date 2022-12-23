package srl.neotech.model;


import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class ParagoneRicerca {

	private String targa;
	private Costruttore costruttore;
	private String modello;
	private Integer annoCostrMin;
	private Integer annoCostrMax;
	private Integer costoBaseMin;
	private Integer costoBaseMax;
	private Integer costoMin;
	private Integer costoMax;
	private Alimentazione alimentazione;
	private Colore colore;
	private ArrayList<AutomobileDTO> autoTrovate;
	
	public ParagoneRicerca() {
		this.autoTrovate = new ArrayList<AutomobileDTO>();
	}

	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public Costruttore getCostruttore() {
		return costruttore;
	}
	public void setCostruttore(Costruttore costruttore) {
		this.costruttore = costruttore;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public Integer getAnnoCostrMin() {
		return annoCostrMin;
	}
	public void setAnnoCostrMin(Integer annoCostrMin) {
		this.annoCostrMin = annoCostrMin;
	}
	public Integer getAnnoCostrMax() {
		return annoCostrMax;
	}
	public void setAnnoCostrMax(Integer annoCostrMax) {
		this.annoCostrMax = annoCostrMax;
	}
	public Integer getCostoBaseMin() {
		return costoBaseMin;
	}
	public void setCostoBaseMin(Integer costoBaseMin) {
		this.costoBaseMin = costoBaseMin;
	}
	public Integer getCostoBaseMax() {
		return costoBaseMax;
	}
	public void setCostoBaseMax(Integer costoBaseMax) {
		this.costoBaseMax = costoBaseMax;
	}
	public Integer getCostoMin() {
		return costoMin;
	}
	public void setCostoMin(Integer costoMin) {
		this.costoMin = costoMin;
	}
	public Integer getCostoMax() {
		return costoMax;
	}
	public void setCostoMax(Integer costoMax) {
		this.costoMax = costoMax;
	}
	public Alimentazione getAlimentazione() {
		return alimentazione;
	}
	public void setAlimentazione(Alimentazione alimentazione) {
		this.alimentazione = alimentazione;
	}
	public Colore getColore() {
		return colore;
	}
	public void setColore(Colore colore) {
		this.colore = colore;
	}
	public ArrayList<AutomobileDTO> getAutoTrovate() {
		return autoTrovate;
	}
	public void setAutoTrovate(ArrayList<AutomobileDTO> autoTrovate) {
		this.autoTrovate = autoTrovate;
	}

	@Override
	public String toString() {
		return "ParagoneRicerca [targa=" + targa + ", costruttore=" + costruttore + ", modello=" + modello
				+ ", annoCostrMin=" + annoCostrMin + ", annoCostrMax=" + annoCostrMax + ", costoBaseMin=" + costoBaseMin
				+ ", costoBaseMax=" + costoBaseMax + ", costoMin=" + costoMin + ", costoMax=" + costoMax
				+ ", alimentazione=" + alimentazione + ", colore=" + colore + ", autotrovate="+ autoTrovate.size()+ " ]";
	}
	
	
}
