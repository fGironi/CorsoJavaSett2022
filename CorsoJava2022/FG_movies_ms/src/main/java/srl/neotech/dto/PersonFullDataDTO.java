package srl.neotech.dto;

import java.util.ArrayList;

public class PersonFullDataDTO extends PersonDTO {

	private Integer moviesAsCast;
	private Integer moviesAsCrew;
	private ArrayList<MovieCastDTO> movieCasts;
	private ArrayList<MovieCrewDTO> movieCrews;
	private ArrayList<PersonTogetherDTO> personsTogether;
	
	public Integer getMoviesAsCast() {
		return moviesAsCast;
	}
	public void setMoviesAsCast(Integer moviesAsCast) {
		this.moviesAsCast = moviesAsCast;
	}
	public Integer getMoviesAsCrew() {
		return moviesAsCrew;
	}
	public void setMoviesAsCrew(Integer moviesAsCrew) {
		this.moviesAsCrew = moviesAsCrew;
	}
	public ArrayList<MovieCastDTO> getMovieCasts() {
		return movieCasts;
	}
	public void setMovieCasts(ArrayList<MovieCastDTO> movieCasts) {
		this.movieCasts = movieCasts;
	}
	public ArrayList<MovieCrewDTO> getMovieCrews() {
		return movieCrews;
	}
	public void setMovieCrews(ArrayList<MovieCrewDTO> movieCrews) {
		this.movieCrews = movieCrews;
	}
	public ArrayList<PersonTogetherDTO> getPersonsTogether() {
		return personsTogether;
	}
	public void setPersonsTogether(ArrayList<PersonTogetherDTO> personsTogether) {
		this.personsTogether = personsTogether;
	}
	
	
}
