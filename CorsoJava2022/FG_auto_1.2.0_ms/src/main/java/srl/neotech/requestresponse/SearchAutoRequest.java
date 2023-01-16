package srl.neotech.requestresponse;

import java.util.ArrayList;

import srl.neotech.model.AccessorioDTO;
import srl.neotech.model.Alimentazione;
import srl.neotech.model.Costruttore;

public class SearchAutoRequest {

	private String id;
	private String targa;
	private String modello;
	private String colore; 
	private Alimentazione alimentazione;
	private Costruttore costruttore;
	private Integer annoMin;
	private Integer costoBaseMin;
	private Integer costoTotMin;
	private Integer annoMax;
	private Integer costoBaseMax;
	private Integer costoTotMax;
	private ArrayList<AccessorioDTO> accessori;
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
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public Alimentazione getAlimentazione() {
		return alimentazione;
	}
	public void setAlimentazione(Alimentazione alimentazione) {
		this.alimentazione = alimentazione;
	}
	public Costruttore getCostruttore() {
		return costruttore;
	}
	public void setCostruttore(Costruttore costruttore) {
		this.costruttore = costruttore;
	}
	public Integer getAnnoMin() {
		return annoMin;
	}
	public void setAnnoMin(Integer annoMin) {
		this.annoMin = annoMin;
	}
	public Integer getCostoBaseMin() {
		return costoBaseMin;
	}
	public void setCostoBaseMin(Integer costoBaseMin) {
		this.costoBaseMin = costoBaseMin;
	}
	public Integer getCostoTotMin() {
		return costoTotMin;
	}
	public void setCostoTotMin(Integer costoTotMin) {
		this.costoTotMin = costoTotMin;
	}
	public Integer getAnnoMax() {
		return annoMax;
	}
	public void setAnnoMax(Integer annoMax) {
		this.annoMax = annoMax;
	}
	public Integer getCostoBaseMax() {
		return costoBaseMax;
	}
	public void setCostoBaseMax(Integer costoBaseMax) {
		this.costoBaseMax = costoBaseMax;
	}
	public Integer getCostoTotMax() {
		return costoTotMax;
	}
	public void setCostoTotMax(Integer costoTotMax) {
		this.costoTotMax = costoTotMax;
	}
	public ArrayList<AccessorioDTO> getAccessori() {
		return accessori;
	}
	public void setAccessori(ArrayList<AccessorioDTO> accessori) {
		this.accessori = accessori;
	}
	
	
}
