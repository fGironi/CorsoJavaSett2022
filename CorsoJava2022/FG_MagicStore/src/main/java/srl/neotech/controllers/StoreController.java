package srl.neotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import srl.neotech.model.Utente;
import srl.neotech.services.MagiaService;

@Controller
public class StoreController {

	@Autowired
	MagiaService magiaService;
	
	@Autowired
	Utente utente;
	
    @GetMapping(value="/banco")
    public String banco() {
    	if (utente.getMago()==null) {
    		return "redirect:/nuovoProfilo";
    	}
    	else return "banco";
    }
    
    @GetMapping(value="/studio")
    public String studio() {
    	if (utente.getMago()==null) {
    		return "redirect:/nuovoProfilo";
    	}
    	else return "studio";
    }
    
    @GetMapping(value="/imparaMagia")
    public String impara() {
    	magiaService.imparaNuovaMagia(utente.getMago());
    	magiaService.avanzaTempo(utente.getMago());
	    return "redirect:/studio";
    }
}
