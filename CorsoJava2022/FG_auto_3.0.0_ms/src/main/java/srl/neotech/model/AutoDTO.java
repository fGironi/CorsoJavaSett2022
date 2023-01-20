package srl.neotech.model;

import java.util.ArrayList;

public class AutoDTO {

	private String id;
	private String targa;
	private String modello;
	private Colore colore; 
	private Alimentazione alimentazione;
	private Costruttore costruttore;
	private Integer anno;
	private Integer costoBase;
	private Integer costoTot;
	private ArrayList<AccessorioDTO> accessori;
	
	
	//Costruttore per l'addAutoRequest
	public AutoDTO(String targa, String modello, Colore colore, Alimentazione alimentazione, Costruttore costruttore,
			Integer anno, Integer costoBase) {
		super();
		this.targa = targa;
		this.modello = modello;
		this.colore = colore;
		this.alimentazione = alimentazione;
		this.costruttore = costruttore;
		this.anno = anno;
		this.costoBase = costoBase;
		this.accessori = new ArrayList<AccessorioDTO>();
	}
	
	//Costruttore completo
	public AutoDTO(String id, String targa, String modello, Colore colore, Alimentazione alimentazione,
			Costruttore costruttore, Integer anno, Integer costoBase, Integer costoTot,
			ArrayList<AccessorioDTO> accessori) {
		super();
		this.id = id;
		this.targa = targa;
		this.modello = modello;
		this.colore = colore;
		this.alimentazione = alimentazione;
		this.costruttore = costruttore;
		this.anno = anno;
		this.costoBase = costoBase;
		this.costoTot = costoTot;
		this.accessori = accessori;
	}

	
	//Costruttore provvisorio senza accessori per la lista auto
	public AutoDTO(String id, String targa, String modello, Colore colore, Alimentazione alimentazione,
			Costruttore costruttore, Integer anno, Integer costoBase, Integer costoTot) {
		super();
		this.id = id;
		this.targa = targa;
		this.modello = modello;
		this.colore = colore;
		this.alimentazione = alimentazione;
		this.costruttore = costruttore;
		this.anno = anno;
		this.costoBase = costoBase;
		this.costoTot = costoTot;
	}

	public AutoDTO() {
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
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public Colore getColore() {
		return colore;
	}
	public void setColore(Colore colore) {
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
	public Integer getCostoTot() {
		return costoTot;
	}
	public void setCostoTot(Integer costoTot) {
		this.costoTot = costoTot;
	}
	public ArrayList<AccessorioDTO> getAccessori() {
		return accessori;
	}
	public void setAccessori(ArrayList<AccessorioDTO> accessori) {
		this.accessori = accessori;
	}
	
	
}
