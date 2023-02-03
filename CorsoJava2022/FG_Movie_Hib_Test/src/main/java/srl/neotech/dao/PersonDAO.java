package srl.neotech.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import srl.neotech.entity.Person;

@Component
public class PersonDAO {

	@Autowired
	EntityManager eManager;

	public void insertPerson(Person p) {
		eManager.persist(p);
	}

	public Person getPerson(Integer person_id) {
		Person p=eManager.find(Person.class, person_id);
		return p;
	}

	public void updatePerson(Person p) {
		eManager.merge(p);
	}

	public void deletePerson(Integer person_id) {
		Person p=eManager.find(Person.class, person_id);
		eManager.remove(p);
		
	}
	
	
	
}
