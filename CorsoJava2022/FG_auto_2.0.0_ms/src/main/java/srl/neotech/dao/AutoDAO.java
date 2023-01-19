package srl.neotech.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import srl.neotech.dao.repository.AutoRepository;
import srl.neotech.dao.repository.AutoRepository2;
import srl.neotech.model.AccessorioDTO;
import srl.neotech.model.AutoDTO;

@Component
public class AutoDAO {

	@Autowired
	AutoRepository autoRepo;
	@Autowired
	AutoRepository2 autoRepo2;
	
	public Integer getIdCounter() {
		return autoRepo.getIdCounter();
	}
	
	public Integer getIdAccCounter() {
		return autoRepo.getIdAccCounter();
	}
	
	public void addAuto(AutoDTO auto) {
		autoRepo2.addAuto(auto);
		for (AccessorioDTO acc:auto.getAccessori()) {
			autoRepo2.addAccessorio(auto.getId(), acc);
			autoRepo.setIdAccCounter(getIdAccCounter()+1);
		}
		autoRepo.setIdCounter(getIdCounter()+1);
		//autoRepo.addAuto(auto);
	}
	
	public void removeAuto(String id) {
		autoRepo.removeAuto(id);
	}
	
	public HashMap<String, AutoDTO> getMappaAuto(){
		HashMap<String, AutoDTO>mappaAuto=new HashMap<String, AutoDTO>();
		List<AutoDTO>listaAuto=autoRepo2.getListaAuto();
		for (AutoDTO auto:listaAuto) {
			mappaAuto.put(auto.getId(), auto);
		}
		return mappaAuto;
		//return autoRepo.getMappaAuto();
	}
	
	public AutoDTO getAuto(String id) {
		//return autoRepo.getAuto(id);
		return autoRepo2.getAuto(id);
	}
	
	public void updateAuto(AutoDTO auto) {
		autoRepo.updateAuto(auto);
	}
}
