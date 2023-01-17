package srl.neotech.model;

public enum Colore {

	NERO ("nero"),
	NEROMETAL ("nero metallizzato"),
	NEROOPACO ("nero opaco"),
	
	BIANCO ("bianco"),
	BIANCOMETAL ("bianco metallizzato"),
	BIANCOOPACO ("bianco opaco"),
	
	GRIGIO ("grigio"),
	GRIGIOMETAL ("grigio metallizzato"),
	GRIGIOOPACO ("grigio opaco"),
	
	BLU ("blu"),
	BLUMETAL ("blu metallizzato"),
	BLUOPACO ("blu opaco"),
	
	VERDE ("verde"),
	VERDEMETAL ("verde metallizzato"),
	VERDEOPACO ("verde opaco"),
	
	ROSSO ("rosso"),
	ROSSOMETAL("rosso metallizzato"),
	ROSSOOPACO("rosso opaco"),
	
	GIALLO ("giallo"),
	GIALLOMETAL("giallo metallizzato"),
	GIALLOOPACO("giallo opaco"),
	
	MARRONE ("marrone"),
	MARRONEMETAL("marrone metallizzato"),
	MARRONEOPACO("marrone opaco"),
	
	ARANCIONE ("arancione"),
	ARANCIONEMETAL ("arancione metallizzato"),
	ARANCIONEOPACO ("arancione opaco"),
	
	VIOLA ("viola"),
	VIOLAMETAL ("viola metallizzato"),
	VIOLAOPACO ("viola opaco");
	
	private final String descrizione;
	 
	private Colore(String descrizione) {
	      this.descrizione = descrizione;
	   }

	public String getDescrizione() {
		return descrizione;
	}
}

