package srl.neotech.model;

import java.util.ArrayList;

public class Giocatore {

	private String nome;
	private ArrayList<Punteggio> punteggi;
	
	public Giocatore(String nome) {
		this.nome = nome;
		this.punteggi=new ArrayList<Punteggio>();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Punteggio> getPunteggi() {
		return punteggi;
	}
	public void setPunteggi(ArrayList<Punteggio> punteggi) {
		this.punteggi = punteggi;
	}
	
	
}
