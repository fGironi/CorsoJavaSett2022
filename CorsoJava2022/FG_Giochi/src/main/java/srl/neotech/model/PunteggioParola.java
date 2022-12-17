package srl.neotech.model;

import java.util.Date;

public class PunteggioParola {

	private String categoria;
	private Integer streak;
	private Date data;
	
	
	
	public PunteggioParola(String categoria, Integer streak) {
		this.categoria = categoria;
		this.streak = streak;
	}
	
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Integer getStreak() {
		return streak;
	}
	public void setStreak(Integer streak) {
		this.streak = streak;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}
