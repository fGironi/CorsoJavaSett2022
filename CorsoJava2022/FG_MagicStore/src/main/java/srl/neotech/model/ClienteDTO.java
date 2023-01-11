package srl.neotech.model;

import java.time.LocalTime;

public class ClienteDTO {

	private String nome;
	private ProblemaDTO problema;
	private Integer oro;
	private Integer pazienza;
	private LocalTime oraArrivo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ProblemaDTO getProblema() {
		return problema;
	}
	public void setProblema(ProblemaDTO problema) {
		this.problema = problema;
	}
	public Integer getOro() {
		return oro;
	}
	public void setOro(Integer oro) {
		this.oro = oro;
	}
	public Integer getPazienza() {
		return pazienza;
	}
	public void setPazienza(Integer pazienza) {
		this.pazienza = pazienza;
	}
	public LocalTime getOraArrivo() {
		return oraArrivo;
	}
	public void setOraArrivo(LocalTime oraArrivo) {
		this.oraArrivo = oraArrivo;
	}
	
	
}
