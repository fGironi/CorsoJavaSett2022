package srl.neotech.dto;

import java.time.LocalDate;

public class MovieDTO {

	private Integer id;
    private String title;
    private LocalDate releaseDate;
   
     
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
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

     
     
}
