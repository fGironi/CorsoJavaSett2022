package srl.neotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import srl.neotech.model.Giocatore;
import srl.neotech.model.PartitaParolaDTO;
import srl.neotech.services.GiocatoreService;
import srl.neotech.services.GiocoParolaService;
import srl.neotech.services.UtenteAttivo;

@Controller
public class ParolaController {

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
    	PartitaParolaDTO partita;
    	
    	if (utente.getId()!=null) {
    		modelMap.addAttribute("id", utente.getProfiloGiocatore().getId());
    		modelMap.addAttribute("nomeUser", utente.getProfiloGiocatore().getNome());
    		modelMap.addAttribute("iconaUser", utente.getProfiloGiocatore().getIcona());
    		partita=parolaService.checkPartitaInCorso(utente.getProfiloGiocatore(), mode);
    	}
    	else {
    		modelMap.addAttribute("id", "null"); 	
    		modelMap.addAttribute("nomeUser", "anonimo");
    		modelMap.addAttribute("iconaUser", "fa-user");
    		partita=parolaService.anonPartita(mode);
    	}
    	
    	
    	modelMap.addAttribute("mode", mode);
    	modelMap.addAttribute("parola", partita.getParolaInCorso());
    	modelMap.addAttribute("vite", partita.getVite());
    	modelMap.addAttribute("streak", partita.getCurrentStreak());
    	System.out.println("parolascelta="+partita.getParolaInCorso());
        return "parola";
    }
    
    @GetMapping(value="/parolaStreak")
    public String streakGiocoParola(
    		ModelMap modelMap,
    		@RequestParam("mode") String mode, 
    		@RequestParam("errori") Integer err
    		) {
    	PartitaParolaDTO partita=utente.getProfiloGiocatore().getPartiteInCorso().get(mode);
    	parolaService.goStreak(partita, err);
    	
    	modelMap.addAttribute("vite", partita.getVite());
    	modelMap.addAttribute("streak", partita.getCurrentStreak());
    	modelMap.addAttribute("id", utente.getProfiloGiocatore().getId());
    	modelMap.addAttribute("nomeUser", utente.getProfiloGiocatore().getNome());
    	modelMap.addAttribute("iconaUser", utente.getProfiloGiocatore().getIcona());
    	modelMap.addAttribute("mode", mode);
    	modelMap.addAttribute("parola", partita.getParolaInCorso());
    	
        return "redirect:parola?mode="+mode;
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
	
    @GetMapping(value="/scoreParola")
    public String punteggioParola(
    		ModelMap modelMap, 
    		@RequestParam("mode") String mode, 
    		@RequestParam("errori") Integer errori){
    	PartitaParolaDTO partita=utente.getProfiloGiocatore().getPartiteInCorso().get(mode);
    	giocService.regPunteggioParola(utente.getProfiloGiocatore(), mode, partita.getCurrentStreak());
    	parolaService.finePartitaParola(partita, utente.getProfiloGiocatore());
    	if (utente.getId()!=null) {
    		modelMap.addAttribute("id", utente.getProfiloGiocatore().getId());
    		modelMap.addAttribute("nome", utente.getProfiloGiocatore().getNome());
    		modelMap.addAttribute("icona", utente.getProfiloGiocatore().getIcona());
    		modelMap.addAttribute("puntiParola", utente.getProfiloGiocatore().getPunteggi());
    		modelMap.addAttribute("listaPartite", utente.getProfiloGiocatore().getPartiteParola());
    		String idGame=partita.getID();
    		return "redirect:recapParola?idGame="+idGame;
    	}
    	else {
    		Giocatore giocatoreDTO=new Giocatore();
        	modelMap.addAttribute("giocatoreDTO", giocatoreDTO);
    		return "nuovoProfilo";
    	}
    }
    
    @GetMapping(value="/recapParola")
    public String riepilogoParola(
    		ModelMap modelMap, 
    		@RequestParam("idGame") String idGame 
    		) {
    	modelMap.addAttribute("id", utente.getProfiloGiocatore().getId());
		modelMap.addAttribute("nome", utente.getProfiloGiocatore().getNome());
		modelMap.addAttribute("icona", utente.getProfiloGiocatore().getIcona());
		PartitaParolaDTO partita=utente.getProfiloGiocatore().getPartiteParola().get(idGame);
		modelMap.addAttribute("streak", partita.getCurrentStreak());
		modelMap.addAttribute("mode", partita.getCategoria());
		modelMap.addAttribute("sconfitta", partita.getParolaSconfitta());
		modelMap.addAttribute("idGame", partita.getID());
		modelMap.addAttribute("paroleIndovinate", partita.getParoleIndovinateEdErrori());
		    	
    	return "parolaRecap";
    }
}
