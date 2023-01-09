package srl.neotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import srl.neotech.model.Utente;


@Controller
public class HomeController {

	@Autowired
	Utente utente;
	
    //Rotta per la home
    @GetMapping(value="/")
    public String home() {
    	if (utente.getMago()!=null) {
    		return "redirect:/game";
    	}
        return "home";
    }
    
    @GetMapping(value="/game")
    public String game(ModelMap modelMap) {
    	modelMap.addAttribute("mago", utente.getMago());
    	return "game";
    }
   
}
