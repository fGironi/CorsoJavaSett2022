package srl.neotech.model;

public class Punteggio {

	private String categoria;
	private Integer streak;
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
	public Punteggio(String categoria, Integer streak) {
		this.categoria = categoria;
		this.streak = streak;
	}
	
	
}
