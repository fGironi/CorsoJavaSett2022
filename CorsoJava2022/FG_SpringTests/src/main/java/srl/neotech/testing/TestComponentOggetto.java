package srl.neotech.testing;
public class TestComponentOggetto {

	private String id;
	private String descrizione;
	private Integer valore;
	
	
	public TestComponentOggetto() {
		
	}
	
	public TestComponentOggetto(String id, String descrizione, Integer valore) {
		this.id = id;
		this.descrizione = descrizione;
		this.valore = valore;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Integer getValore() {
		return valore;
	}
	public void setValore(Integer valore) {
		this.valore = valore;
	}
	
	@Override
	public String toString() {
		return "Oggetto [id=" + id + ", descrizione=" + descrizione + ", valore=" + valore + "]";
	}
	
	
	
}
