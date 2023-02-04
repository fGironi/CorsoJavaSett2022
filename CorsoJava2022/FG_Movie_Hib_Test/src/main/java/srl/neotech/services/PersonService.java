package srl.neotech.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.dao.PersonDAO;
import srl.neotech.entity.Movie;
import srl.neotech.entity.Person;
import srl.neotech.model.MovieDTO;
import srl.neotech.model.PersonDTO;
import srl.neotech.requestresponse.InsertPersonRequest;


@Service
public class PersonService {

	@Autowired
	PersonDAO personDAO;
	
	

	@Transactional
	public void insertPerson(InsertPersonRequest request) {
		Mapper mapper=new DozerBeanMapper();
		Person p=mapper.map(request, Person.class);
		personDAO.insertPerson(p);
	}

	public PersonDTO getPerson(Integer person_id) {
		
		Person p=personDAO.getPerson(person_id);
		
		Mapper mapper=new DozerBeanMapper();
		PersonDTO personDTO=mapper.map(p, PersonDTO.class);
		/*
		 		Il codice che segue è simpatico, ma l'entity person è costruita incorrettamente è va in loop
		 		senza riuscire ad ottenere i dati
		 		
		ArrayList<MovieDTO> movCast=new ArrayList<MovieDTO>();
		while (p.getMovieCasts().iterator().hasNext()) {
			Movie m=p.getMovieCasts().iterator().next().getMovie();
			MovieDTO movieDTO=mapper.map(m, MovieDTO.class);
			movCast.add(movieDTO);
			System.out.println("Movies as cast:");
			System.out.println(m.getTitle());
		}
		personDTO.setMoviesAsCast(movCast);
		
		ArrayList<MovieDTO> movCrew=new ArrayList<MovieDTO>();
		while (p.getMovieCrews().iterator().hasNext()) {
			Movie m=p.getMovieCrews().iterator().next().getMovie();
			MovieDTO movieDTO=mapper.map(m, MovieDTO.class);
			movCrew.add(movieDTO);
			
			System.out.println("Movies as crew:");
			System.out.println(m.getTitle());
		}		personDTO.setMoviesAsCrew(movCrew);
		*/
		return personDTO;
	}

	@Transactional
	public void updatePerson(InsertPersonRequest request) {
		Mapper mapper=new DozerBeanMapper();
		Person p=mapper.map(request, Person.class);
		personDAO.updatePerson(p);
	}

	@Transactional
	public void deletePerson(Integer person_id) {
		personDAO.deletePerson(person_id);
		
	}
	
	

	
}
