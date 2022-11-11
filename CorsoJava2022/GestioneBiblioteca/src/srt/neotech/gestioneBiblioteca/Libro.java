package srt.neotech.gestioneBiblioteca;

public class Libro {

	private String idLibro;
	private String titolo;
	private String autore;
	private Genere sezione;
	private Integer scaffale;
	private StatoLibro stato;
	
	public String getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(String idLibro) {
		this.idLibro = idLibro;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public Genere getSezione() {
		return sezione;
	}
	public void setSezione(Genere sezione) {
		this.sezione = sezione;
	}
	public Integer getScaffale() {
		return scaffale;
	}
	public void setScaffale(Integer scaffale) {
		this.scaffale = scaffale;
	}
	public StatoLibro getStato() {
		return stato;
	}
	public void setStato(StatoLibro stato) {
		this.stato = stato;
	}
	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titolo=" + titolo + ", autore=" + autore + ", sezione=" + sezione
				+ ", scaffale=" + scaffale + ", stato=" + stato + "]";
	}
	
	

	

	
	
}