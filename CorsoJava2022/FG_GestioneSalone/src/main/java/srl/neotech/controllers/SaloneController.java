package srl.neotech.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import srl.neotech.dao.repository.AccessoriRepository;
import srl.neotech.dao.repository.AutomobiliRepository;
import srl.neotech.model.Alimentazione;
import srl.neotech.model.AutomobileDTO;
import srl.neotech.model.Colore;
import srl.neotech.model.Costruttore;
import srl.neotech.model.FormAutoDTO;
import srl.neotech.model.MultiRemoverDTO;
import srl.neotech.model.ParagoneRicerca;
import srl.neotech.model.Tipologia;
import srl.neotech.services.RicercaService;
import srl.neotech.services.SaloneService;

@Controller
public class SaloneController {

	
	@Autowired
	AutomobiliRepository repoAuto;
	@Autowired
	AccessoriRepository repoAcces;
	@Autowired
	SaloneService salService;
	@Autowired
	RicercaService ricService;
	@Autowired
	ParagoneRicerca paragRicerca;
	
	
	@GetMapping(value="/listaAuto")
	public String getListaAuto(ModelMap modelMap) {
		modelMap.addAttribute("listaAuto", repoAuto.getListaAuto());
		return "listaAuto";
	}

	@GetMapping(value="/aggiuntaAuto")
	public String preAggiuntaAuto(ModelMap modelMap) {
		AutomobileDTO automobile=new AutomobileDTO();
		FormAutoDTO formAuto=new FormAutoDTO(automobile);
		modelMap.addAttribute("formAuto", formAuto);
		modelMap.addAttribute("costruttori", Costruttore.values());
		modelMap.addAttribute("alimentazioni", Alimentazione.values());
		modelMap.addAttribute("colori", Colore.values());
		modelMap.addAttribute("accIntrattenimento", salService.sottoListaAccessori(repoAcces.getElencoAccessori(), Tipologia.intrattenimento));
		modelMap.addAttribute("accTappezzeria", salService.sottoListaAccessori(repoAcces.getElencoAccessori(), Tipologia.tappezzeria));
		modelMap.addAttribute("accCerchi", salService.sottoListaAccessori(repoAcces.getElencoAccessori(), Tipologia.cerchi));
		modelMap.addAttribute("accTettino", salService.sottoListaAccessori(repoAcces.getElencoAccessori(), Tipologia.tettino));
		modelMap.addAttribute("accCarrozzeria", salService.sottoListaAccessori(repoAcces.getElencoAccessori(), Tipologia.carrozzeria));
		modelMap.addAttribute("accSicurezza", salService.sottoListaAccessori(repoAcces.getElencoAccessori(), Tipologia.sicurezza));
		modelMap.addAttribute("accComfort", salService.sottoListaAccessori(repoAcces.getElencoAccessori(), Tipologia.comfort));
		
		return "aggiungiAuto";
	}
	
	@PostMapping(value="/aggiungi")
	public String aggiuntaAuto(
		ModelMap modelMap,
		@ModelAttribute("formAuto") FormAutoDTO formAuto,
		BindingResult result) {
			if (result.hasErrors()) {
	            return "error";
	        }
			AutomobileDTO automobile=formAuto.getAutomobile();
			for (String s:formAuto.getIdAccessori()) {
				System.out.println("segnato accessorio "+s);
			}
			automobile.setId(salService.generaIdAuto());
			repoAuto.getListaAuto().put(automobile.getId(), automobile);
			System.out.println("creata nuova auto "+automobile);
			salService.assegnaAccessori(automobile, formAuto);
			automobile.setCosto(salService.costoConAccessori(automobile));
						
			return "redirect:confermaCreazione?autoId="+automobile.getId();
	}
	
	@GetMapping(value="/confermaCreazione")
	public String aggiuntaAcc(
			ModelMap modelMap,
			@RequestParam String autoId
			) {
		modelMap.addAttribute("automobile", repoAuto.getListaAuto().get(autoId));
		modelMap.addAttribute("accessori", repoAcces.getElencoAccessori());
		return "confermaCreazione";
	}
	
	@GetMapping(value="/cercaAuto")
	public String risultatiCercaAuto(ModelMap modelMap) {
		
		modelMap.addAttribute("paragoneRicerca", paragRicerca);
		modelMap.addAttribute("costruttori", Costruttore.values());
		modelMap.addAttribute("alimentazioni", Alimentazione.values());
		modelMap.addAttribute("colori", Colore.values());
		System.out.println("inizializzata ricerca, paragone:");
		System.out.println(paragRicerca);
		return "cercaAuto";
	}
	
	@PostMapping(value="/cerca")
	public String getCercaAuto(
			ModelMap modelMap,
			@ModelAttribute("paragoneRicerca") ParagoneRicerca paragRicerca) {
		System.out.println("l'utente ha effettuato una ricerca, paragone:");
		System.out.println(paragRicerca);
		ricService.confrontaAuto(paragRicerca);
		modelMap.addAttribute("paragoneRicerca", paragRicerca);
		
		return "cercaAuto";
	}
	
	
	@GetMapping(value="/dettaglioAuto")
	public String getDettaglioAuto(@RequestParam String idAuto, ModelMap modelMap) {
		AutomobileDTO automobile=repoAuto.getListaAuto().get(idAuto);
		modelMap.addAttribute("automobile", automobile);
		return "dettaglioAuto";
	}

	
	@GetMapping(value="/rimozioneAuto")
	public String preRimozioneAuto(ModelMap modelMap) {
		MultiRemoverDTO multiRemover=new MultiRemoverDTO();
		modelMap.addAttribute("multiRemover", multiRemover);
		modelMap.addAttribute("listaAuto", repoAuto.getListaAuto());
		
		return "rimuoviAuto";
	}	
	
