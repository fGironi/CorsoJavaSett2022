package srl.neotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import srl.neotech.dao.MagiaDAO;
import srl.neotech.dao.repository.MagiaRepository;
import srl.neotech.model.Mago;
import srl.neotech.model.Utente;
import srl.neotech.requestresponse.MagoRequest;

@Controller
public class UtenteController {

	@Autowired
	Utente utente;
	
	@Autowired
	MagiaRepository magiaRepo;
	
	@Autowired
	MagiaDAO magiaDAO;	
	
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
    
    @PostMapping(value="/creaProfilo")
    public String creaProfilo(
    		ModelMap modelMap,
    		@ModelAttribute("magoReq") MagoRequest magoReq, 
    		BindingResult result) {
    	if (result.hasErrors()) {
            return "error";
        }
    	Mago mago=magiaDAO.nuovoUtente(magoReq);
    	utente.setMago(mago);
    	
    	
    	return "redirect:/game";
    }
    
    @GetMapping(value="login")
    public String login(@RequestParam String id) {
    	if (magiaRepo.getListaUtenti().containsKey(id)) {
    		Mago mago=magiaRepo.getListaUtenti().get(id);
    		utente.setMago(mago);
    	}
    	
    	return "redirect:/game";
    }
}
