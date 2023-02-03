package srl.neotech.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import srl.neotech.entity.Movie;

@Component
public class FilmDAO {

	@Autowired
	EntityManager entityManager;
	
	public Movie getMovie(Integer movie_id) {
		
		//select * from movie where movie_id=:movie_id
		Movie m=entityManager.find(Movie.class, movie_id); //find by PK
	return m;	
	}
	
	public void insertMovie(Movie movie) {
		entityManager.merge(movie); //insert--- update 
		//entityManager.persist(movie); //insert... 
		//entityManager.remove()  //delete..
	}
	
}
