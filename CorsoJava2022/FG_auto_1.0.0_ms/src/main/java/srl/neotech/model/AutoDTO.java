package srl.neotech.model;

import java.util.ArrayList;

public class AutoDTO {

	//nota: la decisione di passare il colore da un'enum a una string è perché è limitante rispetto alle opzioni che l'user potrebbe voler inserire
	
	private String id;
	private String targa;
	private String modello;
	private String colore; 
	private Alimentazione alimentazione;
	private Costruttore costruttore;
	private Integer anno;
	private Integer costoBase;
	private Integer costoTot;
	private ArrayList<AccessorioDTO> accessori;
	
	
	
	public AutoDTO(String targa, String modello, String colore, Alimentazione alimentazione, Costruttore costruttore,
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
