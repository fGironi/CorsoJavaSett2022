package srl.neotech.aeroporto;

import java.util.HashMap;

public class Modello extends Aereo{

	private String codiceModello;
	private Integer capienzaNumPasseggeri;
	
	public Modello(String codiceModello, Integer capienzaNumPasseggeri) {
		super();
		HashMap<String, Passeggero> lp=new HashMap<String,Passeggero>();
		this.setListaPasseggeri(lp);
		this.codiceModello = codiceModello;
		this.capienzaNumPasseggeri = capienzaNumPasseggeri;
		this.setModello(this);
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
