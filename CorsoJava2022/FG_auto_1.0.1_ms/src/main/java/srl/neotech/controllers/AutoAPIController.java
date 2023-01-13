package srl.neotech.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import srl.neotech.model.AutoDTO;
import srl.neotech.requestresponse.GetAutoResponse;
import srl.neotech.requestresponse.GetListaAutoResponse;
import srl.neotech.requestresponse.RequestAddAuto;
import srl.neotech.requestresponse.RequestSearchAuto;
import srl.neotech.requestresponse.ResponseBase;
import srl.neotech.services.AutoService;

@RestController
public class AutoAPIController {

	@Autowired
	AutoService autoService;
	
	//getauto
	@ResponseBody
	@GetMapping(value = "/getAuto",produces = MediaType.APPLICATION_JSON_VALUE)
	public GetAutoResponse getAuto(@RequestParam String id) {
		 //inizializzo la response
		GetAutoResponse response=new GetAutoResponse();
		try {
			//chiamo il service
			AutoDTO auto=autoService.getAuto(id);
			//preparo la response
			response.setAuto(auto);
			response.setCode("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		return response;
	}
	
	//listaauto
	@ResponseBody
	@GetMapping(value="/getListaAuto", produces = MediaType.APPLICATION_JSON_VALUE)
	public GetListaAutoResponse getListaAuto() {
		GetListaAutoResponse response=new GetListaAutoResponse();
		try {
			//chiamo il service
			ArrayList<AutoDTO> listaAuto=autoService.getListaAuto();
			//preparo la response
			response.setListaAuto(listaAuto);
			response.setCode("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		return response;
	}
	
	
	//addauto
	@ResponseBody
	@PutMapping(value="/addAuto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBase addAuto(@Valid @RequestBody RequestAddAuto request) {
		ResponseBase response=new ResponseBase();
		try {
			//chiamo il service
			String id=autoService.addAuto(request);
			//preparo la response
			response.setCode("OK");
			response.setSimpleData(id);
			response.setDescr("Auto aggiunta. Tornato l'id dell'auto");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		return response;
	}

	//removeauto
	@ResponseBody
	@GetMapping(value="/removeAuto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBase removeAuto(@RequestParam String id) {
		ResponseBase response=new ResponseBase();
		try {
			autoService.removeAuto(id);
			response.setCode("OK");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		return response;
	}
	
	//cercaauto
	@ResponseBody
	@PostMapping(value="/searchAuto", produces = MediaType.APPLICATION_JSON_VALUE)
	public GetListaAutoResponse searchAuto(@RequestBody RequestSearchAuto request) {
		GetListaAutoResponse response=new GetListaAutoResponse();
		try {
			ArrayList<AutoDTO> autoTrovate=autoService.searchAuto(request);
			response.setCode("OK");
			response.setListaAuto(autoTrovate);
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		return response;
	}
	
	
	//updateauto
	
}
