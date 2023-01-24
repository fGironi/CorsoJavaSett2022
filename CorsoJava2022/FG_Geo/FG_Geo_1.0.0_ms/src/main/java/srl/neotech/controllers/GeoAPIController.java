package srl.neotech.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import srl.neotech.model.ComuneDTO;
import srl.neotech.model.ProvinciaDTO;
import srl.neotech.model.RegioneDTO;
import srl.neotech.requestresponse.ListaComuniResponse;
import srl.neotech.requestresponse.ListaProvinceResponse;
import srl.neotech.requestresponse.ListaRegioniResponse;
import srl.neotech.services.GeoService;

@RestController
public class GeoAPIController {

	@Autowired
	GeoService geoService;
	
	@ResponseBody
	@GetMapping(value="/listaRegioni", produces=MediaType.APPLICATION_JSON_VALUE)
	public ListaRegioniResponse getListaRegioni() {
		ListaRegioniResponse response=new ListaRegioniResponse();
		try {
			//chiamo il service
			ArrayList<RegioneDTO> listaRegioni=geoService.getListaRegioni();
			//preparo la response
			response.setRegioni(listaRegioni);
			response.setCode("OK");
			response.setDescr("tornata la lista delle regioni");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		return response;
	}
	@ResponseBody
	@GetMapping(value="/listaProvince", produces=MediaType.APPLICATION_JSON_VALUE)
	public ListaProvinceResponse getListaProvince(@RequestParam Integer idReg) {
		ListaProvinceResponse response=new ListaProvinceResponse();
		try {
			//chiamo il service
			ArrayList<ProvinciaDTO> listaProvince=geoService.getListaProvince(idReg);
			//preparo la response
			response.setProvince(listaProvince);
			response.setCode("OK");
			response.setDescr("tornata la lista delle province");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		return response;
	}
	
	@ResponseBody
	@GetMapping(value="/listaComuni", produces=MediaType.APPLICATION_JSON_VALUE)
	public ListaComuniResponse getListaComuni() {
		ListaComuniResponse response=new ListaComuniResponse();
		try {
			//chiamo il service
			ArrayList<ComuneDTO> listaComuni=geoService.getListaComuni();
			//preparo la response
			response.setComuni(listaComuni);
			response.setCode("OK");
			response.setDescr("tornata la lista dei comuni");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		return response;
	}
	
	@ResponseBody
	@GetMapping(value="/listaComuni", produces=MediaType.APPLICATION_JSON_VALUE)
	public ListaComuniResponse getListaComuni(@RequestParam String siglaProv) {
		ListaComuniResponse response=new ListaComuniResponse();
		try {
			//chiamo il service
			ArrayList<ComuneDTO> listaComuni=geoService.getListaComuni(siglaProv);
			//preparo la response
			response.setComuni(listaComuni);
			response.setCode("OK");
			response.setDescr("tornata la lista dei comuni");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		return response;
	}
	
}
