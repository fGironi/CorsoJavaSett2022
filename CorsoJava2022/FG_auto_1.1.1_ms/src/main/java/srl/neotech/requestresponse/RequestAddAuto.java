package srl.neotech.requestresponse;

import java.util.ArrayList;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import srl.neotech.model.AccessorioDTO;
import srl.neotech.model.Alimentazione;
import srl.neotech.model.Costruttore;

@Valid
public class RequestAddAuto {
	@NotNull(message = "campo richiesto, per favore inserisci una targa")
	@Size(max = 7, min = 5, message = "Targa non valida, la dimensione dovrebbe essre tra i 5 e i 7 caratteri")
	private String targa;
	@NotNull(message = "campo richiesto, per favore inserisci un modello")
	@Size(min = 2, message = "Nome modello non valido. Il modello dovrebbe essere almeno di 2 caratteri")
	private String modello;
	@NotNull(message = "campo richiesto, per favore inserisci un colore")
	@Size(min = 2, message = "Colore non valido. Il colore dovrebbe essere di almeno 2 caratteri")
	private String colore; 
	@NotNull(message = "campo richiesto, per favore inserisci un'alimentazione")
	private Alimentazione alimentazione;
	@NotNull(message = "campo richiesto, per favore inserisci un costruttore")
	private Costruttore costruttore;
	//nota: se lavorassi con le date qua si potrebbe usare un ottimo validator @PastOrPresent
	@NotNull(message = "campo richiesto, per favore inserisci l'anno di immatricolazione")
	@Range(min = 1970, max = 2023, message = "Anno non valido. L'anno dovrebbe essere compreso tra il 1970 ed il 2023")
	private Integer anno;
	@NotNull(message = "campo richiesto, per favore inserisci un costo base")
	@Min(value = 1000, message = "Costo base non valido, il minimo dovrebbe essere 1000")
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
