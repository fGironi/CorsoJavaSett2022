package srl.neotech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void faiFintaDiAvereUnDBdiAccessori() {
		
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
		tettoApribile.setDescrizione("Tetto apribile");
		tettoApribile.setTipologia(Tipologia.tettino);
		accDao.getElencoAccessori().put(tettoApribile.getId(), tettoApribile);
		
		AccessorioDTO tettoTrasparente=new AccessorioDTO();
		tettoTrasparente.setId(salService.generaIdAccessorio());
		tettoTrasparente.setClasse(Classe.Esterni);
		tettoTrasparente.setCosto(600);
		tettoTrasparente.setDescrizione("Tetto Trasparente");
		tettoTrasparente.setTipologia(Tipologia.tettino);
		accDao.getElencoAccessori().put(tettoTrasparente.getId(), tettoTrasparente);
		
		AccessorioDTO antifurtoGPS=new AccessorioDTO();
		antifurtoGPS.setId(salService.generaIdAccessorio());
		antifurtoGPS.setClasse(Classe.Altro);
		antifurtoGPS.setCosto(900);
		antifurtoGPS.setDescrizione("Antifurto GPS");
		antifurtoGPS.setTipologia(Tipologia.sicurezza);
		accDao.getElencoAccessori().put(antifurtoGPS.getId(), antifurtoGPS);
		
		AccessorioDTO sediliRiscaldati=new AccessorioDTO();
		sediliRiscaldati.setId(salService.generaIdAccessorio());
		sediliRiscaldati.setClasse(Classe.Altro);
		sediliRiscaldati.setCosto(900);
		sediliRiscaldati.setDescrizione("Sedili riscaldanti");
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
	}
}
