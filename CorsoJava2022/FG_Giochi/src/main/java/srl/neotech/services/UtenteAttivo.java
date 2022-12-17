package srl.neotech.services;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import srl.neotech.model.Giocatore;

@SessionScope
@Component
public class UtenteAttivo {

	private String id;
	private Giocatore profiloGiocatore;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Giocatore getProfiloGiocatore() {
		return profiloGiocatore;
	}
	public void setProfiloGiocatore(Giocatore profiloGiocatore) {
		this.profiloGiocatore = profiloGiocatore;
	}
	
	
}
