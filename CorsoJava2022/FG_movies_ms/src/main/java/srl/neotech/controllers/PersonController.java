package srl.neotech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import srl.neotech.dto.ActorMoviesCountDTO;
import srl.neotech.dto.PersonDTO;
import srl.neotech.requestresponse.ResponseBase;
import srl.neotech.services.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping("/getAllPersons")
	public ResponseBase getAllPersons() {
		ResponseBase response=new ResponseBase();
		try {
			List<PersonDTO> persons=personService.getAllPersons();
			response.setData(persons);
			response.setCode("OK");
		} catch (Exception e) {
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
	return response;
	}
	
	@GetMapping("/getPersonById")
	public ResponseBase getPersonById(@RequestParam Integer person_id, @RequestParam Boolean fullData) {
		ResponseBase response=new ResponseBase();
		try {
			PersonDTO person=personService.getPersonById(person_id, fullData);
			response.setData(person);
			response.setCode("OK");
		} catch (Exception e) {
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
	return response;
	}
	
	@GetMapping("/getActorsProdOrDir")
	public ResponseBase getActorsProdOrDir() {
		ResponseBase response=new ResponseBase();
		try {
			List<PersonDTO> persons=personService.actorsProdOrDir();
			response.setData(persons);
			response.setCode("OK");
		} catch (Exception e) {
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
	return response;
	}
	
	@GetMapping("/getActorsMovieCount")
	public ResponseBase getActorsMovieCount() {
		ResponseBase response=new ResponseBase();
		try {
			List<ActorMoviesCountDTO> actors=personService.getActorMoviesCount();
			response.setData(actors);
			response.setCode("OK");
		} catch (Exception e) {
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
	return response;
	}
	
	@GetMapping("/getActorsByLangCode")
	public ResponseBase getActorsByLangCode(@RequestParam String languageCode) {
		ResponseBase response=new ResponseBase();
		try {
			List<PersonDTO> actors=personService.getActorsByLangCode(languageCode);
			response.setCode("OK");
			response.setData(actors);
			
		}catch (Exception e) {
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		
		return response;
	}
	
}
