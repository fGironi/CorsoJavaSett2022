package srl.neotech;

public class TagliaErba {

	private Integer altezzaLama;
	private String stato;
	private Integer passo;
	private Striscia strisciaInElaborazione;
	public Integer getAltezzaLama() {
		return altezzaLama;
	}
	public void setAltezzaLama(Integer altezzaLama) {
		this.altezzaLama = altezzaLama;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public Integer getPasso() {
		return passo;
	}
	public void setPasso(Integer passo) {
		this.passo = passo;
	}
	public Striscia getStrisciaInElaborazione() {
		return strisciaInElaborazione;
	}
	public void setStrisciaInElaborazione(Striscia strisciaInElaborazione) {
		this.strisciaInElaborazione = strisciaInElaborazione;
	}
	
	public void tagliastriscia(Striscia s) {
		this.setPasso(1);
		this.setStrisciaInElaborazione(s);
		this.setStato("in taglio");
		this.setAltezzaLama(s.getAltezzaErba());
		for (int i=0; i<s.getLunghezza(); i++) {
			this.avanza();
			this.setPasso(getPasso()+1);
			}
		if (s.getNumeroStriscia()%2!=0) {
			this.setPasso(1);
			this.setStato("gira a sinistra");
			this.gira(2, "SX");}
		else {
			this.setPasso(1);
			this.setStato("gira a destra");
			this.gira(2, "DX");}
	}
	
	
	
	private void avanza() {
	System.out.println(
			"STRISCIA: "+this.getStrisciaInElaborazione().getNumeroStriscia()+
			"  Stato: "+this.getStato()+
			"  PASSO: "+this.getPasso()+
			"  altezza erba: "+this.getAltezzaLama());
	}
	
	private void gira(Integer nRotazioni, String direzione) {
		int rot=90;
		for (int i=0; i<nRotazioni.intValue(); i++) {
			System.out.println(	
					"STRISCIA: "+this.getStrisciaInElaborazione().getNumeroStriscia()+
					"  Stato: "+this.getStato()+
					"  PASSO: "+this.getPasso()+
					" rotazione: "+rot+" gradi");
				rot= rot+90;
				this.setPasso(this.getPasso()+1);
		}
	
	}
	
}
