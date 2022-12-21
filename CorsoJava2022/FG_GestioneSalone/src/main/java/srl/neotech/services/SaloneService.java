package srl.neotech.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.dao.repository.AccessoriRepository;
import srl.neotech.dao.repository.AutomobiliRepository;
import srl.neotech.model.AccessorioDTO;
import srl.neotech.model.AutomobileDTO;
import srl.neotech.model.Classe;
import srl.neotech.model.Tipologia;

@Service
public class SaloneService {

	@Autowired
	AutomobiliRepository autoDAO;
	@Autowired
	AccessoriRepository accDao;
	
	
	private Integer autoCount=0;
	
	
	

	public void faiFintaDiAvereUnDBdiAccessori() {
		
		AccessorioDTO cerchiLega=new AccessorioDTO();
		cerchiLega.setId(this.generaIdAccessorio());
		cerchiLega.setClasse(Classe.Esterni);
		cerchiLega.setCosto(1000);
		cerchiLega.setDescrizione("cerchi in lega");
		cerchiLega.setTipologia(Tipologia.cerchi);
		accDao.getElencoAccessori().put(cerchiLega.getId(),cerchiLega);
		
		AccessorioDTO sedPelle=new AccessorioDTO();
		sedPelle.setId(this.generaIdAccessorio());
		sedPelle.setClasse(Classe.Interni);
		sedPelle.setCosto(1500);
		sedPelle.setDescrizione("sedili in pelle");
		sedPelle.setTipologia(Tipologia.sedili);
		accDao.getElencoAccessori().put(sedPelle.getId(), sedPelle);
		
		AccessorioDTO carPlay=new AccessorioDTO();
		carPlay.setId(this.generaIdAccessorio());
		carPlay.setClasse(Classe.Interni);
		carPlay.setCosto(800);
		carPlay.setDescrizione("Apple CarPlay");
		carPlay.setTipologia(Tipologia.carplay);
		accDao.getElencoAccessori().put(carPlay.getId(), carPlay);
	}
	
	public String generaIdAuto() {
		
		String numero;
		if (autoCount<10) numero="00"+autoCount;
		else if (autoCount<100) numero="0"+autoCount;
		else numero=autoCount.toString();
		String idAuto;
		idAuto="V"+numero;
		autoCount++;
		return idAuto;
	}
	
	public String generaIdAccessorio() {
		
		String numero;
		if (autoCount<10) numero="00"+accDao.getElencoAccessori().size();
		else if (autoCount<100) numero="0"+accDao.getElencoAccessori().size();
		else numero=""+accDao.getElencoAccessori().size();
		String idAcc="V"+numero;
		return idAcc;
	}
	
	public Integer costoConAccessori(AutomobileDTO auto) {
		Integer nuovoCosto=auto.getCostoBase();
		for (AccessorioDTO acc:auto.getAccessori()) {
			nuovoCosto=nuovoCosto+acc.getCosto();
		}
		
		return nuovoCosto;
	}
	
	public HashMap<String, AccessorioDTO> sottoListaAccessori(HashMap<String, AccessorioDTO> listaAccessori, Tipologia tipo){
		HashMap<String, AccessorioDTO> sottoLista=new HashMap<String, AccessorioDTO>();
		for(AccessorioDTO acc:listaAccessori.values()) {
			if (acc.getTipologia().equals(tipo)){
				sottoLista.put(acc.getId(), acc);
			}
		}
		return sottoLista;
	}
	
	public void assegnaAccessori(AutomobileDTO auto, ArrayList<String> idAccessori) {
		for (String s:idAccessori) {
			if (accDao.getElencoAccessori().containsKey(s)) {
				System.out.println("aggiunto accessorio "+s);
				AccessorioDTO acc=accDao.getElencoAccessori().get(s);
				auto.getAccessori().add(acc);
			}
		}
	}
}
