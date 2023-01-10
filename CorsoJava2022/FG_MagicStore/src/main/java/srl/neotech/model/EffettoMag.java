package srl.neotech.model;

public enum EffettoMag {

	CALDO("fa-temperature-three-quarters","scaaldum"),
	FUOCO("fa-fire","infuokari"),
	FREDDO("fa-snowflake","raffredh"),
	GHIACCIO("fa-icicles","conjelum"),
	
	LIQUIDO("fa-droplet","scjolt"),
	MOLLO("fa-cloud", "soffish"),
	RIGIDO("fa-cube", "dhur"),
	PIETRA("fa-gem", "roccium"),
	
	TOSSICO("fa-biohazard", "toxiy"),
	VELENO("fa-virus", "vlenos"),
	CURA("fa-heart", "guarish"),
	RIGENERA("fa-heart-circle-plus", "reegenehr");
	
	private final String icoURL;
	private final String formula;
	
	private EffettoMag(String icoURL, String formula) {
		this.icoURL=icoURL;
		this.formula=formula;
		
	}
	
	public String getIcoURL() {
		return icoURL;
	}

	public String getFormula() {
		return formula;
	}
}
