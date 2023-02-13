package srl.neotech.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import srl.neotech.entity.Country;
import srl.neotech.entity.Genre;
import srl.neotech.entity.Movie;
import srl.neotech.entity.MovieCast;
import srl.neotech.entity.Person;
import srl.neotech.entity.ProductionCompany;
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

	public List<Movie> searchMovie(String movieTitle, String castName, Integer budgetMoreThan,
			Integer budgetLessThan, BigDecimal voteMoreThan, BigDecimal voteLessThan, String companyName,
			String countryName, String genreName) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
	    Root<Movie> movie = cq.from(Movie.class);
	    ArrayList<Predicate> predicates=new ArrayList<Predicate>();
	    
	   	    
	    //impostazione delle where tramite if
	    if (movieTitle!=null) {
	    	Predicate titlePredicate = cb.equal(movie.get("title"), movieTitle);
	    	predicates.add(titlePredicate);
	    }
	    if (castName!=null) {
	    	Join<Movie, MovieCast> cast = movie.join("movieCasts");
		    Join<MovieCast,Person> person = cast.join("person");
	    	Predicate castPredicate = cb.like(person.get("personName"), castName);
	    	predicates.add(castPredicate);
	    }
	    if (budgetMoreThan!=null) {
	    	Predicate budgetMorePredicate = cb.greaterThanOrEqualTo(movie.get("budget"), budgetMoreThan);
	    	predicates.add(budgetMorePredicate);
	    }
	    if (budgetMoreThan!=null) {
	    	Predicate budgetLessPredicate = cb.lessThanOrEqualTo(movie.get("budget"), budgetLessThan);
	    	predicates.add(budgetLessPredicate);
	    }
	    if (voteMoreThan!=null) {
	    	Predicate voteMorePredicate = cb.greaterThanOrEqualTo(movie.get("voteAverage"), voteMoreThan);
	    	predicates.add(voteMorePredicate);
	    }
	    if (voteLessThan!=null) {
	    	Predicate voteLessPredicate = cb.lessThanOrEqualTo(movie.get("voteAverage"), voteLessThan);
	    	predicates.add(voteLessPredicate);
	    }
	    if (companyName!=null) {
	    	Join<Movie, ProductionCompany> company = movie.join("productionCompanies");
	    	Predicate companyPredicate = cb.equal(company.get("companyName"), companyName);
	    	predicates.add(companyPredicate);
	    }
	    if (countryName!=null) {
	    	Join<Movie, Country> country = movie.join("countries");
	    	Predicate countryPredicate = cb.like(country.get("countryName"), countryName);
	    	predicates.add(countryPredicate);
	    }
	    if (genreName!=null) {
	    	Join<Movie, Genre> genre = movie.join("genres");
	    	Predicate genrePredicate = cb.like(genre.get("genreName"), genreName);
	    	predicates.add(genrePredicate);
	    }
	    Predicate finalPredicate=cb.and(predicates.toArray(new Predicate[0]));
	    cq.where(finalPredicate);
	    TypedQuery<Movie> query = entityManager.createQuery(cq);
	  
	    return query.getResultList();
	}
}
