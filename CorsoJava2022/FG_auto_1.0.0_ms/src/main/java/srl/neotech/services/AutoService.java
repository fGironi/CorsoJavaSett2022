package srl.neotech.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import srl.neotech.dao.AutoDAO;
import srl.neotech.model.AccessorioDTO;
import srl.neotech.model.AutoDTO;
import srl.neotech.requestresponse.RequestAddAuto;
import srl.neotech.requestresponse.RequestSearchAuto;

@Service
public class AutoService {

	@Autowired
	AutoDAO autoDAO;
	
	private String idGenerator() {
		Integer idCounter=autoDAO.getIdCounter();
		String zeros;
		if (idCounter>999) zeros="";
		else if (idCounter>99) zeros="0";
		else if (idCounter>9) zeros="00";
		else zeros="000";
		String newID="A"+zeros+idCounter;
		return newID;
	}
	
	private Integer costoCalculator(AutoDTO auto) {
		Integer costoAggiunto=0;
		for (AccessorioDTO acc:auto.getAccessori()) {
			costoAggiunto=costoAggiunto+acc.getCosto();
		}
		Integer costo= auto.getCostoBase()+costoAggiunto;
		return costo;
	}
	
	//In maniera sperimentale, imposto addAuto per tornare una String id da includere nella responseBase. 
	//Potrebbe essere una bad practice, ma in questo momento sono l'architetto di me stesso
	@Transactional 
	public String addAuto(RequestAddAuto request) {
		AutoDTO auto=new AutoDTO(
				request.getTarga(), request.getModello(), request.getColore(), 
				request.getAlimentazione(), request.getCostruttore(), request.getAnno(), request.getCostoBase());
		auto.setId(this.idGenerator());
		auto.getAccessori().addAll(request.getAccessori());
		auto.setCostoTot(this.costoCalculator(auto));
		autoDAO.addAuto(auto);
		return auto.getId();
		
	}
	
	@Transactional
	public void removeAuto(String id) {
		autoDAO.removeAuto(id);
	}
	
	public ArrayList<AutoDTO> getListaAuto(){
		ArrayList<AutoDTO> listaAuto=new ArrayList<AutoDTO>();
		HashMap<String, AutoDTO> mappaAuto = autoDAO.getMappaAuto();
		for (AutoDTO auto:mappaAuto.values()) {
			listaAuto.add(auto);
		}
		return listaAuto;
	}	
	
	public AutoDTO getAuto(String id) {
		return autoDAO.getAuto(id);
	}
	
	public ArrayList<AutoDTO> searchAuto(RequestSearchAuto request){
		ArrayList<AutoDTO> autoTrovate=new ArrayList<AutoDTO>();
		ArrayList <String> autoDaRimuovere=new ArrayList <String>();
		autoTrovate.addAll(autoDAO.getMappaAuto().values());
		System.out.println("aggiunte le auto alla lista di paragone, dimensione: "+autoTrovate.size());
		for (AutoDTO auto:autoTrovate) {
			if (request.getId()!=null && request.getId().isEmpty()==false) {
				System.out.println("l'utente ha inserito un id");
				if (auto.getId().contains(request.getId())==false) {
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			
			if (request.getTarga()!=null && request.getTarga().isEmpty()==false) {
				System.out.println("l'utente ha inserito una targa");
				if (auto.getTarga().contains(request.getTarga())==false) {
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (request.getCostruttore()!=null) {
				System.out.println("l'utente ha inserito un costruttore");
				if (request.getCostruttore().equals(auto.getCostruttore())==false){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (request.getModello()!=null && request.getModello().isEmpty()==false) {
				System.out.println("l'utente ha inserito un modello");
				//if (paragRicerca.getModello().equals(auto.getModello())==false){
				if (auto.getModello().contains(request.getModello())==false) {	
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (request.getAnnoMin()!=null) {
				if (request.getAnnoMin()>auto.getAnno()){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (request.getAnnoMax()!=null) {
				if (request.getAnnoMax()<auto.getAnno()){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (request.getCostoBaseMin()!=null) {
				if (request.getCostoBaseMin()>auto.getCostoBase()){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (request.getCostoBaseMax()!=null) {
				if (request.getCostoBaseMax()<auto.getCostoBase()){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (request.getCostoTotMin()!=null) {
				if (request.getCostoTotMin()>auto.getCostoTot()){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (request.getCostoTotMax()!=null) {
				if (request.getCostoTotMax()<auto.getCostoTot()){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (request.getAlimentazione()!=null) {
				if (request.getAlimentazione().equals(auto.getAlimentazione())==false){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (request.getColore()!=null && request.getColore().isEmpty()==false) {
				if (request.getColore().contains(auto.getColore())==false){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}	
			if (request.getAccessori()!=null && request.getAccessori().isEmpty()==false) {
				for (AccessorioDTO acc:request.getAccessori()) {
					if (auto.getAccessori().contains(acc)==false) {
						autoDaRimuovere.add(auto.getId());
						continue;
					}
				}
			}
		}
		for (String id:autoDaRimuovere) {
			AutoDTO autoRmv=autoDAO.getMappaAuto().get(id);
			if (autoTrovate.contains(autoRmv)) {
				autoTrovate.remove(autoRmv);
			}
		}
		return autoTrovate;
	}
	
}
