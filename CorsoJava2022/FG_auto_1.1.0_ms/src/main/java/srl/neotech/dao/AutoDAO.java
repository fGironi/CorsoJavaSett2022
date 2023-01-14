package srl.neotech.dao;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import srl.neotech.dao.repository.AutoRepository;
import srl.neotech.model.AutoDTO;

@Component
public class AutoDAO {

	@Autowired
	AutoRepository autoRepo;
	
	public Integer getIdCounter() {
		Integer idCounter=autoRepo.getIdCounter();
		return idCounter;
	}
	
	public void addAuto(AutoDTO auto) {
		autoRepo.addAuto(auto);
		autoRepo.setIdCounter(this.getIdCounter()+1);
	}
	
	public void removeAuto(String id) {
		autoRepo.removeAuto(id);
	}
	
	public HashMap<String, AutoDTO> getMappaAuto(){
		return autoRepo.getMappaAuto();
	}
	
	public AutoDTO getAuto(String id) {
		return autoRepo.getAuto(id);
	}
	
	public void updateAuto(AutoDTO auto) {
		autoRepo.updateAuto(auto);
	}
}
