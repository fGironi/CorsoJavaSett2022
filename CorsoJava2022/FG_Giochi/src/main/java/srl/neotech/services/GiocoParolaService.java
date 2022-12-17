package srl.neotech.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.github.javafaker.Faker;

import srl.neotech.model.Giocatore;
import srl.neotech.model.PunteggioParola;

@Service
public class GiocoParolaService {

	Faker faker=new Faker();

	
	public ArrayList<String> listaPoke(ArrayList<String> listaParole) {
		listaParole=new ArrayList<String>();
		for (int i=0; i<100; i++) {
			String s=faker.pokemon().name();
			if (listaParole.contains(s)){
				i--;
			}
			else listaParole.add(s);
		}
		return listaParole;
	}
	
	public ArrayList<String> listaZelda(ArrayList<String> listaParole) {
		listaParole=new ArrayList<String>();
		while (listaParole.size()<100) {
			String s=faker.zelda().character();
			if (listaParole.contains(s)==false){
				listaParole.add(s);
			}
		}
		return listaParole;
	}
	public ArrayList<String> listaRock(ArrayList<String> listaParole) {
		while (listaParole.size()<100) {
			String s=faker.rockBand().name();
			if (listaParole.contains(s)==false){
				listaParole.add(s);
			}
		}
		return listaParole;
	}
	
	public ArrayList<String> listaLoL(ArrayList<String> listaParole) {
		while (listaParole.size()<100) {
			String s=faker.leagueOfLegends().champion();
			if (s.equals("Alister")) s="Alistar";
			if (listaParole.contains(s)==false){
				listaParole.add(s);
			}
		}
		return listaParole;
	}
	

	public ArrayList<String> modePicker(String mode){
		ArrayList<String> listaParole=new ArrayList<String>();;
		if (mode.equals("zelda")) listaParole=this.listaZelda(listaParole);
    	if (mode.equals("pokemon")) listaParole=this.listaPoke(listaParole);
    	if (mode.equals("rock")) listaParole=this.listaRock(listaParole);
    	if (mode.equals("lol")) listaParole=this.listaLoL(listaParole);
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
}
