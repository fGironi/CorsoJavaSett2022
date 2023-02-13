package srl.neotech.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.dao.MovieDAO;
import srl.neotech.dto.MovieDTO;
import srl.neotech.dto.MovieFullDataDTO;
import srl.neotech.entity.Movie;

@Service
public class MovieService {

	@Autowired
	MovieDAO movieDAO;

	@Autowired
	ModelMapper mapper;
	
	public MovieDTO getMovieById(Integer movie_id) {
		Movie mEntity=movieDAO.getMovieById(movie_id);
		MovieDTO movie=mapper.map(mEntity, MovieDTO.class);
		/*
		//primo test, voglio vedere se mapper riesce a convertire la lista di generi in una lista di string, molto più
		//probabilmente dovrò fare:
		
		ArrayList<String> genres=new ArrayList<String>();
		for (Genre g:mEntity.getGenres()) {
			genres.add(g.getGenreName());
		}
		movie.setGenres(genres);
		
		//UPDATE: non è stato necessario, semplicemente creare il toString nell'entity corrispondente è sufficiente perché il
		//mapper riesca a convertire correttamente l'oggetto
		*/
		return movie;
	}

	public MovieDTO getMovieFullDataById(Integer movie_id) {
		Movie mEntity=movieDAO.getMovieById(movie_id);
		MovieFullDataDTO movie=mapper.map(mEntity, MovieFullDataDTO.class);
		//really impressive mr. mapper, really impressive.
		return movie;
	}
	
	public ArrayList<MovieDTO> searchMovie(
			String movieTitle, 
			String castName,
			Integer budgetMoreThan, 
			Integer budgetLessThan, 
			BigDecimal voteMoreThan, 
			BigDecimal voteLessThan,
			String companyName,
			String countryName,
			String genre
			){
		ArrayList<MovieDTO> moviesFound=new ArrayList<MovieDTO>();
		List<Movie> moviesFoundEntity=movieDAO.searchMovie(movieTitle, castName, budgetMoreThan, budgetLessThan, voteMoreThan, voteLessThan,companyName, countryName, genre);
		for (Movie m:moviesFoundEntity) {
			MovieDTO movie=mapper.map(m, MovieDTO.class);
			moviesFound.add(movie);
		}
		return moviesFound;
	}
}
