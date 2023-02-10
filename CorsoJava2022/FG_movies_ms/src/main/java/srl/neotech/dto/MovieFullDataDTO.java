package srl.neotech.dto;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MovieFullDataDTO extends MovieDTO {

	private ArrayList<CastMemberDTO> movieCasts;
	private ArrayList<CrewMemberDTO> movieCrews;
	private ArrayList<String> productionCompanies;
	private Integer budget;
	private Long revenue;
	private BigDecimal voteAverage;
	private ArrayList<String> genres;

	public ArrayList<CastMemberDTO> getMovieCasts() {
		return movieCasts;
	}
	public void setMovieCasts(ArrayList<CastMemberDTO> movieCasts) {
		this.movieCasts = movieCasts;
	}
	public ArrayList<CrewMemberDTO> getMovieCrews() {
		return movieCrews;
	}
	public void setMovieCrews(ArrayList<CrewMemberDTO> movieCrews) {
		this.movieCrews = movieCrews;
	}
	public ArrayList<String> getProductionCompanies() {
		return productionCompanies;
	}
	public void setProductionCompanies(ArrayList<String> productionCompanies) {
		this.productionCompanies = productionCompanies;
	}
	public Integer getBudget() {
		return budget;
	}
	public void setBudget(Integer budget) {
		this.budget = budget;
	}
	public Long getRevenue() {
		return revenue;
	}
	public void setRevenue(Long revenue) {
		this.revenue = revenue;
	}
	public BigDecimal getVoteAverage() {
		return voteAverage;
	}
	public void setVoteAverage(BigDecimal voteAverage) {
		this.voteAverage = voteAverage;
	}
	public ArrayList<String> getGenres() {
		return genres;
	}
	public void setGenres(ArrayList<String> genres) {
		this.genres = genres;
	}
	
	
}
