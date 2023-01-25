package srl.neotech.model;

public class ComuneDTO {

	private String istat;
	private String nome;
	private String siglaProv;
	
	public ComuneDTO(String istat, String nome, String siglaProv) {
		super();
		this.istat = istat;
		this.nome = nome;
		this.siglaProv = siglaProv;

	}
	public String getIstat() {
		return istat;
	}
	public void setIstat(String istat) {
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
	