package srl.neotech.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import srl.neotech.services.GiocoService;

@Controller
public class GiochiController {
	
	@Autowired
	GiocoService gService;

    @RequestMapping(value="/parola", method = RequestMethod.GET)
    public String getGiocoParola(
    		ModelMap modelMap,
    		@RequestParam("mode") String mode
    		) {
    	modelMap.addAttribute("mode", mode);
    	
    	if (mode.equals("zelda")) {
    		ArrayList<String>listaZelda=gService.listaZelda();
    		modelMap.addAttribute("lista", listaZelda);
    	}
    	
    	if (mode.equals("pokemon")) {
    		ArrayList<String>listaPoke=gService.listaPoke();
    		modelMap.addAttribute("lista", listaPoke);
    	}
    	if (mode.equals("rock")) {
    		ArrayList<String>listaRock=gService.listaRock();
    		modelMap.addAttribute("lista", listaRock);
    	}
    	
    	
        return "parola";
    }
    @RequestMapping(value="/parolaIntro", method = RequestMethod.GET)
    public String getIntroParola() {
        return "parolaIntro";
    }
    
    @RequestMapping(value="/dajequattro", method = RequestMethod.GET)
    public String getGiocoQuattro() {
        return "quattro";
    }
}
