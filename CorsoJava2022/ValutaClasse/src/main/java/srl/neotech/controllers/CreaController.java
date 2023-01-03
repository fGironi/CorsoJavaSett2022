package srl.neotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import srl.neotech.dao.ClasseDAO;
import srl.neotech.model.ClasseDTO;
import srl.neotech.model.forms.NuovaClasseForm;
import srl.neotech.services.PopolaClassiService;

@Controller
public class CreaController {
	
	@Autowired
	PopolaClassiService popClasServ;
	@Autowired
	ClasseDAO repoClasse;

    @GetMapping(value="/creaStudente")
    public String setupCreaStud(ModelMap modelMap) {
        return "creaStudente";
    }
    
    @GetMapping(value="/creaConsegna")
    public String setupCreaCons(ModelMap modelMap) {
    	
    	
        return "creaConsegna";
    }
    
    @GetMapping(value="/creaClasse")
    public String setupCreaClasse(ModelMap modelMap) {
    	ClasseDTO classe=new ClasseDTO();
    	NuovaClasseForm classeForm= new NuovaClasseForm(classe);
    	modelMap.addAttribute("classeForm", classeForm);
        return "creaClasse";
    }
    
    @PostMapping(value="/creazioneCl")
    public String creaClasse(ModelMap modelMap,
		@ModelAttribute("classeForm") NuovaClasseForm classeForm,
		BindingResult result) {
			if (result.hasErrors()) {
	            return "error";
	        }
			popClasServ.classeFormBinder(classeForm);
			
			
		return "redirect:/classe?id="+classeForm.getClasse().getId();
    }
	
}
