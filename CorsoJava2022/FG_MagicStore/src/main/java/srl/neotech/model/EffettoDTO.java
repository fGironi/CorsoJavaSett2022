package srl.neotech.model;


public class EffettoDTO {

	private Integer calore;
	private Integer solidita;
	private Integer salute;
	
	
	public EffettoDTO(Integer calore, Integer solidita, Integer salute) {
		this.calore = calore;
		this.solidita = solidita;
		this.salute = salute;
	}
	
	public EffettoDTO() {
		
	}
	
	public Integer getCalore() {
		return calore;
	}
	public void setCalore(Integer calore) {
		this.calore = calore;
	}
	public Integer getSolidita() {
		return solidita;
	}
	public void setSolidita(Integer solidita) {
		this.solidita = solidita;
	}
	public Integer getSalute() {
		return salute;
	}
	public void setSalute(Integer salute) {
		this.salute = salute;
	}
	
	
}
