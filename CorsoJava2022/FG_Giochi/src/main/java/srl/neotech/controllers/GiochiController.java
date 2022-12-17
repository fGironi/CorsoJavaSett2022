package srl.neotech.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import srl.neotech.model.Giocatore;
import srl.neotech.services.GiocatoreService;
import srl.neotech.services.GiocoParolaService;
import srl.neotech.services.UtenteAttivo;

@Controller
public class GiochiController {
	
	@Autowired
	GiocoParolaService parolaService;
	
	@Autowired
	GiocatoreService giocService;
	
	@Autowired
	UtenteAttivo utente;

    @GetMapping(value="/parola")
    public String getGiocoParola(
    		ModelMap modelMap,
    		@RequestParam("mode") String mode
    		) {
    	modelMap.addAttribute("mode", mode);
    	if (utente.getId()!=null) {
    		modelMap.addAttribute("id", utente.getProfiloGiocatore().getId());
    		modelMap.addAttribute("nomeUser", utente.getProfiloGiocatore().getNome());
    		modelMap.addAttribute("iconaUser", utente.getProfiloGiocatore().getIcona());
    	}
    	else {
    		modelMap.addAttribute("id", "null"); 	
    		modelMap.addAttribute("nomeUser", "anonimo");
    		modelMap.addAttribute("iconaUser", "fa-user");
    	}
    	
    	modelMap.addAttribute("lista", parolaService.modePicker(mode));
    	
        return "parola";
    }
    @GetMapping(value="/parolaIntro")
    public String getIntroParola(ModelMap modelMap) {
    	if (utente.getId()!=null) {
    		modelMap.addAttribute("id", utente.getId());
    		modelMap.addAttribute("nomeUser", utente.getProfiloGiocatore().getNome());
    		modelMap.addAttribute("iconaUser", utente.getProfiloGiocatore().getIcona());
    	}
    	else {
    		modelMap.addAttribute("id", "null"); 	
    		modelMap.addAttribute("nomeUser", "anonimo");
    		modelMap.addAttribute("iconaUser", "fa-user");
    	}
        return "parolaIntro";
    }
    
    @GetMapping(value="/dajequattro")
    public String getGiocoQuattro() {
        return "quattro";
    }
    //Controller verso la visualizzazione del profilo giocatore, ridireziona verso la modalità creazione se l'utente attivo non ha un id
    @GetMapping(value="/profiloUtente")
    public String profiloGiocatore(ModelMap modelMap) {
    	
    	if (utente.getId()!=null) {
    		modelMap.addAttribute("id", utente.getProfiloGiocatore().getId());
    		modelMap.addAttribute("nome", utente.getProfiloGiocatore().getNome());
    		modelMap.addAttribute("icona", utente.getProfiloGiocatore().getIcona());
    		modelMap.addAttribute("puntiParola", utente.getProfiloGiocatore().getPunteggi());
    		return "profiloGioc";
    	}
    	else {
    		Giocatore giocatoreDTO=new Giocatore();
        	modelMap.addAttribute("giocatoreDTO", giocatoreDTO);
    		return "nuovoProfilo";
    	}
    }
    
    @GetMapping(value="/nuovoProfilo")
    public String formGiocatore(ModelMap modelMap) {
    	Giocatore giocatoreDTO=new Giocatore();
    	modelMap.addAttribute("giocatoreDTO", giocatoreDTO);
    	return "nuovoProfilo";
    }
    
    @PostMapping(value="/creaProfiloGiocatore")
    public String creaNuovoGiocatore(@ModelAttribute("giocatoreDTO") 
 	Giocatore giocatoreDTO, 
 	ModelMap modelMap, 
 	BindingResult result) {  //parte copiata, non so bene cosa fa
        if (result.hasErrors()) {
            return "error";
        }
        modelMap.addAttribute("nome", giocatoreDTO.getNome());
		modelMap.addAttribute("icona", giocatoreDTO.getIcona());
        giocatoreDTO.setId(giocService.assegnaIDUtente());
        System.out.println("id assegnato a giocatoreDTO "+giocatoreDTO.getNome()+": "+giocatoreDTO.getId());
        giocService.getListaGiocatori().put(giocatoreDTO.getId(), giocatoreDTO);
        modelMap.addAttribute("id", giocatoreDTO.getId());
        giocService.impostaUtenteAttivo(giocatoreDTO);
    	return "profiloGioc";
    }
    
    @GetMapping(value="/disconnetti")
    public String disconnettiGiocatore() {
    	utente.setProfiloGiocatore(null);
    	utente.setId(null);
    	return "home";
    }
    
    @GetMapping(value="/login")
    public String connettiGiocatore(ModelMap modelMap, @RequestParam("id") String id) {
    	if (giocService.getListaGiocatori().containsKey(id)){
	    	Giocatore giocatore=giocService.getListaGiocatori().get(id);
	    	utente.setProfiloGiocatore(giocatore);
	    	utente.setId(giocatore.getId());
	    	return "home";
    	}
    	else {
    		Giocatore giocatoreDTO=new Giocatore();
        	modelMap.addAttribute("giocatoreDTO", giocatoreDTO);
        	modelMap.addAttribute("errore", "ATTENZIONE, L'ID INSERITO NON ESISTE");
        	return "nuovoProfilo";
    	}
    	
    }
    
    @GetMapping(value="/scoreParola")
    public String punteggioParola(
    		ModelMap modelMap, 
    		@RequestParam("mode") String mode, 
    		@RequestParam("streak") Integer streak){
    	giocService.regPunteggioParola(utente.getProfiloGiocatore(), mode, streak);
    	if (utente.getId()!=null) {
    		modelMap.addAttribute("id", utente.getProfiloGiocatore().getId());
    		modelMap.addAttribute("nome", utente.getProfiloGiocatore().getNome());
    		modelMap.addAttribute("icona", utente.getProfiloGiocatore().getIcona());
    		modelMap.addAttribute("puntiParola", utente.getProfiloGiocatore().getPunteggi());
    		
    		
    		return "profiloGioc";
    	}
    	else {
    		Giocatore giocatoreDTO=new Giocatore();
        	modelMap.addAttribute("giocatoreDTO", giocatoreDTO);
    		return "nuovoProfilo";
    	}
    }
    
}
