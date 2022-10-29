package srl.neotech.java07;

public abstract class Umano implements Giocatore {

	private String nomeClasse;
	

	public String getNomeClasse() {
		return nomeClasse;
	}

	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}
	
	public void mangia() {
		System.out.println(this.nomeClasse+" mangia una mela");
	}
	
	public void dormi() {
		System.out.println(this.getNomeClasse()+" dorme nel letto");
	}
	
}
