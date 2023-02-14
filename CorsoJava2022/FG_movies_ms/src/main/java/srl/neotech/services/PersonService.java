package srl.neotech.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.dao.PersonDAO;
import srl.neotech.dto.ActorMoviesCountDTO;
import srl.neotech.dto.PersonDTO;
import srl.neotech.dto.PersonFullDataDTO;
import srl.neotech.dto.PersonTogetherDTO;
import srl.neotech.entity.ActorMoviesCount;
import srl.neotech.entity.Person;
import srl.neotech.entity.PersonTogether;

@Service
public class PersonService {

	@Autowired
	PersonDAO personDAO;
	
	@Autowired
	ModelMapper mapper;
	
	public List<PersonDTO> getAllPersons() {
		List<Person> pEntities=personDAO.getAllPersons();
		ArrayList<PersonDTO> persons=new ArrayList<PersonDTO>();
		for (Person p: pEntities) {
			PersonDTO person=mapper.map(p, PersonDTO.class);
			persons.add(person);
		}
		return persons;
	}
	
	public PersonDTO getPersonById(Integer id, Boolean fullData) {
		Person pEntity=personDAO.getPersonById(id);
		if (fullData==false) {
			PersonDTO person=mapper.map(pEntity, PersonDTO.class);
			return person;
		}
		else {
			PersonFullDataDTO person=mapper.map(pEntity, PersonFullDataDTO.class);
			person.setMoviesAsCast(personDAO.movieCastCount(id));
			person.setMoviesAsCrew(personDAO.movieCrewCount(id));
			ArrayList<PersonTogetherDTO> pTogether=new ArrayList<PersonTogetherDTO>();
			List<PersonTogether>pTogetherEntity=personDAO.getPersonsTogether(id);
			for (PersonTogether pt: pTogetherEntity) {
				PersonTogetherDTO p=mapper.map(pt, PersonTogetherDTO.class);
				pTogether.add(p);
			}
			person.setPersonsTogether(pTogether);
			return person;
		}
	}
	
	public List<PersonDTO> actorsProdOrDir(){
		List<Person> actorsEntity=personDAO.actorsProdOrDir();
		ArrayList<PersonDTO> persons=new ArrayList<PersonDTO>();
		for (Person p:actorsEntity) {
			PersonDTO person=mapper.map(p, PersonDTO.class);
			persons.add(person);
		}
		return persons;
	}

	public List<ActorMoviesCountDTO> getActorMoviesCount(){
		ArrayList<ActorMoviesCountDTO> actors=new ArrayList<ActorMoviesCountDTO>();
		List<ActorMoviesCount> actorEntities=personDAO.getActorMoviesCount();
		for (ActorMoviesCount amc:actorEntities) {
			ActorMoviesCountDTO actor=new ActorMoviesCountDTO(amc.getId(), amc.getPersonName(), amc.getMovieCount());
			actors.add(actor);
		}
		return actors;
	}

	public List<PersonDTO> getActorsByLangCode(String languageCode) {
		ArrayList<PersonDTO> actors= new ArrayList<PersonDTO>();
		List<Person> actorsEntity=personDAO.getActorsByLangCode(languageCode);
		for (Person p:actorsEntity) {
			PersonDTO actor=mapper.map(p, PersonDTO.class);
			actors.add(actor);
		}
		return actors;
	}
}
