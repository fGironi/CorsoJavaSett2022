package srl.neotech.calcoloEsameReviewed;

import java.util.Random;

public class Studente {

	private String nome;
	private Integer votoScritto;
	private Integer votoOrale;
	private Integer votoTotale;
	private String risultato="n/a";
	

	public Studente(String nome) {
		super();
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getVotoScritto() {
		return votoScritto;
	}
	public void setVotoScritto(Integer votoScritto) {
		this.votoScritto = votoScritto;
	}
	public Integer getVotoOrale() {
		return votoOrale;
	}
	public void setVotoOrale(Integer votoOrale) {
		this.votoOrale = votoOrale;
	}
	public Integer getVotoTotale() {
		return votoTotale;
	}
	public void setVotoTotale(Integer votoTotale) {
		this.votoTotale = votoTotale;
	}
	public String getRisultato() {
		return risultato;
	}
	public void setRisultato(String risultato) {
		this.risultato = risultato;
	}
	//Assegna randomicamente un voto allo studente tra tutti i valori possibili
	public void prendiVotoRandom() {
		Random rnd=new Random();
		this.votoScritto=rnd.nextInt(-8,9);
		this.votoOrale=rnd.nextInt(0,25);
	}
	
	//To string dell'oggetto che ritorna tutti i valori di interesse in una forma leggibile
	//La casistica del 30 e lode viene risolta qui
	@Override
	public String toString() {
		
		if	(this.votoTotale>30) {
			return "Lo studente "+ nome + " ha ottenuto: voto scritto " + votoScritto + ", voto orale " + votoOrale + ", voto totale "
			+"30 e lode! risultato: " + risultato;
		}
		else return "Lo studente "+ nome + " ha ottenuto: voto scritto " + votoScritto + ", voto orale " + votoOrale + ", voto totale "
				+ votoTotale + ". risultato: " + risultato;
	}
	
}
