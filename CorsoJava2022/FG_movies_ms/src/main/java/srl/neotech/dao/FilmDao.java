package srl.neotech.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import srl.neotech.entity.Movie;
import srl.neotech.repository.MovieRepository;

@Component
public class FilmDao {

	@Autowired
	EntityManager entityManager;
	
	@Autowired
	MovieRepository movieRepository;
	
	public Movie getMovie(Integer movie_id) {
	
	//find by PK	
	Movie m=entityManager.find(Movie.class, movie_id); 	
	return m;	
	}
	
	public List<Movie> getMovieByActor(String name) {
		
		//find by PK	
		 List<Movie> movies=movieRepository.getFilmByActor(name);
		return movies;	
		}
	
	
	public void insertMovie(Movie movie) {
		
	//insert
	entityManager.persist(movie); 
	}
	
}