	@GetMapping(value="/confermaRimozione")
	public String confRimozione(@RequestParam String idAuto, ModelMap modelMap) {
		AutomobileDTO automobile=repoAuto.getListaAuto().get(idAuto);
		modelMap.addAttribute("automobile", automobile);
		return "confermaRimozione";
	}
	
	@GetMapping(value="/rimozione")
	public String rimozione(@RequestParam String idAuto) {
		repoAuto.getListaAuto().remove(idAuto);
		System.out.println("rimossa l'auto "+idAuto);
		return "redirect:listaAuto";
	}
	
	@PostMapping(value="rimozioneMultipla")
	public String multiRemove(ModelMap modelMap, @ModelAttribute("multiRemover") MultiRemoverDTO multiRemover,
			BindingResult result) {
		if (result.hasErrors()) {
            return "error";
        }
		ArrayList<AutomobileDTO> listaRimozione=salService.sottoListaAuto(multiRemover.getRemoveIdList());
		MultiRemoverDTO multiRemoverConfirmed=new MultiRemoverDTO();
		modelMap.addAttribute("listaRimozione", listaRimozione);
		modelMap.addAttribute("multiRemoverConfirmed", multiRemoverConfirmed);
		return "confermaMultiRimozione";
	}
	
	@PostMapping(value="rimozioneMultiplaConfermata")
	public String multiRemoveConfirmed(ModelMap modelMap, @ModelAttribute("multiRemoverConfirmed") MultiRemoverDTO multiRemoverConfirmed,
			BindingResult result) {
		if (result.hasErrors()) {
            return "error";
        }
		for (String s:multiRemoverConfirmed.getRemoveIdList()) {
			if (repoAuto.getListaAuto().containsKey(s)) {
				repoAuto.getListaAuto().remove(s);
			}
		}
		
		return "redirect:/listaAuto";
	}
	
	
	
	@GetMapping(value="/modifica")
	public String modifica(@RequestParam String idAuto,	ModelMap modelMap) {
		AutomobileDTO automobile=repoAuto.getListaAuto().get(idAuto);
		System.out.println("iniziata la modifica dell'auto "+automobile.getId());
		FormAutoDTO formAuto=new FormAutoDTO(automobile);
		modelMap.addAttribute("idAuto", idAuto);
		modelMap.addAttribute("formAuto", formAuto);
		modelMap.addAttribute("costruttori", Costruttore.values());
		modelMap.addAttribute("alimentazioni", Alimentazione.values());
		modelMap.addAttribute("colori", Colore.values());
		modelMap.addAttribute("accPresenti", automobile.getAccessori());
		modelMap.addAttribute("accIntrattenimento", salService.sottoListaAccessori(repoAcces.getElencoAccessori(), Tipologia.intrattenimento));
		modelMap.addAttribute("accTappezzeria", salService.sottoListaAccessori(repoAcces.getElencoAccessori(), Tipologia.tappezzeria));
		modelMap.addAttribute("accCerchi", salService.sottoListaAccessori(repoAcces.getElencoAccessori(), Tipologia.cerchi));
		modelMap.addAttribute("accTettino", salService.sottoListaAccessori(repoAcces.getElencoAccessori(), Tipologia.tettino));
		modelMap.addAttribute("accCarrozzeria", salService.sottoListaAccessori(repoAcces.getElencoAccessori(), Tipologia.carrozzeria));
		modelMap.addAttribute("accSicurezza", salService.sottoListaAccessori(repoAcces.getElencoAccessori(), Tipologia.sicurezza));
		modelMap.addAttribute("accComfort", salService.sottoListaAccessori(repoAcces.getElencoAccessori(), Tipologia.comfort));
		
		return "modificaAuto";
	}
	
	@PostMapping(value="/modifica")
	public String modificaPost(ModelMap modelMap, @ModelAttribute("formAuto") FormAutoDTO formAuto,
			BindingResult result) {
		if (result.hasErrors()) {
            return "error";
        }
		AutomobileDTO automobile=formAuto.getAutomobile();
		for (String s:formAuto.getIdAccessori()) {
			System.out.println("segnato accessorio "+s);
		}
		
		if (repoAuto.getListaAuto().containsKey(formAuto.getIdAutoMod())) {
			automobile.setId(formAuto.getIdAutoMod());
			System.out.println("ricevuto dal server il form con l'auto modificata "+automobile);
			System.out.println("sostituzione");
			repoAuto.getListaAuto().replace(automobile.getId(), automobile);
		}
		salService.assegnaAccessori(automobile, formAuto);
		automobile.setCosto(salService.costoConAccessori(automobile));
					
		return "redirect:confermaCreazione?autoId="+automobile.getId();
	}
}
