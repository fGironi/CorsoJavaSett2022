package srl.neotech.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 1000)
    private String title;

    @Column(name = "budget")
    private Integer budget;

    @Column(name = "homepage", length = 1000)
    private String homepage;

    @Column(name = "overview", length = 1000)
    private String overview;

    @Column(name = "popularity", precision = 12, scale = 6)
    private BigDecimal popularity;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "revenue")
    private Long revenue;

    @Column(name = "runtime")
    private Integer runtime;

    @Column(name = "movie_status", length = 50)
    private String movieStatus;

    @Column(name = "tagline", length = 1000)
    private String tagline;

    @Column(name = "vote_average", precision = 4, scale = 2)
    private BigDecimal voteAverage;

    @Column(name = "vote_count")
    private Integer voteCount;

    @Column(name = "url_image", length = 200)
    private String urlImage;

    @ManyToMany
    @JoinTable(name = "production_country",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id"))
    private Set<Country> countries = new LinkedHashSet<>();

    @OneToMany(mappedBy = "movie", cascade = {CascadeType.PERSIST})
    private Set<MovieCrew> movieCrews = new LinkedHashSet<>();

   

    @ManyToMany
    @JoinTable(name = "movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new LinkedHashSet<>();

    @OneToMany(mappedBy = "movie", cascade = {CascadeType.PERSIST})
    private Set<MovieLanguage> movieLanguages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "movie", cascade = {CascadeType.PERSIST})
    private Set<MovieCast> movieCasts = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "movie_keywords",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id"))
    private Set<Keyword> keywords = new LinkedHashSet<>();


    @ManyToMany
    @JoinTable(name = "movie_company",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    private Set<ProductionCompany> productionCompanies = new LinkedHashSet<>();
    
    //method hand implemented --->
    
    
    @ManyToMany
    @JoinTable(name = "movie_languages",
              joinColumns = @JoinColumn (name ="movie_id"),
              inverseJoinColumns = @JoinColumn(name= "language_id"))
    private Set<Language>languages=new LinkedHashSet<>(); 

//    @ManyToMany
//    @JoinTable(name = "movie_cast",
//    	       joinColumns = @JoinColumn (name ="movie_id"), 
//    	       inverseJoinColumns = @JoinColumn(name="gender"))
//    private Set<Gender>genders=new LinkedHashSet<>();
    
   
    
    
    //end method <---
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public BigDecimal getPopularity() {
        return popularity;
    }

    public void setPopularity(BigDecimal popularity) {
        this.popularity = popularity;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getRevenue() {
        return revenue;
    }

    public void setRevenue(Long revenue) {
        this.revenue = revenue;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(String movieStatus) {
        this.movieStatus = movieStatus;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public BigDecimal getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(BigDecimal voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    public Set<MovieCrew> getMovieCrews() {
        return movieCrews;
    }

    public void setMovieCrews(Set<MovieCrew> movieCrews) {
        this.movieCrews = movieCrews;
    }

    

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<MovieLanguage> getMovieLanguages() {
        return movieLanguages;
    }

    public void setMovieLanguages(Set<MovieLanguage> movieLanguages) {
        this.movieLanguages = movieLanguages;
    }

    public Set<MovieCast> getMovieCasts() {
        return movieCasts;
    }

    public void setMovieCasts(Set<MovieCast> movieCasts) {
        this.movieCasts = movieCasts;
    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }



    public Set<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(Set<ProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

}