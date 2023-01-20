package srl.neotech.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import srl.neotech.dao.repository.AutoRepository;
import srl.neotech.dao.repository.AutoRepository2;
import srl.neotech.model.AccessorioDTO;
import srl.neotech.model.AutoDTO;
import srl.neotech.requestresponse.SearchAutoRequest;
import srl.neotech.requestresponse.UpdateAutoRequest;

@Component
public class AutoDAO {

	@Autowired
	AutoRepository autoRepo;
	@Autowired
	AutoRepository2 autoRepo2;
	
	public Integer getIdCounter() {
		return autoRepo2.getIdCounter("cAuto");
	}
	
	public Integer getIdAccCounter() {
		return autoRepo2.getIdCounter("cAcc");
	}
	
	public void increaseIDCounter() {
		autoRepo2.increaseIdCounter("cAuto");
	}
	public void increaseIDAccCounter() {
		autoRepo2.increaseIdCounter("cAcc");
	}
	
	public void addAuto(AutoDTO auto) {
		autoRepo2.addAuto(auto);
		for (AccessorioDTO acc:auto.getAccessori()) {
			autoRepo2.addAccessorio(auto.getId(), acc);
			autoRepo2.increaseIdCounter("cAcc");
			//autoRepo.setIdAccCounter(getIdAccCounter()+1);
		}
		autoRepo2.increaseIdCounter("cAuto");
		//autoRepo.setIdCounter(getIdCounter()+1);
		//autoRepo.addAuto(auto);
	}
	
	public void removeAuto(String id) {
		autoRepo2.removeAuto(id);
	}
	
	public HashMap<String, AutoDTO> getMappaAuto(){
		HashMap<String, AutoDTO>mappaAuto=new HashMap<String, AutoDTO>();
		List<AutoDTO>listaAuto=autoRepo2.getListaAuto();
		for (AutoDTO auto:listaAuto) {
			mappaAuto.put(auto.getId(), auto);
		}
		//opzione 1 di riempimento, richiede ogni volta la lista di accessori al DB
		for (String id:mappaAuto.keySet()) {
			this.assegnaAcc(id, mappaAuto.get(id));
		}
		//TODO: opzione 2, il db restituisce una lista tutti gli accessori, è il mio DAO che se li scorre e li assegna all'auto appropriata
		
		return mappaAuto;
		//return autoRepo.getMappaAuto();
	}
	
	public void assegnaAcc(String id, AutoDTO auto) {
		ArrayList<AccessorioDTO> listaAccessori=new ArrayList<AccessorioDTO>();
		List<AccessorioDTO> listaAcc_=autoRepo2.getAccessori(id);
		listaAccessori.addAll(listaAcc_);
		auto.setAccessori(listaAccessori);
	}
	
	public AutoDTO getAuto(String id) {
		//return autoRepo.getAuto(id);
		AutoDTO auto=autoRepo2.getAuto(id);
		ArrayList<AccessorioDTO> listaAccessori=new ArrayList<AccessorioDTO>();
		List<AccessorioDTO> listaAcc_=autoRepo2.getAccessori(id);
		listaAccessori.addAll(listaAcc_);
		auto.setAccessori(listaAccessori);
		return auto;
	}
	
	public void fakeUpdateAuto(AutoDTO auto) {
		autoRepo.updateAuto(auto);
	}
	
	public void updateAuto(UpdateAutoRequest request) {
		if (request.getAccessoriDaAggiungere()!=null) {
			for (AccessorioDTO acc:request.getAccessoriDaAggiungere())
			autoRepo2.addAccessorio(request.getId(), acc);
		}
		if (request.getIdAccessoriDaRimuovere()!=null) {
			for (Integer idAcc:request.getIdAccessoriDaRimuovere()) {
				autoRepo2.removeAccessorio(idAcc, request.getId());
			}
		}
		autoRepo2.updateAuto(request);
		
	}
	
	public void aggiornaCostoTot(String idAuto, Integer nuovoCostoTot) {
		autoRepo2.aggiornaCostoTot(idAuto, nuovoCostoTot);
	}
	
	public ArrayList<AutoDTO> searchAuto(SearchAutoRequest request){
		List<AutoDTO>listaAuto_=autoRepo2.searchAuto(request);
		ArrayList<AutoDTO> listaAuto=new ArrayList<AutoDTO>();
		listaAuto.addAll(listaAuto_);
		for (AutoDTO auto:listaAuto) {
			this.assegnaAcc(auto.getId(), auto);
		}
		return listaAuto;
	}
}
