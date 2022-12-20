package srl.neotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import srl.neotech.dao.repository.RepositoryAutomobili;
import srl.neotech.model.Alimentazione;
import srl.neotech.model.AutomobileDTO;
import srl.neotech.model.Colore;
import srl.neotech.model.Costruttore;
import srl.neotech.services.SaloneService;

@Controller
public class SaloneController {

	
	@Autowired
	RepositoryAutomobili repoAuto;
	
	@Autowired
	SaloneService salService;
	
	
	@GetMapping(value="/listaAuto")
	public String getListaAuto() {
		return "listaAuto";
	}
	@GetMapping(value="/rimozioneAuto")
	public String preRimozioneAuto() {
		return "rimuoviAuto";
	}
	@GetMapping(value="/aggiuntaAuto")
	public String preAggiuntaAuto(ModelMap modelMap) {
		//mi chiedo come gestire gli accessori, visto che vanno creati singolarmente anche loro
		AutomobileDTO automobile=new AutomobileDTO();		
		modelMap.addAttribute("automobile", automobile);
		modelMap.addAttribute("costruttori", Costruttore.values());
		modelMap.addAttribute("alimentazioni", Alimentazione.values());
		modelMap.addAttribute("colori", Colore.values());
		return "aggiungiAuto";
	}
	
	@PostMapping(value="/aggiungi")
	public String aggiuntaAuto(
		ModelMap modelMap,
		@ModelAttribute("automobile") AutomobileDTO automobile,
		BindingResult result) {
			if (result.hasErrors()) {
	            return "error";
	        }
			automobile.setId(salService.generaIdAuto());
			repoAuto.getListaAuto().put(automobile.getId(), automobile);
			System.out.println(automobile);
			return "redirect:home";
	}
	
	@GetMapping(value="/cercaAuto")
	public String cercaAuto() {
		return "cercaAuto";
	}
	@GetMapping(value="/dettaglioAuto")
	public String getDettaglioAuto() {
		return "dettaglioAuto";
	}
	
}
