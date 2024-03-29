package srl.neotech.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.dao.PersonDAO;
import srl.neotech.dto.MovieDTO;
import srl.neotech.dto.MoviePlusRoleDTO;
import srl.neotech.dto.PersonDTO;
import srl.neotech.entity.Movie;
import srl.neotech.entity.MovieCast;
import srl.neotech.entity.MovieCrew;
import srl.neotech.entity.Person;
import srl.neotech.requestresponse.InsertPersonRequest;


@Service
public class PersonService {

	@Autowired
	PersonDAO personDAO;

	ModelMapper mapper = new ModelMapper();

	
	

	@Transactional
	public void insertPerson(InsertPersonRequest request) {
		Person p=mapper.map(request, Person.class);
		personDAO.insertPerson(p);
	}

	public PersonDTO getPerson(Integer person_id) {
		
		Person p=personDAO.getPerson(person_id);
		
		PersonDTO personDTO=mapper.map(p, PersonDTO.class);
			 		
		ArrayList<MovieCast> movCastEnt=new ArrayList<MovieCast>(p.getMovieCasts());
		ArrayList<MovieDTO> movAsCast=new ArrayList<MovieDTO>();
		System.out.println("Movies as cast:");
		for (MovieCast mc:movCastEnt) {
			Movie m=mc.getMovie();
			MoviePlusRoleDTO movieDTO=mapper.map(m, MoviePlusRoleDTO.class);
			movieDTO.setRole(mc.getCharacterName());
			movAsCast.add(movieDTO);
			System.out.println(movieDTO.getTitle());
		}
		personDTO.setMoviesAsCast(movAsCast);
		
		ArrayList<MovieCrew> movCrewEnt=new ArrayList<MovieCrew>(p.getMovieCrews());
		ArrayList<MovieDTO> movAsCrew=new ArrayList<MovieDTO>();
		System.out.println("Movies as crew:");
		for (MovieCrew mc:movCrewEnt) {
			Movie m=mc.getMovie();
			MoviePlusRoleDTO movieDTO=mapper.map(m, MoviePlusRoleDTO.class);
			movieDTO.setRole(mc.getDepartment().getDepartmentName());
			movAsCrew.add(movieDTO);
			System.out.println(movieDTO.getTitle());
		}
		personDTO.setMoviesAsCrew(movAsCrew);
		return personDTO;
	}

	@Transactional
	public void updatePerson(InsertPersonRequest request) {
		Person p=mapper.map(request, Person.class);
		personDAO.updatePerson(p);
	}

	@Transactional
	public void deletePerson(Integer person_id) {
		personDAO.deletePerson(person_id);
		
	}
	
	

	
}
