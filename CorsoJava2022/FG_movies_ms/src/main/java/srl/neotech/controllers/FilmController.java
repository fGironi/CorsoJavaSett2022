package srl.neotech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import srl.neotech.dto.Film;
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
			Film film_trovato=filmService.getFilm(film_id);
			response.setData(film_trovato);
			response.setCode("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
	return response;
	}
	
	
	@GetMapping("/getFilmByActor")
	public ResponseBase getFilmByActor(@RequestParam("name") String name) {
		ResponseBase response=new ResponseBase();
		
		try {
			List<Film> films=filmService.getFilmByActor(name);
			response.setData(films);
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
			Film f=new Film();
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