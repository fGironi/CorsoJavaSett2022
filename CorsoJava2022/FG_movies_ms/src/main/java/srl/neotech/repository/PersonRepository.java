package srl.neotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import srl.neotech.entity.ActorMoviesCount;
import srl.neotech.entity.Person;
import srl.neotech.entity.PersonTogether;

public interface PersonRepository extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person> {
	
	
	
	@Query("select Count(mc) from Person p join p.movieCrews mc where p.id=:person_id")
	public Integer MovieCrewCount(Integer person_id);
	
	@Query("select Count(mc) from Person p join p.movieCasts mc where p.id=:person_id")
	public Integer MovieCastCount(Integer person_id);
	
	@Query(nativeQuery = true )
	public List<PersonTogether> getMoviesTogether(Integer person_id);
	
	@Query(nativeQuery = true, value="select distinct p.* from person p join movie_cast mc on mc.person_id=p.person_id "
			+ "where p.person_id in "
			+ "(select p.person_id from person p "
			+ "join movie_crew mcr on mcr.person_id=p.person_id "
			+ "where mcr.department_id in (2, 3))")
	public List<Person> actorsProdOrDir();
	
	@Query(nativeQuery=true, value="select p.person_id as id, p.person_name as personName, count(mc.movie_id) as movieCount from person p join movie_cast mc on mc.person_id=p.person_id group by p.person_id")
	public List<ActorMoviesCount> getActorMoviesCount();
	
	@Query("select distinct p from Person p join p.movieCasts mc join mc.movie m join m.languages l where l.languageCode=:languageCode")
	public List<Person> getActorsByLangCode(String languageCode);
}