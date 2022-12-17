package srl.neotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import srl.neotech.testing.TestComponentUtente;
import srl.neotech.testing.TestModelOggetto;
import srl.neotech.testing.TestService;

@Controller
public class TestController {

	@Autowired
	TestComponentUtente utente;
	@Autowired
	TestService service;
	
	 @GetMapping(value="/test")
	    public String testSpringLog(ModelMap modelMap) {
		 service.assegnaCodiceInventario(utente.getInventario());
		 String codiceInv=utente.getInventario().getCodiceInventario();
		 //String mostruosita="";
		 // for (String id: service.getMapOgg().keySet()) {
		 //	 TestModelOggetto ogg=service.getMapOgg().get(id);
		 //	 mostruosita=mostruosita+"<option value=\""+ogg.getId()+"\">"+ogg.getNome()+"</option>";
		 //}
		 modelMap.addAttribute("oggetti", service.getMapOgg());
		 modelMap.addAttribute("codiceInv", codiceInv);
	        return "test";
	    }
	
	 @GetMapping(value="/testAdd")
	    public String testSpringAdd(@RequestParam("idOgg") String idOgg) {
		 TestModelOggetto oggettoPreso=service.getMapOgg().get(idOgg);		 
		 service.aggiungiOggetto(utente.getInventario(), oggettoPreso);
		 return "testAdd";
	    }

	 @RequestMapping(value="/testPrint/{idInv}")
	    public String testSpringPrint(
	    		@PathVariable("idInv") String idInv,
	    		ModelMap modelMap
	    		) {
		 String codInvCorr=utente.getInventario().getCodiceInventario();
		 if (idInv.equals(codInvCorr)) {
			 modelMap.addAttribute("inventario", service.stampaInventario(utente.getInventario()));
		 }
		 else {
			 System.out.println("inserito codice sbagliato:"+idInv+", codice corretto="+codInvCorr+".");
			 modelMap.addAttribute("inventario", "inserito codice sbagliato");
		 }
		 return "testPrint";
	    }
	 
	 @RequestMapping(value="/testCalc")
	    public String testSpringCalc(ModelMap modelMap) {
		 
		 modelMap.addAttribute("totale", service.calcolaValoreInventario(utente.getInventario()));
		 return "testCalc";
	    }
	 
	 @RequestMapping(value="/testForm")
	 	public String testSpringForm(ModelMap modelMap) {
		 TestModelOggetto oggettoDTO=new TestModelOggetto();
		 modelMap.addAttribute("oggettoDTO", oggettoDTO);
		  return "testForm";
	    }
	
	 
	 @PostMapping(value="/testPost")
	 	public String testSpringPost(@ModelAttribute("oggettoDTO") 
	 	TestModelOggetto oggettoDTO, 
	 	ModelMap modelMap, 
	 	BindingResult result) {  //parte copiata, non so bene cosa fa
	        if (result.hasErrors()) {
	            return "error";
	        }
	     service.assegnaIdOggetto(oggettoDTO);
		 modelMap.addAttribute("id", oggettoDTO.getId());
		 modelMap.addAttribute("nome", oggettoDTO.getNome());
		 modelMap.addAttribute("valore", oggettoDTO.getValore());
		 modelMap.addAttribute("note", oggettoDTO.getNote());
		 service.getMapOgg().put(oggettoDTO.getId(), oggettoDTO);
		 return "testPost";
	 }
}
