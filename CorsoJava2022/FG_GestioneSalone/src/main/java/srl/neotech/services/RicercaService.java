package srl.neotech.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.dao.repository.AutomobiliRepository;
import srl.neotech.model.AutomobileDTO;
import srl.neotech.requestresponse.RicercaRequest;

@Service
public class RicercaService {

	
	@Autowired
	SaloneService salService;
	@Autowired
	AutomobiliRepository autoDao;


	
	public ArrayList<AutomobileDTO> confrontaAuto(RicercaRequest request) {
		ArrayList <AutomobileDTO> autoTrovate=new ArrayList<AutomobileDTO>();
		ArrayList <String> autoDaRimuovere=new ArrayList <String>();
		autoTrovate.addAll(autoDao.getListaAuto().values());
		System.out.println("aggiunte le auto alla lista di paragone, dimensione: "+autoTrovate.size());
		for (AutomobileDTO auto:autoTrovate) {
			if (request.getTarga()!=null && request.getTarga().isEmpty()==false) {
				System.out.println("l'utente ha inserito una targa");
				//if (paragRicerca.getTarga().equals(auto.getTarga())==false){
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
			if (request.getAnnoCostrMin()!=null) {
				if (request.getAnnoCostrMin()>auto.getAnnoCostruzione()){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (request.getAnnoCostrMax()!=null) {
				if (request.getAnnoCostrMax()<auto.getAnnoCostruzione()){
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
			if (request.getCostoMin()!=null) {
				if (request.getCostoMin()>auto.getCosto()){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (request.getCostoMax()!=null) {
				if (request.getCostoMax()<auto.getCosto()){
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
			if (request.getColore()!=null) {
				if (request.getColore().equals(auto.getColore())==false){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}	
		}
		for (String id:autoDaRimuovere) {
			AutomobileDTO auto=autoDao.getListaAuto().get(id);
			if (autoTrovate.contains(auto)) {
				autoTrovate.remove(auto);
			}
		}
		System.out.println("dopo la rimozione il numero di auto trovate è "+autoTrovate.size());
		return autoTrovate;
		
		
	}
	
	
	

	
	
}
