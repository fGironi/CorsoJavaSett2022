package srl.neotech.model;

import java.sql.Date;

public class ConsegnaDTO {

	private String id;
	private String titolo;
	private String descrizione;
	private Date dataInizio;
	private Date scadenza;
	private Importanza importanza;
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getScadenza() {
		return scadenza;
	}
	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}
	public Importanza getImportanza() {
		return importanza;
	}
	public void setImportanza(Importanza importanza) {
		this.importanza = importanza;
	}
	
	
}
