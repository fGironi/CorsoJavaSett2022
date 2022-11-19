package srl.neotech.aeroporto;

public class Modello{

	private String codiceModello;
	private Integer capienzaNumPasseggeri;
	
	public Modello(String codiceModello, Integer capienzaNumPasseggeri) {
		super();
		this.codiceModello = codiceModello;
		this.capienzaNumPasseggeri = capienzaNumPasseggeri;
	}
	public String getCodiceModello() {
		return codiceModello;
	}
	public void setCodiceModello(String codiceModello) {
		this.codiceModello = codiceModello;
	}
	public Integer getCapienzaNumPasseggeri() {
		return capienzaNumPasseggeri;
	}
	public void setCapienzaNumPasseggeri(Integer capienzaNumPasseggeri) {
		this.capienzaNumPasseggeri = capienzaNumPasseggeri;
	}
	
	
}
