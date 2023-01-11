package srl.neotech.dao.repository;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import srl.neotech.model.EffettoDTO;
import srl.neotech.model.MagiaDTO;
import srl.neotech.model.Mago;

@Component
public class MagiaRepository {

	private ArrayList<EffettoDTO> listaEffetti;
	private HashMap <String, Mago> listaUtenti;
	private ArrayList<MagiaDTO> listaMagie;
	
	
	public MagiaRepository() {
		super();
		this.listaEffetti = this.creaListaEffetti();
		this.setListaMagie(null);
		this.listaUtenti = new HashMap <String, Mago>();
	}

	
	public ArrayList<EffettoDTO> creaListaEffetti() {
		ArrayList<EffettoDTO> listaEffetti=new ArrayList<EffettoDTO>();
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				for (int k=0; k<5; k++) {
					EffettoDTO e=new EffettoDTO();
					e.setCalore(i);	e.setSalute(k);	e.setSolidita(j);
					if ((e.getCalore()==3 && e.getSalute()==2 && e.getSolidita()==2)||(e.getCalore()==2 && e.getSalute()==3 && e.getSolidita()==2)|| (e.getCalore()==2 && e.getSalute()==2 && e.getSolidita()==3)) {
						System.out.println("effetto di base non aggiunto alla lista");
					}
					else if ((e.getCalore()==1 && e.getSalute()==2 && e.getSolidita()==2)||(e.getCalore()==2 && e.getSalute()==1 && e.getSolidita()==2)|| (e.getCalore()==2 && e.getSalute()==2 && e.getSolidita()==1)) {
						System.out.println("effetto di base non aggiunto alla lista");
					}
					else {
						System.out.println("aggiunto effetto "+e.getCalore()+""+e.getSolidita()+""+e.getSalute());
						listaEffetti.add(e);
					}
				}
			}
		}
		System.out.println("lista effetti completa. numero effetti: "+listaEffetti.size());
		return listaEffetti;
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


	public ArrayList<MagiaDTO> getListaMagie() {
		return listaMagie;
	}


	public void setListaMagie(ArrayList<MagiaDTO> listaMagie) {
		this.listaMagie = listaMagie;
	}
	
	
}
