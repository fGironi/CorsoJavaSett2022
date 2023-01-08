package srl.neotech.dao.repository;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import srl.neotech.model.EffettoDTO;
import srl.neotech.model.Mago;

@Component
public class MagiaRepository {

	private ArrayList<EffettoDTO> listaEffetti;
	private HashMap <String, Mago> listaUtenti;
	
	public MagiaRepository() {
		this.listaUtenti=new HashMap <String, Mago>();
	}
	
	
	public ArrayList<EffettoDTO> getListaEffetti() {
		return listaEffetti;
	}

	public void setListaEffetti(ArrayList<EffettoDTO> listaEffetti) {
		this.listaEffetti = listaEffetti;
	}

	public HashMap <String, Mago> getListaUtenti() {
		return listaUtenti;
	}

	public void setListaUtenti(HashMap <String, Mago> listaUtenti) {
		this.listaUtenti = listaUtenti;
	}
	
	
}
