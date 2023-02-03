package srl.neotech.services;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.dao.PersonDAO;
import srl.neotech.entity.Person;
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
		PersonDTO personDTO=new PersonDTO();
		personDTO.setId(p.getId());
		personDTO.setPersonName(p.getPersonName());
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
