package srl.neotech.dao.repository;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import srl.neotech.model.AutomobileDTO;

@Component
public class RepositoryAutomobili {

	private HashMap<String, AutomobileDTO> listaAuto;
	
	
	public RepositoryAutomobili(HashMap<String, AutomobileDTO> listaAuto) {
		this.listaAuto = new HashMap<String, AutomobileDTO>();
	}

	public HashMap<String, AutomobileDTO> getListaAuto() {
		return listaAuto;
	}

	public void setListaAuto(HashMap<String, AutomobileDTO> listaAuto) {
		this.listaAuto = listaAuto;
	}
}
