package srl.neotech.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "person_id", nullable = false)
    private Integer id;

    @Column(name = "person_name", nullable = false, length = 500)
    private String personName;

    @OneToMany(mappedBy = "person")
    private Set<MovieCrew> movieCrews = new LinkedHashSet<>();

    @OneToMany(mappedBy = "person", cascade = {CascadeType.PERSIST})
    @NotFound(action = NotFoundAction.IGNORE)
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

}