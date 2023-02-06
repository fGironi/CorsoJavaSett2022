package srl.neotech.dto;

import java.util.ArrayList;

public class CompanyDTO {

	private Integer id;
	private String companyName;
	private ArrayList<MovieDTO> moviesList;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public ArrayList<MovieDTO> getMoviesList() {
		return moviesList;
	}
	public void setMoviesList(ArrayList<MovieDTO> moviesList) {
		this.moviesList = moviesList;
	}
	

	

	
	
}
