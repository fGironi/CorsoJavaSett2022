package srl.neotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import srl.neotech.dao.ClasseDAO;


@Controller
public class HomeController {

	@Autowired
	ClasseDAO repoClasse;
	
    //Rotta per la home
    @GetMapping(value="/")
    public String home(ModelMap modelMap) {
    	modelMap.addAttribute("listaClassi", repoClasse.getListaClassi());
        return "home";
    }
    
   
}
