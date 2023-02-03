package srl.neotech.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MovieLanguageId implements Serializable {
    private static final long serialVersionUID = -7710321790229304033L;
    @Column(name = "movie_id", nullable = false)
    private Integer movieId;

    @Column(name = "language_id", nullable = false)
    private Integer languageId;

    @Column(name = "language_role_id", nullable = false)
    private Integer languageRoleId;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getLanguageRoleId() {
        return languageRoleId;
    }

    public void setLanguageRoleId(Integer languageRoleId) {
        this.languageRoleId = languageRoleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MovieLanguageId entity = (MovieLanguageId) o;
        return Objects.equals(this.languageRoleId, entity.languageRoleId) &&
                Objects.equals(this.languageId, entity.languageId) &&
                Objects.equals(this.movieId, entity.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageRoleId, languageId, movieId);
    }

}