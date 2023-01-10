package srl.neotech.model;

import java.time.LocalTime;
import java.util.ArrayList;

public class NegozioDTO {

	private LocalTime ora;
	private Integer giorno;
	private ArrayList<ClienteDTO> clientiAttuali;
	private ArrayList<ClienteDTO> clientiSoddisfatti;
	private ArrayList<ClienteDTO> clientiDelusi;
	private ArrayList<EffettoDTO> effettiPossibili;
	
	public NegozioDTO() {
		this.clientiAttuali = new ArrayList<ClienteDTO>();
		this.clientiSoddisfatti = new ArrayList<ClienteDTO>();
		this.clientiDelusi = new ArrayList<ClienteDTO>();
		this.effettiPossibili =new ArrayList<EffettoDTO>();
		
	}
	
	public LocalTime getOra() {
		return ora;
	}
	public void setOra(LocalTime ora) {
		this.ora = ora;
	}
	public Integer getGiorno() {
		return giorno;
	}
	public void setGiorno(Integer giorno) {
		this.giorno = giorno;
	}
	public ArrayList<ClienteDTO> getClientiAttuali() {
		return clientiAttuali;
	}
	public void setClientiAttuali(ArrayList<ClienteDTO> clientiAttuali) {
		this.clientiAttuali = clientiAttuali;
	}
	public ArrayList<ClienteDTO> getClientiSoddisfatti() {
		return clientiSoddisfatti;
	}
	public void setClientiSoddisfatti(ArrayList<ClienteDTO> clientiSoddisfatti) {
		this.clientiSoddisfatti = clientiSoddisfatti;
	}
	public ArrayList<ClienteDTO> getClientiDelusi() {
		return clientiDelusi;
	}
	public void setClientiDelusi(ArrayList<ClienteDTO> clientiDelusi) {
		this.clientiDelusi = clientiDelusi;
	}

	public ArrayList<EffettoDTO> getEffettiPossibili() {
		return effettiPossibili;
	}

	public void setEffettiPossibili(ArrayList<EffettoDTO> effettiPossibili) {
		this.effettiPossibili = effettiPossibili;
	}
	
	
	
}
