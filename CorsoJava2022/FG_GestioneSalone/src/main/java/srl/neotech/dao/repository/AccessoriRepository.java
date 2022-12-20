package srl.neotech.dao.repository;

import java.util.HashMap;

import org.springframework.stereotype.Component;
import srl.neotech.model.AccessorioDTO;



@Component
public class AccessoriRepository {

	private HashMap<String, AccessorioDTO> elencoAccessori;

	public AccessoriRepository() {
		this.elencoAccessori = new HashMap<String, AccessorioDTO>();
	}

	public HashMap<String, AccessorioDTO> getElencoAccessori() {
		return elencoAccessori;
	}

	public void setElencoAccessori(HashMap<String, AccessorioDTO> elencoAccessori) {
		this.elencoAccessori = elencoAccessori;
	}
	
	
}
