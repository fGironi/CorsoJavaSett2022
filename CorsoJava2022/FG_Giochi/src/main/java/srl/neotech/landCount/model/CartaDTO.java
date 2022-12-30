package srl.neotech.landCount.model;

import java.util.HashMap;

public class CartaDTO {

	private Integer turnoRichiesto;
	private HashMap <ManaColor, Integer> manaRichiesto;
	
	
	
	public CartaDTO() {
		this.manaRichiesto = new HashMap <ManaColor, Integer>();
	}
	public Integer getTurnoRichiesto() {
		return turnoRichiesto;
	}
	public void setTurnoRichiesto(Integer turnoRichiesto) {
		this.turnoRichiesto = turnoRichiesto;
	}
	public HashMap<ManaColor, Integer> getManaRichiesto() {
		return manaRichiesto;
	}
	public void setManaRichiesto(HashMap<ManaColor, Integer> manaRichiesto) {
		this.manaRichiesto = manaRichiesto;
	}
	
	
}
