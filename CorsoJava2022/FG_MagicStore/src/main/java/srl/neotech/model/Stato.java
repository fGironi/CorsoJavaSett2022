package srl.neotech.model;

public enum Stato {

	CALDO("fa-temperature-three-quarters", "accaldato"),
	FUOCO("fa-fire", "in fiamme"),
	FREDDO("fa-snowflake", "infreddolito"),
	GHIACCIO("fa-icicles", "congelato"),
	
	LIQUIDO("fa-glass-water-droplet", "liquefatto"),
	MOLLO("fa-droplet", "molliccio"),
	RIGIDO("fa-cube", "irrigidito"),
	PIETRA("fa-gem", "pietrificato"),
	
	TOSSICO("fa-biohazard", "intossicato"),
	VELENO("fa-xmarks-lines", "avvelenato"),
	CURA("fa-heart", "in salute"),
	RIGENERA("fa-heart-circle-plus", "in ottima salute");
	
	private final String icoURL;
	private final String descrizione;
	
	private Stato(String icoURL, String descrizione) {
		this.icoURL=icoURL;
		this.descrizione=descrizione;
		
	}
	
	public String getIcoURL() {
		return icoURL;
	}

	public String getDescrizione() {
		return descrizione;
	}
}
