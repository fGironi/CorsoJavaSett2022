package srl.neotech.model;

public enum iconaMag {

	CALDO("fa-temperature-three-quarters"),
	FUOCO("fa-fire"),
	FREDDO("fa-snowflake"),
	GHIACCIO("fa-icicles"),
	
	LIQUIDO("fa-glass-water-droplet"),
	MOLLO("fa-droplet"),
	RIGIDO("fa-cube"),
	PIETRA("fa-gem"),
	
	VELENO("fa-xmarks-lines"),
	TOSSICO("fa-biohazard"),
	CURA("fa-heart"),
	RIGENERA("fa-heart-circle-plus");
	
	
	
	private final String icoURL;

	private iconaMag(String icoURL) {
		this.icoURL=icoURL;
		
	}
	
	public String getIcoURL() {
		return icoURL;
	}
}
