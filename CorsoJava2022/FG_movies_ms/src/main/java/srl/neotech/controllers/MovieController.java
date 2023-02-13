package srl.neotech.controllers;

import java.math.BigDecimal;
import java.util.List;

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
	
	@GetMapping("/searchMovie")
	public ResponseBase searchMovie(
			@RequestParam(required = false) String movieTitle, 
			@RequestParam(required = false) String castName,
			@RequestParam(required = false) Integer budgetMoreThan, 
			@RequestParam(required = false) Integer budgetLessThan, 
			@RequestParam(required = false) BigDecimal voteMoreThan, 
			@RequestParam(required = false) BigDecimal voteLessThan,
			@RequestParam(required = false) String companyName,
			@RequestParam(required = false) String countryName,
			@RequestParam(required = false) String genre
			) {
		ResponseBase response=new ResponseBase();
		try {
			List<MovieDTO> movies=movieService.searchMovie(movieTitle, castName, budgetMoreThan, budgetLessThan, voteMoreThan, voteLessThan, companyName, countryName, genre);
			response.setData(movies);
			response.setCode("OK");
		} catch (Exception e) {
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
	return response;
	}
	
}
