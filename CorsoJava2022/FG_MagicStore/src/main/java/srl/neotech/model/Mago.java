package srl.neotech.model;

import java.util.ArrayList;

public class Mago {

	private String id;
	private String nome;
	private String avatarURL;
	private ArrayList<MagiaDTO> listaMagie;
	private Integer fama;
	private Integer stress;
	private Integer oro;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<MagiaDTO> getListaMagie() {
		return listaMagie;
	}
	public void setListaMagie(ArrayList<MagiaDTO> listaMagie) {
		this.listaMagie = listaMagie;
	}
	public Integer getFama() {
		return fama;
	}
	public void setFama(Integer fama) {
		this.fama = fama;
	}
	public Integer getStress() {
		return stress;
	}
	public void setStress(Integer stress) {
		this.stress = stress;
	}
	public Integer getOro() {
		return oro;
	}
	public void setOro(Integer oro) {
		this.oro = oro;
	}
	public String getAvatarURL() {
		return avatarURL;
	}
	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}
	
	
}
