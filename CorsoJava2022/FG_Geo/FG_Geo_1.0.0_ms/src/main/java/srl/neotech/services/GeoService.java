package srl.neotech.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.dao.GeoDAO;
import srl.neotech.model.ComuneAutoDTO;
import srl.neotech.model.ComuneDTO;
import srl.neotech.model.GeoLocalizzazioneDTO;
import srl.neotech.model.ProvinciaDTO;
import srl.neotech.model.RegioneDTO;

@Service
public class GeoService {
	
	@Autowired
	GeoDAO geoDAO;

	public ArrayList<RegioneDTO> getListaRegioni() {
		return geoDAO.getListaRegioni();
	}

	public ArrayList<ProvinciaDTO> getListaProvince(Integer idReg) {
		return geoDAO.getlistaProvince(idReg);
	}

	public ArrayList<ComuneDTO> getListaComuni(String siglaProv) {
		return geoDAO.getListaComuni(siglaProv);
	}

	public ArrayList<ComuneAutoDTO> getListaComuniAuto(String input) {
		return geoDAO.getListaComuniAuto(input);
	}

	public void getPrevisioni(String istat) {
		GeoLocalizzazioneDTO geo= geoDAO.getGeoLocal(istat);
		System.out.println(geo);
	}

}
