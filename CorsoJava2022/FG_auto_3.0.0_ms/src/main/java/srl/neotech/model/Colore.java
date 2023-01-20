package srl.neotech.model;

public enum Colore {

	NERSTD ("nero"),
	NERMTL ("nero metallizzato"),
	NEROPC ("nero opaco"),
	
	BIASTD ("bianco"),
	BIAMTL ("bianco metallizzato"),
	BIAOPC ("bianco opaco"),
	
	GRISTD ("grigio"),
	GRIMTL ("grigio metallizzato"),
	GRIOPC ("grigio opaco"),
	
	BLUSTD ("blu"),
	BLUMTL ("blu metallizzato"),
	BLUOPC ("blu opaco"),
	
	VERSTD ("verde"),
	VERMTL ("verde metallizzato"),
	VEROPC ("verde opaco"),
	
	ROSSTD ("rosso"),
	ROSMTL ("rosso metallizzato"),
	ROSOPC ("rosso opaco"),
	
	GIASTD ("giallo"),
	GIAMTL ("giallo metallizzato"),
	GIAOPC ("giallo opaco"),
	
	MARSTD ("marrone"),
	MARMTL ("marrone metallizzato"),
	MAROPC ("marrone opaco"),
	
	ARASTD ("arancione"),
	ARAMTL ("arancione metallizzato"),
	ARAOPC ("arancione opaco"),
	
	VIOSTD ("viola"),
	VIOMTL ("viola metallizzato"),
	VIOOPC ("viola opaco");
	
	private final String descrizione;
	 
	private Colore(String descrizione) {
	      this.descrizione = descrizione;
	   }

	public String getDescrizione() {
		return descrizione;
	}
}

