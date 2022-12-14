package srl.neotech.testing;


public class TestModelOggetto {

	private String id;
	private String nome;
	private Integer valore;
	private String note;
	
	
	public TestModelOggetto() {
		
	}
	
	public TestModelOggetto(String id, String descrizione, Integer valore) {
		this.id = id;
		this.nome = descrizione;
		this.valore = valore;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String descrizione) {
		this.nome = descrizione;
	}
	public Integer getValore() {
		return valore;
	}
	public void setValore(Integer valore) {
		this.valore = valore;
	}
	
	@Override
	public String toString() {
		return "Oggetto [id=" + id + ", descrizione=" + nome + ", valore=" + valore + "]";
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}
