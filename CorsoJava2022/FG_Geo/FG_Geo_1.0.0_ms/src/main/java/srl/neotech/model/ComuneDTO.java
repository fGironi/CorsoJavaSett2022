package srl.neotech.model;

public class ComuneDTO {

	private Integer istat;
	private String nome;
	private String siglaProv;
	
	public ComuneDTO(Integer istat, String nome, String siglaProv) {
		super();
		this.istat = istat;
		this.nome = nome;
		this.siglaProv = siglaProv;

	}
	public Integer getIstat() {
		return istat;
	}
	public void setIstat(Integer istat) {
		this.istat = istat;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSiglaProv() {
		return siglaProv;
	}
	public void setSiglaProv(String siglaProv) {
		this.siglaProv = siglaProv;
	}
	
	
	
}
	