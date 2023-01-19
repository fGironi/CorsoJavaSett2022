package srl.neotech.dao.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import srl.neotech.model.AutoDTO;

@Repository
public class AutoRepository {

	private Integer idCounter;
	private Integer idAccCounter;
	private HashMap<String, AutoDTO> mappaAuto;
	
	public AutoRepository() {
		this.mappaAuto = new HashMap<String, AutoDTO>();
		this.idCounter=0;
		this.idAccCounter=0;
	}

	public HashMap<String, AutoDTO> getMappaAuto() {
		return mappaAuto;
	}

	public void setMappaAuto(HashMap<String, AutoDTO> mappaAuto) {
		this.mappaAuto = mappaAuto;
	}
	
	public void addAuto(AutoDTO auto) {
		this.mappaAuto.put(auto.getId(), auto);
	}
	
	public void removeAuto(String id) {
		this.mappaAuto.remove(id);
	}

	public Integer getIdCounter() {
		return idCounter;
	}

	public void setIdCounter(Integer idCounter) {
		this.idCounter = idCounter;
	}
	
	public AutoDTO getAuto(String id) {
		
		return this.mappaAuto.get(id);
	}

	public void updateAuto(AutoDTO auto) {
		this.mappaAuto.replace(auto.getId(), auto);
	}

	public Integer getIdAccCounter() {
		return idAccCounter;
	}

	public void setIdAccCounter(Integer idAccCounter) {
		this.idAccCounter = idAccCounter;
	}
	
}
