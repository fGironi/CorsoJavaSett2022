package srl.neotech.model;

public enum Importanza {

	FONDAMENTALE ("Fondamentale", 5),
	IMPORTANTE ("Importante", 4);
	
	
    private final String descrizione;   // 4humanz
    private final Integer valore; // in meters
    
    Importanza(String descrizione, Integer valore) {
    	this.descrizione=descrizione;
    	this.valore=valore;
        
    }
    private String descrizione() { return descrizione; }
    private Integer valore() { return valore; }
}
