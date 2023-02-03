package srl.neotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import srl.neotech.model.PersonDTO;
import srl.neotech.requestresponse.InsertPersonRequest;
import srl.neotech.requestresponse.ResponseBase;
import srl.neotech.services.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	PersonService personService;

	//create
	@PutMapping(value="/insertPerson")
	ResponseBase insertPerson(@RequestBody InsertPersonRequest request) {
		ResponseBase response=new ResponseBase();
		try {
			personService.insertPerson(request);
			response.setCode("OK");
		}catch (Exception e) {
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		
		return response;
	}
	
	
	//read
	@GetMapping(value="/getPerson")
	ResponseBase getPerson(@RequestParam Integer person_id) {
		ResponseBase response=new ResponseBase();
		try {
			PersonDTO p=personService.getPerson(person_id);
			response.setSimpleData(p);
			response.setCode("OK");
		}catch (Exception e) {
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		return response;
	}
	
	//update
	@PostMapping(value="/updatePerson")
	ResponseBase updatePerson(@RequestBody InsertPersonRequest request) {
		ResponseBase response=new ResponseBase();
		try {
			personService.updatePerson(request);
			response.setCode("OK");
		}catch (Exception e) {
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		return response;
	}
	
	//delete
	@DeleteMapping(value="/deletePerson")
	ResponseBase deletePerson(@RequestParam Integer person_id) {
		ResponseBase response=new ResponseBase();
		try {
			personService.deletePerson(person_id);
			response.setCode("OK");
			
		}catch (Exception e) {
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}	
		return response;
	}
	
	
}
