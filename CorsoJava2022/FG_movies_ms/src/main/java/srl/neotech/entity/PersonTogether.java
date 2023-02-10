package srl.neotech.entity;

public class PersonTogether {

	private Integer id;
	private String personName;
	private Integer moviesTogether;
	
	public PersonTogether() {
	}
	
	public PersonTogether(Integer id, String personName, Integer moviesTogether) {
		this.id = id;
		this.personName = personName;
		this.moviesTogether = moviesTogether;
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

	public Integer getMoviesTogether() {
		return moviesTogether;
	}
	public void setMoviesTogether(Integer moviesTogether) {
		this.moviesTogether = moviesTogether;
	}
	
	
}
