package srl.neotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import srl.neotech.dto.MovieDTO;
import srl.neotech.requestresponse.ResponseBase;
import srl.neotech.services.FilmService;

@RestController
public class FilmController {

	@Autowired
	FilmService filmService;
	
	@GetMapping("/getFilm")
	public ResponseBase getFilm(@RequestParam("film_id") Integer film_id) {
		ResponseBase response=new ResponseBase();
		
		try {
			MovieDTO film_trovato=filmService.getFilm(film_id);
			response.setSimpleData(film_trovato);
			response.setCode("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
	return response;
	}
	
	
	@GetMapping("insertMovie")
	public ResponseBase insertMovie(@RequestParam("film_id") Integer film_id, @RequestParam("titolo") String titolo) {
		ResponseBase response=new ResponseBase();
		
		try {
			MovieDTO f=new MovieDTO();
			f.setId(film_id);
			f.setTitle(titolo);
			filmService.insertFilm(f);
			response.setCode("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		
		return response;
	}
	
}