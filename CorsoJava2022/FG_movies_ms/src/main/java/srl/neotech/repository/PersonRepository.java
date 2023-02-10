package srl.neotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import srl.neotech.entity.Person;
import srl.neotech.entity.PersonTogether;

public interface PersonRepository extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person> {
	
	
	
	@Query("select Count(mc) from Person p join p.movieCrews mc where p.id=:person_id")
	public Integer MovieCrewCount(Integer person_id);
	
	@Query("select Count(mc) from Person p join p.movieCasts mc where p.id=:person_id")
	public Integer MovieCastCount(Integer person_id);
	
	@Query(nativeQuery = true)
	public List<PersonTogether> getMoviesTogether(Integer person_id);
	
}