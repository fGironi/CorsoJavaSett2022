package srl.neotech.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import srl.neotech.entity.Person;
import srl.neotech.repository.PersonRepository;

@Component
public class PersonDAO {

	@Autowired
	PersonRepository personRepo;
	@Autowired
	EntityManager entityManager;
	
	public List<Person> getAllPersons() {
		List<Person> persons=personRepo.findAll();
		return persons;
	}
	
	public Integer movieCrewCount(Integer person_id) {
		Integer count=personRepo.MovieCrewCount(person_id);
		return count;
	}
	
	public Integer movieCastCount(Integer person_id) {
		Integer count=personRepo.MovieCastCount(person_id);
		return count;
	}
	
	public Person getPersonById(Integer person_id) {
		return personRepo.findById(person_id).orElse(null);
	}

}
