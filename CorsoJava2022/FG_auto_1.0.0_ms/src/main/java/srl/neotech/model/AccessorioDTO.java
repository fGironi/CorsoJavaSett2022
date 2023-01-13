package srl.neotech.model;

public class AccessorioDTO {

	private String descrizione;
	private Integer costo;
	private TipologiaAcc tipologia;
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Integer getCosto() {
		return costo;
	}
	public void setCosto(Integer costo) {
		this.costo = costo;
	}
	public TipologiaAcc getTipologia() {
		return tipologia;
	}
	public void setTipologia(TipologiaAcc tipologia) {
		this.tipologia = tipologia;
	}

	

}
