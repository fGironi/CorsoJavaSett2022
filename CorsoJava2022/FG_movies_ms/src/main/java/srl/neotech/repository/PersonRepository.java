package srl.neotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import srl.neotech.entity.ActorMoviesCount;
import srl.neotech.entity.CollabEvaluation;
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
	
	@Query(nativeQuery= true, value="select p.person_id id, p.person_name personName, avg(m.budget) avgBudget, avg(m.revenue) avgRev, avg(m.popularity) avgPop, avg(m.vote_average) avgVote, count(distinct m.movie_id) movieCount from movie m\n"
			+ "join movie_cast cast on cast.movie_id=m.movie_id\n"
			+ "join movie_crew crew on crew.movie_id=m.movie_id\n"
			+ "join person p on p.person_id=crew.person_id\n"
			+ "where not p.person_id=:person_id\n"
			+ "and m.movie_id IN(\n"
			+ "select distinct m.movie_id from movie m\n"
			+ "join movie_cast cast on cast.movie_id=m.movie_id\n"
			+ "join movie_crew crew on crew.movie_id=m.movie_id\n"
			+ "join person pcrew on pcrew.person_id=crew.person_id\n"
			+ "join person pcast on pcast.person_id=cast.person_id\n"
			+ "where pcast.person_id=:person_id or pcrew.person_id=:person_id)\n"
			+ "group by p.person_id having movieCount>1\n"
			+ "order by avgVote desc")
	public List<CollabEvaluation> getCollabEvaluationCrew(Integer person_id);
	
	@Query(nativeQuery= true, value="select p.person_id id, p.person_name personName, avg(m.budget) avgBudget, avg(m.revenue) avgRev, avg(m.popularity) avgPop, avg(m.vote_average) avgVote, count(distinct m.movie_id) movieCount from movie m\n"
			+ "join movie_cast cast on cast.movie_id=m.movie_id\n"
			+ "join movie_crew crew on crew.movie_id=m.movie_id\n"
			+ "join person p on p.person_id=cast.person_id\n"
			+ "where not p.person_id=:person_id\n"
			+ "and m.movie_id IN(\n"
			+ "select distinct m.movie_id from movie m\n"
			+ "join movie_cast cast on cast.movie_id=m.movie_id\n"
			+ "join movie_crew crew on crew.movie_id=m.movie_id\n"
			+ "join person pcrew on pcrew.person_id=crew.person_id\n"
			+ "join person pcast on pcast.person_id=cast.person_id\n"
			+ "where pcast.person_id=:person_id or pcrew.person_id=:person_id)\n"
			+ "group by p.person_id having movieCount>1\n"
			+ "order by avgVote desc")
	public List<CollabEvaluation> getCollabEvaluationCast(Integer person_id);
}