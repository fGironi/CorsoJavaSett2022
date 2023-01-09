package srl.neotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import srl.neotech.model.Utente;
import srl.neotech.requestresponse.MagoRequest;

@Controller
public class UtenteController {

	@Autowired
	Utente utente;
	
    @GetMapping(value="/profilo")
    public String getProfilo(ModelMap modelMap) {
    	if (utente.getMago()!=null) {
    		modelMap.addAttribute("mago", utente.getMago());
    		return "profilo";
    	}
    	else {
    		return "redirect:/nuovoProfilo";
    	}
    }
    
    @GetMapping(value="/nuovoProfilo")
    public String nuovoProfilo(ModelMap modelMap) {
    	MagoRequest magoReq=new MagoRequest();
		modelMap.addAttribute("magoReq", magoReq);
		
		return "nuovoProfilo";
    }
    
}
