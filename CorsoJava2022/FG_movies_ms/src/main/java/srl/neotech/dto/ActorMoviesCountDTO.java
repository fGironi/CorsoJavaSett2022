package srl.neotech.dto;

public class ActorMoviesCountDTO {

	private Integer id;
	private String personName;
	private Integer movieCount;
	
	
	
	public ActorMoviesCountDTO(Integer id, String personName, Integer movieCount) {
		super();
		this.id = id;
		this.personName = personName;
		this.movieCount = movieCount;
	}
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
	public Integer getMovieCount() {
		return movieCount;
	}
	public void setMovieCount(Integer movieCount) {
		this.movieCount = movieCount;
	}
	
	
}
