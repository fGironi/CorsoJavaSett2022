package srl.neotech.landCount.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Mazzo {
	
	private Integer numeroTerre;
	private HashMap<ManaColor, Integer> coloriRichiesti;
	private ArrayList<CartaDTO> carteCore;
	
	public Mazzo() {
		this.coloriRichiesti = new HashMap <ManaColor, Integer>();
		this.carteCore= new ArrayList<CartaDTO>();
	}
	
	public Integer getNumeroTerre() {
		return numeroTerre;
	}
	public void setNumeroTerre(Integer numeroTerre) {
		this.numeroTerre = numeroTerre;
	}
	public HashMap<ManaColor, Integer> getColoriRichiesti() {
		return coloriRichiesti;
	}
	public void setColoriRichiesti(HashMap<ManaColor, Integer> coloriRichiesti) {
		this.coloriRichiesti = coloriRichiesti;
	}
	public ArrayList<CartaDTO> getCarteCore() {
		return carteCore;
	}
	public void setCarteCore(ArrayList<CartaDTO> carteCore) {
		this.carteCore = carteCore;
	}

	
	
}
