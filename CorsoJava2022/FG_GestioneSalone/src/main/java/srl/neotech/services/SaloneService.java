package srl.neotech.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.dao.repository.AccessoriRepository;
import srl.neotech.dao.repository.AutomobiliRepository;
import srl.neotech.model.AccessorioDTO;
import srl.neotech.model.AutomobileDTO;
import srl.neotech.model.Tipologia;
import srl.neotech.requestresponse.FormAutoRequest;

@Service
public class SaloneService {

	@Autowired
	AutomobiliRepository autoDAO;
	@Autowired
	AccessoriRepository accDao;
	
	
	private Integer autoCount=0;
	
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
		String idAcc="A"+numero;
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
	
	public void assegnaAccessori(AutomobileDTO auto, FormAutoRequest formAuto) {
		ArrayList<String> idAccessori=formAuto.getIdAccessori();
		idAccessori.add(formAuto.getIdAccCar());	idAccessori.add(formAuto.getIdAccTap());
		idAccessori.add(formAuto.getIdAccTet());	idAccessori.add(formAuto.getIdAccInt());
		idAccessori.add(formAuto.getIdAccCer());
		for (String s:idAccessori) {
			if (accDao.getElencoAccessori().containsKey(s)) {
				System.out.println("aggiunto accessorio "+s);
				AccessorioDTO acc=accDao.getElencoAccessori().get(s);
				auto.getAccessori().add(acc);
			}
		}
	}
	
	public ArrayList<AutomobileDTO> sottoListaAuto(ArrayList<String> listaID) {
		ArrayList<AutomobileDTO> ls=new ArrayList<AutomobileDTO>();
		for (String s:listaID) {
			if (autoDAO.getListaAuto().containsKey(s)){
				ls.add(autoDAO.getListaAuto().get(s));
			}
		}
		
		
		return ls;
	}
}
