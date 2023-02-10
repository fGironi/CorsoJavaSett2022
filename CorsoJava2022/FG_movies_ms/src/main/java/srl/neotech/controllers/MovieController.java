package srl.neotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import srl.neotech.dto.MovieDTO;
import srl.neotech.requestresponse.ResponseBase;
import srl.neotech.services.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	MovieService movieService;

	@GetMapping("/getMovie")
	public ResponseBase getMovieById(@RequestParam("movie_id") Integer movie_id) {
		ResponseBase response=new ResponseBase();
		try {
			MovieDTO movie=movieService.getMovieById(movie_id);
			response.setData(movie);
			response.setCode("OK");
		} catch (Exception e) {
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
	return response;
	}
	
	@GetMapping("/getMovieFullData")
	public ResponseBase getMovieFullDataById(@RequestParam("movie_id") Integer movie_id) {
		ResponseBase response=new ResponseBase();
		try {
			MovieDTO movie=movieService.getMovieFullDataById(movie_id);
			response.setData(movie);
			response.setCode("OK");
		} catch (Exception e) {
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
	return response;
	}
	
}
