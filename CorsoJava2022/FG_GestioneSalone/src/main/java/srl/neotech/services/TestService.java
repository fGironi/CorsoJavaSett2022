package srl.neotech.services;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import srl.neotech.dao.repository.AccessoriRepository;
import srl.neotech.dao.repository.AutomobiliRepository;
import srl.neotech.model.AccessorioDTO;
import srl.neotech.model.Alimentazione;
import srl.neotech.model.AutomobileDTO;
import srl.neotech.model.Classe;
import srl.neotech.model.Colore;
import srl.neotech.model.Costruttore;
import srl.neotech.model.Tipologia;

@Service
public class TestService {
	
	@Autowired
	SaloneService salService;
	@Autowired
	AccessoriRepository accDao;
	@Autowired
	AutomobiliRepository autoDao;
	
	Faker faker=new Faker();
	Random rnd=new Random();
	ArrayList<String> targhe;
	Boolean accessoriCreati=false;
	
	public TestService () {
		this.targhe=new ArrayList<String>();
	}

	public void faiFintaDiAvereUnDBdiAccessori() {
		
		if (accessoriCreati==false) {
			AccessorioDTO cerchiLega=new AccessorioDTO();
			cerchiLega.setId(salService.generaIdAccessorio());
			cerchiLega.setClasse(Classe.Esterni);
			cerchiLega.setCosto(1000);
			cerchiLega.setDescrizione("cerchi in lega");
			cerchiLega.setTipologia(Tipologia.cerchi);
			accDao.getElencoAccessori().put(cerchiLega.getId(),cerchiLega);
			
			AccessorioDTO cerchiDorati=new AccessorioDTO();
			cerchiDorati.setId(salService.generaIdAccessorio());
			cerchiDorati.setClasse(Classe.Esterni);
			cerchiDorati.setCosto(900);
			cerchiDorati.setDescrizione("cerchi dorati");
			cerchiDorati.setTipologia(Tipologia.cerchi);
			accDao.getElencoAccessori().put(cerchiDorati.getId(),cerchiDorati);
	
			
			AccessorioDTO sedPelle=new AccessorioDTO();
			sedPelle.setId(salService.generaIdAccessorio());
			sedPelle.setClasse(Classe.Interni);
			sedPelle.setCosto(1500);
			sedPelle.setDescrizione("sedili in pelle");
			sedPelle.setTipologia(Tipologia.tappezzeria);
			accDao.getElencoAccessori().put(sedPelle.getId(), sedPelle);
			
			AccessorioDTO sedCamoscio=new AccessorioDTO();
			sedCamoscio.setId(salService.generaIdAccessorio());
			sedCamoscio.setClasse(Classe.Interni);
			sedCamoscio.setCosto(1500);
			sedCamoscio.setDescrizione("sedili in camoscio");
			sedCamoscio.setTipologia(Tipologia.tappezzeria);
			accDao.getElencoAccessori().put(sedCamoscio.getId(), sedCamoscio);
			
			AccessorioDTO androidEntert=new AccessorioDTO();
			androidEntert.setId(salService.generaIdAccessorio());
			androidEntert.setClasse(Classe.Interni);
			androidEntert.setCosto(600);
			androidEntert.setDescrizione("Android Entertainment");
			androidEntert.setTipologia(Tipologia.intrattenimento);
			accDao.getElencoAccessori().put(androidEntert.getId(), androidEntert);
			
			AccessorioDTO carPlay=new AccessorioDTO();
			carPlay.setId(salService.generaIdAccessorio());
			carPlay.setClasse(Classe.Interni);
			carPlay.setCosto(800);
			carPlay.setDescrizione("Apple CarPlay");
			carPlay.setTipologia(Tipologia.intrattenimento);
			accDao.getElencoAccessori().put(carPlay.getId(), carPlay);
			
			AccessorioDTO tettoApribile=new AccessorioDTO();
			tettoApribile.setId(salService.generaIdAccessorio());
			tettoApribile.setClasse(Classe.Esterni);
			tettoApribile.setCosto(1500);
			tettoApribile.setDescrizione("tetto apribile");
			tettoApribile.setTipologia(Tipologia.tettino);
			accDao.getElencoAccessori().put(tettoApribile.getId(), tettoApribile);
			
			AccessorioDTO tettoTrasparente=new AccessorioDTO();
			tettoTrasparente.setId(salService.generaIdAccessorio());
			tettoTrasparente.setClasse(Classe.Esterni);
			tettoTrasparente.setCosto(600);
			tettoTrasparente.setDescrizione("tetto Trasparente");
			tettoTrasparente.setTipologia(Tipologia.tettino);
			accDao.getElencoAccessori().put(tettoTrasparente.getId(), tettoTrasparente);
			
			AccessorioDTO antifurtoGPS=new AccessorioDTO();
			antifurtoGPS.setId(salService.generaIdAccessorio());
			antifurtoGPS.setClasse(Classe.Altro);
			antifurtoGPS.setCosto(900);
			antifurtoGPS.setDescrizione("antifurto GPS");
			antifurtoGPS.setTipologia(Tipologia.sicurezza);
			accDao.getElencoAccessori().put(antifurtoGPS.getId(), antifurtoGPS);
			
			AccessorioDTO sediliRiscaldati=new AccessorioDTO();
			sediliRiscaldati.setId(salService.generaIdAccessorio());
			sediliRiscaldati.setClasse(Classe.Altro);
			sediliRiscaldati.setCosto(900);
			sediliRiscaldati.setDescrizione("sedili riscaldanti");
			sediliRiscaldati.setTipologia(Tipologia.comfort);
			accDao.getElencoAccessori().put(sediliRiscaldati.getId(), sediliRiscaldati);
			
			
			AutomobileDTO auto1=new AutomobileDTO();
			auto1.setAlimentazione(Alimentazione.Benzina);
			auto1.setAnnoCostruzione(2000);
			auto1.setColore(Colore.bianco);
			auto1.setCostoBase(50000);
			auto1.setCostruttore(Costruttore.Citroen);
			auto1.setModello("ProvaCar");
			auto1.setTarga("AA123ZZ");
			auto1.setId(salService.generaIdAuto());
			auto1.getAccessori().add(sediliRiscaldati);
			auto1.getAccessori().add(sedPelle);
			auto1.getAccessori().add(antifurtoGPS);
			auto1.setCosto(salService.costoConAccessori(auto1));
			autoDao.getListaAuto().put(auto1.getId(), auto1);
			
			System.out.println("Creati gli accessori e l'auto generati manualmente");
			accessoriCreati=true;
		}		
		//Generazione di 10 veicoli random con JavaFaker
		for (int i=0; i<10; i++) {
			AutomobileDTO auto=new AutomobileDTO();
			System.out.println("genero l'auto "+i+" con Faker");
			//Alimentazione
			Integer rndAli=rnd.nextInt(5);
			if (rndAli==0) auto.setAlimentazione(Alimentazione.Benzina);
			else if (rndAli==1) auto.setAlimentazione(Alimentazione.Diesel);
			else if (rndAli==2) auto.setAlimentazione(Alimentazione.Elettrica);
			else if (rndAli==3) auto.setAlimentazione(Alimentazione.GPL);
			else if (rndAli==4) auto.setAlimentazione(Alimentazione.Ibrida);
			System.out.println("Impostata alimentazione: "+auto.getAlimentazione());
			//Anno
			Integer rndAnno=rnd.nextInt(1900, 2022+1);
			auto.setAnnoCostruzione(rndAnno);
			System.out.println("Impostato anno: "+auto.getAnnoCostruzione());
			//Colore
			Integer rndCol=rnd.nextInt(6);
			if (rndCol==0) auto.setColore(Colore.bianco);
			else if (rndCol==1) auto.setColore(Colore.blu);
			else if (rndCol==2) auto.setColore(Colore.giallo);
			else if (rndCol==3) auto.setColore(Colore.grigio);
			else if (rndCol==4) auto.setColore(Colore.nero);
			else if (rndCol==5) auto.setColore(Colore.rosso);
			System.out.println("Impostato colore: "+auto.getColore());
			//Costo
			Integer rndCosto=rnd.nextInt(200, 500+1);
			auto.setCostoBase(rndCosto*100);
			System.out.println("Impostato costo base: "+auto.getCostoBase());
			//Costruttore
			Integer rndCostr=rnd.nextInt(8);
			if (rndCostr==0) auto.setCostruttore(Costruttore.Alfaromeo);
			else if (rndCostr==1) auto.setCostruttore(Costruttore.BMW);
			else if (rndCostr==2) auto.setCostruttore(Costruttore.Citroen);
			else if (rndCostr==3) auto.setCostruttore(Costruttore.Ferrari);
			else if (rndCostr==4) auto.setCostruttore(Costruttore.Maserati);
			else if (rndCostr==5) auto.setCostruttore(Costruttore.Opel);
			else if (rndCostr==6) auto.setCostruttore(Costruttore.Porsche);
			else if (rndCostr==7) auto.setCostruttore(Costruttore.Renault);
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
			auto.setId(salService.generaIdAuto());
			System.out.println("Impostato ID: "+auto.getId());
			//Accessori
			for (AccessorioDTO acc:accDao.getElencoAccessori().values()) {
				Integer rndAcc=rnd.nextInt(5);
				if (rndAcc==0) auto.getAccessori().add(acc);
			}
			System.out.println("Impostati accessori, numero accessori: "+auto.getAccessori().size());
			//Costo Totale
			auto.setCosto(salService.costoConAccessori(auto));
			System.out.println("Impostato costo totale: "+auto.getCosto());
			//Aggiunta alla lista
			autoDao.getListaAuto().put(auto.getId(), auto);
			System.out.println("Aggiunta l'auto "+i+" alla lista");
			
			
		
		}
	}
}
