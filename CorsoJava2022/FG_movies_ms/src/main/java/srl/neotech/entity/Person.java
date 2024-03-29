package srl.neotech.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@NamedNativeQuery(name="Person.getMoviesTogether", query="select p.person_id as id, p.person_name as personName, count(m.movie_id) as moviesTogether from movie m"
		+ " join movie_cast mc on mc.movie_id=m.movie_id"
		+ " join person p on p.person_id=mc.person_id"
		+ " where NOT p.person_id=:person_id and"
		+ " m.movie_id in"
		+ "	(select m.movie_id from movie m"
		+ "	join movie_cast mc on m.movie_id=mc.movie_id"
		+ "	where mc.person_id=:person_id)"
		+ " group by p.person_id"
		+ " order by moviesTogether desc",
		resultSetMapping ="Mapping.PersonTogetherResult")
@SqlResultSetMapping(
	    name="Mapping.PersonTogetherResult",
	    classes={
	    	@ConstructorResult(
	        targetClass=srl.neotech.entity.PersonTogether.class,
	        columns={
	          @ColumnResult(name="id", type=Integer.class),
	          @ColumnResult(name="personName", type=String.class),
	          @ColumnResult(name="moviesTogether", type=Integer.class)
	        })
	    })
@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "person_id", nullable = false)
    private Integer id;

    @Size(max = 500)
    @Column(name = "person_name", length = 500)
    private String personName;

    @OneToMany(mappedBy = "person",fetch = FetchType.LAZY)
    private Set<MovieCrew> movieCrews = new LinkedHashSet<>();

    @OneToMany(mappedBy = "person",fetch = FetchType.LAZY)
    private Set<MovieCast> movieCasts = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Set<MovieCrew> getMovieCrews() {
        return movieCrews;
    }

    public void setMovieCrews(Set<MovieCrew> movieCrews) {
        this.movieCrews = movieCrews;
    }

    public Set<MovieCast> getMovieCasts() {
        return movieCasts;
    }

    public void setMovieCasts(Set<MovieCast> movieCasts) {
        this.movieCasts = movieCasts;
    }

	@Override
	public String toString() {
		return personName;
	}
    
    

}