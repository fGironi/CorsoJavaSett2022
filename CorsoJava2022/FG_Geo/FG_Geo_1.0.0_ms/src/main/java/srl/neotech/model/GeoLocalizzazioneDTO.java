package srl.neotech.model;

public class GeoLocalizzazioneDTO {
	private String longitudine;
	private String latitudine;
	
	
	public GeoLocalizzazioneDTO(String longitudine, String latitudine) {
		super();
		this.longitudine = longitudine;
		this.latitudine = latitudine;
	}
	public String getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(String longitudine) {
		this.longitudine = longitudine;
	}
	public String getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(String latitudine) {
		this.latitudine = latitudine;
	}
	
	
}
