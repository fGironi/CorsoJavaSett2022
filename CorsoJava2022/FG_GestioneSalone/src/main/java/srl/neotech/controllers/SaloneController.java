package srl.neotech.controllers;

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
import srl.neotech.model.Tipologia;
import srl.neotech.services.SaloneService;

@Controller
public class SaloneController {

	
	@Autowired
	AutomobiliRepository repoAuto;
	@Autowired
	AccessoriRepository repoAcces;
	@Autowired
	SaloneService salService;
	
	
	@GetMapping(value="/listaAuto")
	public String getListaAuto(ModelMap modelMap) {
		modelMap.addAttribute("listaAuto", repoAuto.getListaAuto());
		return "listaAuto";
	}
	@GetMapping(value="/rimozioneAuto")
	public String preRimozioneAuto(ModelMap modelMap) {
		modelMap.addAttribute("listaAuto", repoAuto.getListaAuto());
		return "rimuoviAuto";
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
			salService.assegnaAccessori(automobile, formAuto);
			automobile.setCosto(salService.costoConAccessori(automobile));
			repoAuto.getListaAuto().put(automobile.getId(), automobile);
			System.out.println(automobile);
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
	public String cercaAuto() {
		return "cercaAuto";
	}
	@GetMapping(value="/dettaglioAuto")
	public String getDettaglioAuto(@RequestParam String idAuto, ModelMap modelMap) {
		AutomobileDTO automobile=repoAuto.getListaAuto().get(idAuto);
		modelMap.addAttribute("automobile", automobile);
		return "dettaglioAuto";
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
	
}
