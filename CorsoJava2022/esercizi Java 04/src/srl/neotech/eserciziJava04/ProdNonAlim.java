package srl.neotech.eserciziJava04;

public class ProdNonAlim extends Prodotto {

	private String materiale;

	public String getMateriale() {
		return materiale;
	}

	public void setMateriale(String materiale) {
		this.materiale = materiale;
	}
	
	@Override
	public String info() {
		return "materiale: "+this.materiale;
	}
}
