package srl.neotech.model;

public enum EffettoMag {

	GHIACCIO("fa-icicles","conjelum", -2, TipologiaEff.CALORE, "congelato"),
	FREDDO("fa-snowflake","raffredh", -1, TipologiaEff.CALORE, "infreddolito"),
	TEMPNORM("fa-circle-check","", 0, TipologiaEff.CALORE, ""),
	CALDO("fa-temperature-three-quarters","scaaldum", 1, TipologiaEff.CALORE, "accaldato"),
	FUOCO("fa-fire","infuokari", 2, TipologiaEff.CALORE, "infuocato"),
	
	LIQUIDO("fa-droplet","scjolt", -2, TipologiaEff.SOLIDITA, "liquefatto"),
	MOLLO("fa-cloud", "soffish", -1, TipologiaEff.SOLIDITA, "molliccio"),
	SLDNORM("fa-circle-check","", 0, TipologiaEff.SOLIDITA, ""),
	RIGIDO("fa-cube", "dhur", 1, TipologiaEff.SOLIDITA, "irrigidito"),
	PIETRA("fa-gem", "roccium", 2, TipologiaEff.SOLIDITA, "pietrificato"),
	
	TOSSICO("fa-biohazard", "toxiy", -2, TipologiaEff.SALUTE, "intossicato"),
	VELENO("fa-virus", "vlenos", -1, TipologiaEff.SALUTE, "avvelenato"),
	SALNORM("fa-circle-check","", 0, TipologiaEff.SALUTE, ""),
	CURA("fa-heart", "guarish", 1, TipologiaEff.SALUTE, "in salute"),
	RIGENERA("fa-heart-circle-plus", "reegenehr", 2, TipologiaEff.SALUTE, "in ottima salute");
	
	private final String icoURL;
	private final String formula;
	private final Integer valore;
	private final TipologiaEff tipo;
	private final String stato;
	
	private EffettoMag(String icoURL, String formula, Integer valore, TipologiaEff tipo, String stato) {
		this.icoURL=icoURL;
		this.formula=formula;
		this.valore=valore;
		this.tipo=tipo;
		this.stato=stato;
	}
	
	public String getIcoURL() {
		return icoURL;
	}

	public String getFormula() {
		return formula;
	}

	public Integer getValore() {
		return valore;
	}

	public TipologiaEff getTipo() {
		return tipo;
	}

	public String getStato() {
		return stato;
	}
	
	
}
