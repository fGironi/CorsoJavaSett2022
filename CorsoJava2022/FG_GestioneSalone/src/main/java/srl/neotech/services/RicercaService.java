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


	
	public ArrayList<AutomobileDTO> confrontaAuto(RicercaRequest paragRicerca) {
		ArrayList <AutomobileDTO> autoTrovate=new ArrayList<AutomobileDTO>();
		ArrayList <String> autoDaRimuovere=new ArrayList <String>();
		autoTrovate.addAll(autoDao.getListaAuto().values());
		System.out.println("aggiunte le auto alla lista di paragone, dimensione: "+autoTrovate.size());
		for (AutomobileDTO auto:autoTrovate) {
			if (paragRicerca.getTarga()!=null && paragRicerca.getTarga().isEmpty()==false) {
				System.out.println("l'utente ha inserito una targa");
				if (paragRicerca.getTarga().equals(auto.getTarga())==false){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (paragRicerca.getCostruttore()!=null) {
				System.out.println("l'utente ha inserito un costruttore");
				if (paragRicerca.getCostruttore().equals(auto.getCostruttore())==false){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (paragRicerca.getModello()!=null && paragRicerca.getModello().isEmpty()==false) {
				System.out.println("l'utente ha inserito un modello");
				if (paragRicerca.getModello().equals(auto.getModello())==false){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (paragRicerca.getAnnoCostrMin()!=null) {
				if (paragRicerca.getAnnoCostrMin()>auto.getAnnoCostruzione()){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (paragRicerca.getAnnoCostrMax()!=null) {
				if (paragRicerca.getAnnoCostrMax()<auto.getAnnoCostruzione()){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (paragRicerca.getCostoBaseMin()!=null) {
				if (paragRicerca.getCostoBaseMin()>auto.getCostoBase()){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (paragRicerca.getCostoBaseMax()!=null) {
				if (paragRicerca.getCostoBaseMax()<auto.getCostoBase()){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (paragRicerca.getCostoMin()!=null) {
				if (paragRicerca.getCostoMin()>auto.getCosto()){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (paragRicerca.getCostoMax()!=null) {
				if (paragRicerca.getCostoMax()<auto.getCosto()){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (paragRicerca.getAlimentazione()!=null) {
				if (paragRicerca.getAlimentazione().equals(auto.getAlimentazione())==false){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}
			if (paragRicerca.getColore()!=null) {
				if (paragRicerca.getColore().equals(auto.getColore())==false){
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
