package srl.neotech.landCount.model;

import java.util.HashMap;

public abstract class LandDTO implements UntapChecks{

	private Boolean isFetchable;
	private HashMap <ManaColor, Integer> manaAdded;
	private Boolean hasUtility;
	private String nome;
	
	
	
	public LandDTO() {
		this.manaAdded = new HashMap <ManaColor, Integer>();
	}
	
	public Boolean getIsFetchable() {
		return isFetchable;
	}
	public void setIsFetchable(Boolean isFetchable) {
		this.isFetchable = isFetchable;
	}
	public HashMap<ManaColor, Integer> getManaAdded() {
		return manaAdded;
	}
	public void setManaAdded(HashMap<ManaColor, Integer> manaAdded) {
		this.manaAdded = manaAdded;
	}

	public Boolean getHasUtility() {
		return hasUtility;
	}
	public void setHasUtility(Boolean hasUtility) {
		this.hasUtility = hasUtility;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
