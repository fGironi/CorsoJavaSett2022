package srl.neotech.services;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import srl.neotech.dao.AutoDAO;
import srl.neotech.model.AccessorioDTO;
import srl.neotech.model.Alimentazione;
import srl.neotech.model.AutoDTO;
import srl.neotech.model.Costruttore;
import srl.neotech.model.TipologiaAcc;

@Service
public class TestService {

	private Boolean accessoriCreati=false;
	Faker faker=new Faker();
	Random rnd=new Random();
	ArrayList<AccessorioDTO> accessori; 
	ArrayList<String> targhe;
	
	@Autowired
	AutoService autoServ;
	
	@Autowired
	AutoDAO autoDAO;
	
	public TestService() {
		this.accessori=new ArrayList<AccessorioDTO>();
		this.targhe=new ArrayList<String>();
	}
	
	public ArrayList<AutoDTO> faiFintaDiAvereUnDBdiAccessori() {
		
		if (accessoriCreati==false) {
			AccessorioDTO cerchiLega=new AccessorioDTO();
			cerchiLega.setCosto(1000);
			cerchiLega.setDescrizione("Cerchi in lega");
			cerchiLega.setTipologia(TipologiaAcc.CERCHI);
			accessori.add(cerchiLega);
									
			AccessorioDTO sedPelle=new AccessorioDTO();
			sedPelle.setCosto(1500);
			sedPelle.setDescrizione("Sedili in pelle");
			sedPelle.setTipologia(TipologiaAcc.SEDILI);
			
						
			AccessorioDTO telaioFibra=new AccessorioDTO();
			telaioFibra.setCosto(5500);
			telaioFibra.setDescrizione("Telaio in fibra di carbonio");
			telaioFibra.setTipologia(TipologiaAcc.ALTRO);
			accessori.add(telaioFibra);
			
			AccessorioDTO carPlay=new AccessorioDTO();
			carPlay.setCosto(800);
			carPlay.setDescrizione("Apple CarPlay");
			carPlay.setTipologia(TipologiaAcc.ENTERTAINMENT);
			accessori.add(carPlay);
			
			AccessorioDTO antifurtoGPS=new AccessorioDTO();
			antifurtoGPS.setCosto(900);
			antifurtoGPS.setDescrizione("antifurto GPS");
			antifurtoGPS.setTipologia(TipologiaAcc.ALTRO);
			accessori.add(antifurtoGPS);
				
			System.out.println("Creati gli accessori generati manualmente");
			accessoriCreati=true;
		}		
		//Generazione di 10 veicoli random con JavaFaker
			ArrayList<AutoDTO> autoCreate=new ArrayList<AutoDTO>();
		for (int i=0; i<10; i++) {
			AutoDTO auto=new AutoDTO();
			System.out.println("genero l'auto "+i+" con Faker");
			//Alimentazione
			Integer rndAli=rnd.nextInt(6);
			if (rndAli==0) auto.setAlimentazione(Alimentazione.BENZINA);
			else if (rndAli==1) auto.setAlimentazione(Alimentazione.DIESEL);
			else if (rndAli==2) auto.setAlimentazione(Alimentazione.ELETTRICA);
			else if (rndAli==3) auto.setAlimentazione(Alimentazione.GPL);
			else if (rndAli==4) auto.setAlimentazione(Alimentazione.IBRIDA);
			else auto.setAlimentazione(Alimentazione.METANO);
			System.out.println("Impostata alimentazione: "+auto.getAlimentazione());
			//Anno
			Integer rndAnno=rnd.nextInt(1970, 2023+1);
			auto.setAnno(rndAnno);
			System.out.println("Impostato anno: "+auto.getAnno());
			//Colore
			String color= faker.color().name();
			auto.setColore(color);
			System.out.println("Impostato colore: "+auto.getColore());
			//Costo
			Integer rndCosto=rnd.nextInt(20, 500+1);
			auto.setCostoBase(rndCosto*100);
			System.out.println("Impostato costo base: "+auto.getCostoBase());
			//Costruttore
			Integer rndCostr=rnd.nextInt(7);
			if (rndCostr==0) auto.setCostruttore(Costruttore.ALFAROMEO);
			else if (rndCostr==1) auto.setCostruttore(Costruttore.DALLARA);
			else if (rndCostr==2) auto.setCostruttore(Costruttore.FERRARI);
			else if (rndCostr==3) auto.setCostruttore(Costruttore.FIAT);
			else if (rndCostr==4) auto.setCostruttore(Costruttore.LAMBORGHINI);
			else if (rndCostr==5) auto.setCostruttore(Costruttore.LANCIA);
			else if (rndCostr==6) auto.setCostruttore(Costruttore.MASERATI);
			System.out.println("Impostato costruttore: "+auto.getCostruttore());
			//Modello
			Integer rndName=rnd.nextInt(5);
			if (rndName==0) auto.setModello(faker.ancient().god());
			else if (rndName==1) auto.setModello(faker.space().galaxy());
			else if (rndName==2) auto.setModello(faker.cat().name());
			else if (rndName==3) auto.setModello(faker.food().fruit());
			else if (rndName==4) auto.setModello(faker.funnyName().name());
			System.out.println("Impostato modello: "+auto.getModello());
			//Targa
			String targa="??###??"; Boolean nuovaTarga=false;
			while (nuovaTarga==false) {
				String randTarga=faker.bothify(targa, true);
				if (targhe.contains(randTarga)==false) {
					nuovaTarga=true;
					auto.setTarga(randTarga);
					targhe.add(randTarga);
				}
			}
			System.out.println("Impostata targa: "+auto.getTarga());
			//ID
			auto.setId(autoServ.idGenerator());
			System.out.println("Impostato ID: "+auto.getId());
			//Accessori
			for (AccessorioDTO acc:this.accessori) {
				Integer rndAcc=rnd.nextInt(3);
				if (rndAcc==0) auto.getAccessori().add(acc);
			}
			System.out.println("Impostati accessori, numero accessori: "+auto.getAccessori().size());
			//Costo Totale
			auto.setCostoTot(autoServ.costoCalculator(auto));
			System.out.println("Impostato costo totale: "+auto.getCostoTot());
			//Aggiunta alla lista
			autoDAO.addAuto(auto);
			autoCreate.add(auto);
			System.out.println("Aggiunta l'auto "+i+" al DB");
		}
		return autoCreate;
	}
}
