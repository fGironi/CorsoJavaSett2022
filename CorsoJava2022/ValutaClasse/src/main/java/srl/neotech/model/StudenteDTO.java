package srl.neotech.model;

import java.util.HashMap;

public class StudenteDTO {

	private String id;
	private String nominativo;
	private ClasseDTO classe;
	private HashMap<String, Integer> votiPresi;
	private Integer mediaAttuale;
	
	
	public StudenteDTO() {
		this.votiPresi = new HashMap<String, Integer>();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNominativo() {
		return nominativo;
	}
	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}
	public ClasseDTO getClasse() {
		return classe;
	}
	public void setClasse(ClasseDTO classe) {
		this.classe = classe;
	}
	public HashMap<String, Integer> getVotiPresi() {
		return votiPresi;
	}
	public void setVotiPresi(HashMap<String, Integer> votiPresi) {
		this.votiPresi = votiPresi;
	}
	public Integer getMediaAttuale() {
		return mediaAttuale;
	}
	public void setMediaAttuale(Integer mediaAttuale) {
		this.mediaAttuale = mediaAttuale;
	}
	
	
	
}
