package srl.neotech.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.model.Giocatore;
import srl.neotech.model.PunteggioParola;

@Service
public class GiocatoreService {
	
	@Autowired
	UtenteAttivo utente;
	
	//Variabile di testing:
	private Integer contautenti=1;
	private HashMap<String, Giocatore> listaGiocatori=new HashMap<String, Giocatore>();
	
	public String assegnaIDUtente() {
		String nuovoID;
		if (this.contautenti<10) {
			nuovoID="00"+this.contautenti;
		}
		else if (this.contautenti<100){
			nuovoID="0"+this.contautenti;
		}
		else { 
			nuovoID=this.contautenti.toString();
		}
		this.contautenti++;
		return nuovoID;
		
	}
	
	public void regPunteggioParola(Giocatore gioc, String mode, Integer streak) {
		PunteggioParola punt=new PunteggioParola(mode, streak);
		gioc.getPunteggi().add(punt);
	}
	
	
	
	public void impostaUtenteAttivo(Giocatore giocatore) {
		utente.setId(giocatore.getId());
		utente.setProfiloGiocatore(giocatore);
	}

	
	
	public HashMap<String, Giocatore> getListaGiocatori() {
		return listaGiocatori;
	}

	public void setListaGiocatori(HashMap<String, Giocatore> listaGiocatori) {
		this.listaGiocatori = listaGiocatori;
	}


	public Integer getContautenti() {
		return contautenti;
	}


	public void setContautenti(Integer contautenti) {
		this.contautenti = contautenti;
	}
}
