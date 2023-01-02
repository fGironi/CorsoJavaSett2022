package srl.neotech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreaController {

    @GetMapping(value="/creaStudente")
    public String setupCreaStud() {
        return "creaStudente";
    }
    
    @GetMapping(value="/creaConsegna")
    public String setupCreaCons() {
        return "creaConsegna";
    }
    
    @GetMapping(value="/creaClasse")
    public String setupCreaClasse() {
        return "creaClasse";
    }
	
}
