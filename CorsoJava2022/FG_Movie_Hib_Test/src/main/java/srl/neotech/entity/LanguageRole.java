package srl.neotech.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "language_role")
public class LanguageRole {
    @Id
    @Column(name = "role_id", nullable = false)
    private Integer id;

    @Column(name = "language_role", length = 20)
    private String languageRole;

    @OneToMany(mappedBy = "languageRole")
    private Set<MovieLanguage> movieLanguages = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguageRole() {
        return languageRole;
    }

    public void setLanguageRole(String languageRole) {
        this.languageRole = languageRole;
    }

    public Set<MovieLanguage> getMovieLanguages() {
        return movieLanguages;
    }

    public void setMovieLanguages(Set<MovieLanguage> movieLanguages) {
        this.movieLanguages = movieLanguages;
    }

}