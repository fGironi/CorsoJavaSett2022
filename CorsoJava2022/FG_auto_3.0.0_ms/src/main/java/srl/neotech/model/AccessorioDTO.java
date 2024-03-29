package srl.neotech.model;

public class AccessorioDTO {

	private Integer id;
	private String descrizione;
	private Integer costo;
	private TipologiaAcc tipologia;
	
	public AccessorioDTO(Integer id, String descrizione, Integer costo, TipologiaAcc tipologia) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.costo = costo;
		this.tipologia = tipologia;
	}
	
	public AccessorioDTO() {
		
	}
	
	
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

	

}
