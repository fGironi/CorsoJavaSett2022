package srl.neotech.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "gender")
public class Gender {
    @Id
    @Column(name = "gender_id", nullable = false)
    private Integer id;

    @Column(name = "gender", length = 20)
    private String gender;

    @OneToMany(mappedBy = "gender")
    private Set<MovieCast> movieCasts = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<MovieCast> getMovieCasts() {
        return movieCasts;
    }

    public void setMovieCasts(Set<MovieCast> movieCasts) {
        this.movieCasts = movieCasts;
    }

}