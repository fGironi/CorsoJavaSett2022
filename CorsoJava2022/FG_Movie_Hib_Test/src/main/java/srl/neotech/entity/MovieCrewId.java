package srl.neotech.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MovieCrewId implements Serializable {
    private static final long serialVersionUID = 681534822595495642L;
    @Column(name = "movie_id", nullable = false)
    private Integer movieId;

    @Column(name = "person_id", nullable = false)
    private Integer personId;

    @Column(name = "department_id", nullable = false)
    private Integer departmentId;

    @Column(name = "job", nullable = false, length = 200)
    private String job;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MovieCrewId entity = (MovieCrewId) o;
        return Objects.equals(this.departmentId, entity.departmentId) &&
                Objects.equals(this.movieId, entity.movieId) &&
                Objects.equals(this.personId, entity.personId) &&
                Objects.equals(this.job, entity.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, movieId, personId, job);
    }

}