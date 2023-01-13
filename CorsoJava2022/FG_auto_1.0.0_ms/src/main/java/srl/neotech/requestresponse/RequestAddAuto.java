package srl.neotech.requestresponse;

import java.util.ArrayList;

import srl.neotech.model.AccessorioDTO;
import srl.neotech.model.Alimentazione;
import srl.neotech.model.Costruttore;

public class RequestAddAuto {
	
	private String targa;
	private String modello;
	private String colore; 
	private Alimentazione alimentazione;
	private Costruttore costruttore;
	private Integer anno;
	private Integer costoBase;
	private ArrayList<AccessorioDTO> accessori;
	
	public RequestAddAuto() {
		super();
		this.accessori = new ArrayList<AccessorioDTO>();
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

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public Integer getCostoBase() {
		return costoBase;
	}

	public void setCostoBase(Integer costoBase) {
		this.costoBase = costoBase;
	}

	public ArrayList<AccessorioDTO> getAccessori() {
		return accessori;
	}

	public void setAccessori(ArrayList<AccessorioDTO> accessori) {
		this.accessori = accessori;
	}
	
	
	
}
