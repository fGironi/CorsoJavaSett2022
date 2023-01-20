package srl.neotech.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import srl.neotech.dao.AutoDAO;
import srl.neotech.model.AccessorioDTO;
import srl.neotech.model.AutoDTO;
import srl.neotech.requestresponse.AddAutoRequest;
import srl.neotech.requestresponse.SearchAutoRequest;
import srl.neotech.requestresponse.UpdateAutoRequest;

@Service
public class AutoService {

	@Autowired
	AutoDAO autoDAO;
	
	public String idGenerator() {
		Integer idCounter=autoDAO.getIdCounter();
		String zeros;
		if (idCounter>999) zeros="";
		else if (idCounter>99) zeros="0";
		else if (idCounter>9) zeros="00";
		else zeros="000";
		String newID="A"+zeros+idCounter;
		return newID;
	}
	
	public Integer idAccGenerator() {
		Integer idCounter=autoDAO.getIdAccCounter();
		Integer newID=idCounter;
		return newID;
	}
	
	
	
	public Integer costoCalculator(AutoDTO auto) {
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
	public String addAuto(AddAutoRequest request) {
		AutoDTO auto=new AutoDTO(
				request.getTarga().toUpperCase(), request.getModello(), request.getColore(), 
				request.getAlimentazione(), request.getCostruttore(), request.getAnno(), request.getCostoBase());
		auto.setId(this.idGenerator());
		auto.getAccessori().addAll(request.getAccessori());
		for (AccessorioDTO acc:auto.getAccessori()) {
			acc.setId(this.idAccGenerator());
		}
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
	
	public ArrayList<AutoDTO> searchAuto(SearchAutoRequest request){
		return autoDAO.searchAuto(request);
	}
	
	public ArrayList<AutoDTO> fakeSearchAuto(SearchAutoRequest request){
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
				if (auto.getColore().getDescrizione().contains(request.getColore().toLowerCase())==false){
					System.out.println("l'auto "+auto.getId()+" non ha il parametro giusto ed è stata rimossa");
					autoDaRimuovere.add(auto.getId());
					continue;
				}
			}	
			//check accessori
			//nota: stranamente complicato da gestire, aggiungo commenti per spiegare la logica
			if (request.getAccessori()!=null && request.getAccessori().isEmpty()==false) { //Se è stata fatta una richiesta di ricerca riguardante gli accessori
				for (AccessorioDTO acc:request.getAccessori()) { //per ogni richiesta di accessorio (o di una sua caratteristica). Ad esempio "voglio un auto che abbia un accessorio SEDILI e l'entertainment CARPLAY"
					Boolean hasAcc=false; //metto come presupposto che l'auto in lista non abbia l'accessorio richiesto
					for (AccessorioDTO accAuto:auto.getAccessori()) { //controllo la singola richiesta per ogni accessorio presente sull'auto 
						if (acc.getCosto()!=null) { //se è stata fatta una richiesta riguardante questa caratteristica
							if (accAuto.getCosto().equals(acc.getCosto())==false) { //e l'accessorio che sto controllando non soddisfa la richiesta
								continue; //passo a controllare direttamente all'accessorio successivo presente sull'auto
							}
						}
						if (acc.getDescrizione()!=null && acc.getDescrizione().isEmpty()==false) {
							if (accAuto.getDescrizione().contains(acc.getDescrizione())==false) {
								continue;
								
							}
						}
						if (acc.getTipologia()!=null) {
							if (accAuto.getTipologia().equals(acc.getTipologia())==false) {
								continue;
							}
						}
						hasAcc=true; //se nessuno dei check precedenti ci ha fatto passare all'accessorio successivo, dichiaro che l'accessorio è stato trovato
									 //notare che nessuno dei check precedenti modifica la variabile hasAcc, quindi una volta che è stato trovato un match anche se continua a controllare non cambierà nulla
						//break;	 //potrebbe aver senso inserire un "break" per farlo passare direttamente all'accessorio richiesto successivo una volta che è stato trovato un match
						
					}
					if (hasAcc==false) { //se dopo aver controllato tutti gli accessori presenti sull'auto non ho trovato l'accessorio che è stato richiesto
						autoDaRimuovere.add(auto.getId()); //metto l'auto nella lista di auto da rimuovere
						break; //e passo direttamente al ciclo successivo di auto, anche se quella in questione dovesse avere altri degli accessori richiesti è sufficiente non averne uno per non essere inclusa nella lista
					}
				}
			}
		}
		//Rimozione auto dalla lista da tornare
		for (String id:autoDaRimuovere) {
			AutoDTO autoRmv=autoDAO.getMappaAuto().get(id);
			if (autoTrovate.contains(autoRmv)) {
				autoTrovate.remove(autoRmv);
			}
		}
		
		return autoTrovate;
	}
	
