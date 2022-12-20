package srl.neotech.model;

import java.util.ArrayList;
import java.util.Date;

public class AutomobileDTO {
	private String id;
	private String targa;
	private Costruttore costruttore;
	private String modello;
	private Integer annoCostruzione;
	private Date dataCostruzione;
	private Integer costo;
	private Alimentazione alimentazione;
	private Colore colore;
	private ArrayList<AccessorioDTO> accessori;
	
	
	
	
	@Override
	public String toString() {
		return "AutomobileDTO [id=" + id + ", targa=" + targa + ", costruttore=" + costruttore + ", modello=" + modello
				+ ", annoCostruzione=" + annoCostruzione + ", dataCostruzione=" + dataCostruzione + ", costo=" + costo
				+ ", alimentazione=" + alimentazione + ", colore=" + colore + "]";
	}
	public AutomobileDTO() {
		this.accessori = new ArrayList<AccessorioDTO>();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Date getDataCostruzione() {
		return dataCostruzione;
	}
	public void setDataCostruzione(Date annoCostruzione) {
		this.dataCostruzione = annoCostruzione;
	}
	public Integer getCosto() {
		return costo;
	}
	public void setCosto(Integer costo) {
		this.costo = costo;
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
	public ArrayList<AccessorioDTO> getAccessori() {
		return accessori;
	}
	public void setAccessori(ArrayList<AccessorioDTO> accessori) {
		this.accessori = accessori;
	}
	public Integer getAnnoCostruzione() {
		return annoCostruzione;
	}
	public void setAnnoCostruzione(Integer annoCostruzione) {
		this.annoCostruzione = annoCostruzione;
	}
	
	
}
