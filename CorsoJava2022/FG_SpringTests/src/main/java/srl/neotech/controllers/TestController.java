package srl.neotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import srl.neotech.testing.TestComponentOggetto;
import srl.neotech.testing.TestComponentUtente;
import srl.neotech.testing.TestService;

@Controller
public class TestController {

	@Autowired
	TestComponentUtente utente;
	@Autowired
	TestService service;
	
	 @RequestMapping(value="/test")
	    public String testSpringLog(ModelMap modelMap) {
		 service.assegnaCodiceInventario(utente.getInventario());
		 String codiceInv=utente.getInventario().getCodiceInventario();
		 modelMap.addAttribute("codiceInv", codiceInv);
	        return "test";
	    }
	
	 @GetMapping(value="/testAdd")
	    public String testSpringAdd(@RequestParam("idOgg") String idOgg) {
		 TestComponentOggetto oggettoPreso=service.getMapOgg().get(idOgg);		 
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
}