	@Transactional
	public void updateAuto(UpdateAutoRequest request) {
		if (request.getAccessoriDaAggiungere()!=null)	
			for (AccessorioDTO acc: request.getAccessoriDaAggiungere()) {
				acc.setId(this.idAccGenerator());
				autoDAO.increaseIDAccCounter();
			}
		autoDAO.updateAuto(request);
		if (request.getAccessoriDaAggiungere()!=null || request.getIdAccessoriDaRimuovere()!=null) {
			AutoDTO autoMod=autoDAO.getAuto(request.getId());
			autoDAO.aggiornaCostoTot(autoMod.getId(), this.costoCalculator(autoMod));
		}
	}
	
	@Transactional
	public void FakeUpdateAuto(UpdateAutoRequest request) {
		if (autoDAO.getMappaAuto().containsKey(request.getId())) {
			AutoDTO upAuto=new AutoDTO();	
			AutoDTO ogAuto=autoDAO.getMappaAuto().get(request.getId());
			upAuto.setId(ogAuto.getId());
			System.out.println("inizializzata modifica dell'auto "+upAuto.getId());
			if (request.getTarga()!=null && request.getTarga().isBlank()==false) {
				System.out.println("modifica della targa da "+upAuto.getTarga()+" a "+request.getTarga());
				upAuto.setTarga(request.getTarga());
				
			}
			else upAuto.setTarga(ogAuto.getTarga());
			
			if (request.getAlimentazione()!=null) {
				System.out.println("modifica dell'alimentazione da "+upAuto.getAlimentazione()+" a "+request.getAlimentazione());
				upAuto.setAlimentazione(request.getAlimentazione());
			}
			else upAuto.setAlimentazione(ogAuto.getAlimentazione());
			
			if (request.getCostruttore()!=null) {
				System.out.println("modifica del costruttore da "+upAuto.getCostruttore()+" a "+request.getCostruttore());
				upAuto.setCostruttore(request.getCostruttore());
			}
			else upAuto.setCostruttore(ogAuto.getCostruttore());
			
			if (request.getColore()!=null) {
				System.out.println("modifica dell'alimentazione da "+upAuto.getColore()+" a "+request.getColore());
				upAuto.setColore(request.getColore());
			}
			else upAuto.setColore(ogAuto.getColore());
			
			if (request.getCostoBase()!=null) {
				System.out.println("modifica del costo base da "+upAuto.getCostoBase()+" a "+request.getCostoBase());
				upAuto.setCostoBase(request.getCostoBase());
			}
			else upAuto.setCostoBase(ogAuto.getCostoBase());
			
			if (request.getModello()!=null && request.getModello().isBlank()==false) {
				System.out.println("modifica del modello da "+upAuto.getModello()+" a "+request.getModello());
				upAuto.setModello(request.getModello());
			}
			else upAuto.setModello(ogAuto.getModello());
			
			if (request.getAnno()!=null) {
				System.out.println("modifica dell'anno di immatricolazione da "+upAuto.getAnno()+" a "+request.getAnno());
				upAuto.setAnno(request.getAnno());
			}
			else upAuto.setAnno(ogAuto.getAnno());
			
			if (request.getAccessoriDaAggiungere()!=null && request.getAccessoriDaAggiungere().isEmpty()==false) {
				System.out.println("modifica degli accessori da "+upAuto.getAccessori().size()+" a "+request.getAccessoriDaAggiungere().size());
				//gli accessori si stanno rivelando un oggetto particolarmente complesso, meritevole di un sistema indipendente id aggiunta,
				//rimozione e quant'altro, probabilmente degno di un suo personale microservice
				upAuto.setAccessori(request.getAccessoriDaAggiungere());
				for (AccessorioDTO acc:upAuto.getAccessori()) {
					acc.setId(this.idAccGenerator());
				}
			}
			else upAuto.setAccessori(ogAuto.getAccessori());
			
			upAuto.setCostoTot(this.costoCalculator(upAuto));
			autoDAO.fakeUpdateAuto(upAuto);
		}
	}
}
