package srl.neotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import srl.neotech.dao.ClasseDAO;
import srl.neotech.model.ClasseDTO;

@Controller
public class NavController {
	
	@Autowired
	ClasseDAO repoClasse;
	
	@GetMapping(value="/classe")
	public String vediClasse(ModelMap modelMap, @RequestParam String id) {
		if (repoClasse.getListaClassi().containsKey(id)) {
			ClasseDTO classe=repoClasse.getListaClassi().get(id);
			modelMap.addAttribute("classe", classe);
		return "classe";
		}
		else return "error";
		
		
	}

}
