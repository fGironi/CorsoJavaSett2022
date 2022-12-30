package srl.neotech.landCount.model;

import java.util.ArrayList;

public interface UntapChecks {

	Boolean untapFirst(ArrayList<LandDTO> terre);
	Boolean untapSecond(ArrayList<LandDTO> terre);
	Boolean untapThird(ArrayList<LandDTO> terre);
	Boolean untapLate(ArrayList<LandDTO> terre);
}
