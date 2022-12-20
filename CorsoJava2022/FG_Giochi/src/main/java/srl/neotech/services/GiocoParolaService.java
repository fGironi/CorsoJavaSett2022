package srl.neotech.services;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import srl.neotech.dao.repository.ListaParoleDAO;
import srl.neotech.model.Giocatore;
import srl.neotech.model.PartitaParolaDTO;
import srl.neotech.model.PunteggioParola;

@Service
public class GiocoParolaService {
	
	@Autowired
	ListaParoleDAO lp;

	//TESTING VARIABLE:
	private Integer contaPartite=0;
	
	Faker faker=new Faker();
	Random rnd=new Random();

	public ArrayList<String> modePicker(String mode){
		ArrayList<String> listaParole=new ArrayList<String>();;
		if (mode.equals("zelda")) listaParole.addAll(lp.listaZelda());
    	if (mode.equals("pokemon")) listaParole.addAll(lp.listaPoke());
    	if (mode.equals("rock")) listaParole.addAll(lp.listaRock());
    	if (mode.equals("lol")) listaParole.addAll(lp.listaLoL());
    	if (mode.equals("capitale")) listaParole.addAll(lp.listaCapitali());
    	if (mode.equals("animaliENG")) listaParole.addAll(lp.listaAnimaliEng());
    	System.out.println("impostata modalita partita= "+mode);
    	System.out.println(listaParole.size());
    	return listaParole;
		}
	

	public void nuovoPunteggio(String modalita, Integer streak, Giocatore g) {
		PunteggioParola p=new PunteggioParola(modalita, streak);
		g.getPunteggi().add(p);
	}
	
	public ArrayList<PunteggioParola> highScoreGeneral(Giocatore g){
		ArrayList<PunteggioParola> highscores= new ArrayList<PunteggioParola>();
				
		return highscores;
	}
	
	public String partitaParolaIDGenerator(Giocatore g, String categoria) {
		String ID;
		Integer n=g.getPartiteParola().size();
		ID="P"+this.contaPartite+categoria+n;
		return ID;
	}
	
	public PartitaParolaDTO checkPartitaInCorso(Giocatore g, String categoria) {
		PartitaParolaDTO partita;
		if (g.getPartiteInCorso().containsKey(categoria)) {
    		partita=g.getPartiteInCorso().get(categoria);
    	}
    	else {
    		partita=new PartitaParolaDTO(categoria, g);
    		String idPartita=this.partitaParolaIDGenerator(g, categoria);
    		partita.setID(idPartita);
    		partita.setListaParole(this.modePicker(categoria));
    		String parola=this.parolaRandom(partita.getListaParole()).toUpperCase();
    		partita.setParolaInCorso(parola);
    		g.getPartiteInCorso().put(categoria, partita);	
    	}	
		return partita;
	}
	
	public PartitaParolaDTO anonPartita(String categoria) {
		PartitaParolaDTO partita=new PartitaParolaDTO();
		partita.setListaParole(this.modePicker(categoria));
		String parola=this.parolaRandom(partita.getListaParole()).toUpperCase();
		partita.setParolaInCorso(parola);
		return partita;
	}
	
	public String parolaRandom (ArrayList<String> listaParole) {
		
		Integer rndPrl=rnd.nextInt(listaParole.size());
		String parola=listaParole.get(rndPrl);
		return parola;
	}

	public Integer getContaPartite() {
		return contaPartite;
	}

	public void setContaPartite(Integer contaPartite) {
		this.contaPartite = contaPartite;
	}
	
	public void goStreak(PartitaParolaDTO partita, Integer errori) {
		partita.setCurrentStreak(partita.getCurrentStreak()+1);
		partita.getParoleIndovinateEdErrori().put(partita.getParolaInCorso(), errori);
		partita.setVite(partita.getVite()-errori);
		if (partita.getVite()<9) {
			partita.setVite(partita.getVite()+1);
			if (partita.getCurrentStreak()%10==0 && partita.getVite()<9) {
				partita.setVite(partita.getVite()+1);
			}
		}
		partita.getListaParole().remove(partita.getParolaInCorso());
		String parola=this.parolaRandom(partita.getListaParole()).toUpperCase();
		partita.setParolaInCorso(parola);
		
	}
	
	public void finePartitaParola(PartitaParolaDTO partita, Giocatore g) {
		partita.setParolaSconfitta(partita.getParolaInCorso());
		partita.setParolaInCorso(null);
		g.getPartiteInCorso().remove(partita.getCategoria());
		g.getPartiteParola().put(partita.getID(), partita);
	}
}
