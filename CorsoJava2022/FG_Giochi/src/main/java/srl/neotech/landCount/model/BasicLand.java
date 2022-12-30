package srl.neotech.landCount.model;

import java.util.ArrayList;

public class BasicLand extends LandDTO{

	public BasicLand() {
		super();
		this.setHasUtility(false);
		this.setIsFetchable(true);
		this.setNome("base");
			
	}
	
	public BasicLand(ManaColor color) {
		super();
		this.setHasUtility(false);
		this.setIsFetchable(true);
		this.getManaAdded().put(color, 1);
		this.setNome("base");
	}

	@Override
	public Boolean untapFirst(ArrayList<LandDTO> terre) {
		return true;
	}

	@Override
	public Boolean untapSecond(ArrayList<LandDTO> terre) {
		return true;
	}

	@Override
	public Boolean untapThird(ArrayList<LandDTO> terre) {
		
		return true;
	}

	@Override
	public Boolean untapLate(ArrayList<LandDTO> terre) {
		
		return true;
	}
}
