package srl.neotech.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import srl.neotech.model.AutoDTO;
import srl.neotech.requestresponse.AddAutoRequest;
import srl.neotech.requestresponse.GetAutoResponse;
import srl.neotech.requestresponse.GetListaAutoResponse;
import srl.neotech.requestresponse.ResponseBase;
import srl.neotech.requestresponse.SearchAutoRequest;
import srl.neotech.requestresponse.UpdateAutoRequest;
import srl.neotech.services.AutoService;
import srl.neotech.services.TestService;

@RestController
public class AutoAPIController {

	@Autowired
	AutoService autoService;
	@Autowired
	TestService testService;
	
	
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
			response.setDescr("tornata l'auto con id "+id);
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
			response.setSimpleData(listaAuto.size());
			response.setDescr("tornata la lista delle auto presenti nel database");
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
	public ResponseBase addAuto(@Valid @RequestBody AddAutoRequest request, BindingResult result) {
		ResponseBase response=new ResponseBase();
		if (result.hasErrors()) {
			response.setCode("KO");
			String testoErrori="";
			for (ObjectError error: result.getAllErrors()) {
				testoErrori=testoErrori+error.getDefaultMessage()+". ";
			}
			response.setDescr(testoErrori);
			return response;
		}
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
	@DeleteMapping(value="/removeAuto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBase removeAuto(@RequestParam String id) {
		ResponseBase response=new ResponseBase();
		try {
			autoService.removeAuto(id);
			response.setCode("OK");
			response.setDescr("l'auto "+id+" e' stata rimossa correttamente");
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
	public GetListaAutoResponse searchAuto(@RequestBody SearchAutoRequest request) {
		GetListaAutoResponse response=new GetListaAutoResponse();
		try {
			ArrayList<AutoDTO> autoTrovate=autoService.searchAuto(request);
			response.setCode("OK");
			response.setListaAuto(autoTrovate);
			response.setSimpleData(autoTrovate.size());
			if (autoTrovate.size()==0)	response.setDescr("non sono state trovate auto che soddisfano i criteri richiesti");
			else response.setDescr("tornata la lista delle auto che soddisfano i criteri richiesti");
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		return response;
	}
	
	//updateauto
	@ResponseBody
	@PostMapping(value="/updateAuto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBase updateAuto(@RequestBody UpdateAutoRequest request) {
		ResponseBase response=new ResponseBase();
		try {
			autoService.updateAuto(request);
			response.setCode("OK");
			response.setDescr("aggiornata l'auto "+request.getId());
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		return response;
	}
	
	//fakeDB
	@ResponseBody
	@GetMapping(value="/fakeAutos")
	public GetListaAutoResponse fakeAutos() {
		GetListaAutoResponse response=new GetListaAutoResponse();
		try {
			response.setListaAuto(testService.faiFintaDiAvereUnDBdiAccessori());
			response.setCode("OK");
			response.setDescr("Create auto randomiche con JavaFaker");
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		return response;
	}
}
