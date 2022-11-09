package srl.neotech.calcoloEsameReviewed;

import java.util.HashMap;

public class Esame {

	private HashMap<String, Studente> studEsaminati;
	private Integer votoMinimo=18;

	//Alla creazione di un'istanza dell'esame viene anche creata una mappa vuota di studenti che hanno partecipato all'esame
	public Esame() { 
		super();
		this.studEsaminati=new HashMap<String,Studente>();
	}
	
	public Integer getVotoMinimo() {
		return votoMinimo;
	}

	public void setVotoMinimo(Integer votoMinimo) {
		this.votoMinimo = votoMinimo;
	}
	
	//valuta lo studente sulla base dei voti assegnati e ne imposta il valore stringa "risultato"
	public void valuta (Studente s) { 
		s.setVotoTotale(s.getVotoScritto()+s.getVotoOrale());
		if (s.getVotoScritto()<=0) s.setRisultato("bocciato");
		else if (s.getVotoOrale()<16) s.setRisultato("bocciato");
		else if (s.getVotoTotale()<this.votoMinimo) s.setRisultato("bocciato");
		else if (s.getVotoTotale()>30) s.setRisultato("promosso con lode!");
		else s.setRisultato("promosso");
	}

	public HashMap<String, Studente> getStudEsaminati() {
		return studEsaminati;
	}

	public void setStudEsaminati(HashMap<String, Studente> studEsaminati) {
		this.studEsaminati = studEsaminati;
	}
}
