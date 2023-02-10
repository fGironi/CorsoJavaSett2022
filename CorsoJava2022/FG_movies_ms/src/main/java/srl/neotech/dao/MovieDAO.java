package srl.neotech.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import srl.neotech.entity.Movie;
import srl.neotech.repository.MovieRepository;

@Component
public class MovieDAO {

	@Autowired
	MovieRepository movieRepo;
	@Autowired
	EntityManager entityManager;
	
	public Movie getMovieById(Integer movie_id) {
		return movieRepo.findById(movie_id).orElse(null);
	}
	
}
