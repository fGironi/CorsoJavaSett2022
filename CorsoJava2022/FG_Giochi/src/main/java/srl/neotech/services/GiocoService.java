package srl.neotech.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

@Service
public class GiocoService {

	private ArrayList<String> listaParole;
	
	Faker faker=new Faker();

	public ArrayList<String> getListaParole() {
		return listaParole;
	}

	public void setListaParole(ArrayList<String> listaParole) {
		this.listaParole = listaParole;
	}
	
	public ArrayList<String> listaPoke() {
		this.listaParole=new ArrayList<String>();
		for (int i=0; i<100; i++) {
			String s=faker.pokemon().name();
			if (this.listaParole.contains(s)){
				i--;
			}
			else this.listaParole.add(s);
		}
		return this.listaParole;
	}
	
	public ArrayList<String> listaZelda() {
		this.listaParole=new ArrayList<String>();
		while (this.listaParole.size()<100) {
			String s=faker.zelda().character();
			if (this.listaParole.contains(s)==false){
				this.listaParole.add(s);
			}
		}
		return this.listaParole;
	}
	public ArrayList<String> listaRock() {
		this.listaParole=new ArrayList<String>();
		while (this.listaParole.size()<100) {
			String s=faker.rockBand().name();
			if (this.listaParole.contains(s)==false){
				this.listaParole.add(s);
			}
		}
		return this.listaParole;
	}
	

	
}
