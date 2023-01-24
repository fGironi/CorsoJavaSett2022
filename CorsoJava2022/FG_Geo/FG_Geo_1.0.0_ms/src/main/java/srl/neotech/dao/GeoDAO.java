package srl.neotech.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import srl.neotech.dao.repository.GeoRepository;
import srl.neotech.model.ComuneDTO;
import srl.neotech.model.ProvinciaDTO;
import srl.neotech.model.RegioneDTO;

@Component
public class GeoDAO {

	@Autowired
	GeoRepository geoRepo;

	public ArrayList<RegioneDTO> getListaRegioni() {
		List<RegioneDTO> listaRegioni_=geoRepo.getListaRegioni();
		ArrayList<RegioneDTO>listaRegioni=new ArrayList<RegioneDTO>();
		listaRegioni.addAll(listaRegioni_);
		return listaRegioni;
	}

	public ArrayList<ProvinciaDTO> getlistaProvince(Integer idReg) {
		List<ProvinciaDTO> listaProvince_=geoRepo.getListaProvince(idReg);
		ArrayList<ProvinciaDTO>listaProvince=new ArrayList<ProvinciaDTO>();
		listaProvince.addAll(listaProvince_);
		return listaProvince;
	}
	
	public ArrayList<ComuneDTO> getListaComuni(String siglaProv) {
		List<ComuneDTO> listaComuni_=geoRepo.getListaComuni(siglaProv);
		ArrayList<ComuneDTO>listaComuni=new ArrayList<ComuneDTO>();
		listaComuni.addAll(listaComuni_);
		return listaComuni;
	}

	public ArrayList<ComuneDTO> getListaComuniAuto(String input) {
		List<ComuneDTO> listaComuni_=geoRepo.getListaComuniAuto(input);
		ArrayList<ComuneDTO>listaComuni=new ArrayList<ComuneDTO>();
		listaComuni.addAll(listaComuni_);
		return listaComuni;
	}
}
