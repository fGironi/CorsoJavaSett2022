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
import srl.neotech.model.Colore;
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
			Integer rndCol=rnd.nextInt(Colore.values().length);
			if (rndCol==0) auto.setColore(Colore.ARANCIONE);
			else if (rndCol==1) auto.setColore(Colore.ARANCIONEMETAL);
			else if (rndCol==2) auto.setColore(Colore.ARANCIONEOPACO);
			else if (rndCol==3) auto.setColore(Colore.BIANCO);
			else if (rndCol==4) auto.setColore(Colore.BIANCOMETAL);
			else if (rndCol==5) auto.setColore(Colore.BIANCOOPACO);
			else if (rndCol==6) auto.setColore(Colore.BLU);
			else if (rndCol==7) auto.setColore(Colore.BLUMETAL);
			else if (rndCol==8) auto.setColore(Colore.BLUOPACO);
			else if (rndCol==9) auto.setColore(Colore.GIALLO);
			else if (rndCol==10) auto.setColore(Colore.GIALLOMETAL);
			else if (rndCol==11) auto.setColore(Colore.GIALLOOPACO);
			else if (rndCol==12) auto.setColore(Colore.GRIGIO);
			else if (rndCol==13) auto.setColore(Colore.GIALLOMETAL);
			else if (rndCol==14) auto.setColore(Colore.GIALLOOPACO);
			else if (rndCol==15) auto.setColore(Colore.MARRONE);
			else if (rndCol==16) auto.setColore(Colore.MARRONEMETAL);
			else if (rndCol==17) auto.setColore(Colore.MARRONEOPACO);
			else if (rndCol==18) auto.setColore(Colore.NERO);
			else if (rndCol==19) auto.setColore(Colore.NEROMETAL);
			else if (rndCol==20) auto.setColore(Colore.NEROOPACO);
			else if (rndCol==21) auto.setColore(Colore.ROSSO);
			else if (rndCol==22) auto.setColore(Colore.ROSSOMETAL);
			else if (rndCol==23) auto.setColore(Colore.ROSSOOPACO);
			else if (rndCol==24) auto.setColore(Colore.VERDE);
			else if (rndCol==25) auto.setColore(Colore.VERDEMETAL);
			else if (rndCol==26) auto.setColore(Colore.VERDEOPACO);
			else if (rndCol==27) auto.setColore(Colore.VIOLA);
			else if (rndCol==28) auto.setColore(Colore.VIOLAMETAL);
			else if (rndCol==29) auto.setColore(Colore.VIOLAOPACO);
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
