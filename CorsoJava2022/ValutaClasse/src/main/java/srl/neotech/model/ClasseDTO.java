package srl.neotech.model;

import java.util.ArrayList;

public class ClasseDTO {

	private String id;
	private String nome;
	private String descrizione;
	private ArrayList<StudenteDTO> listaStudenti;
	private ArrayList<ConsegnaDTO> listaConsegne;
	private Integer anno;
	

	public ClasseDTO() {
		this.listaStudenti = new ArrayList<StudenteDTO>();
		this.listaConsegne = new ArrayList<ConsegnaDTO>();
	}
	
	
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
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public ArrayList<StudenteDTO> getListaStudenti() {
		return listaStudenti;
	}
	public void setListaStudenti(ArrayList<StudenteDTO> listaStudenti) {
		this.listaStudenti = listaStudenti;
	}
	public ArrayList<ConsegnaDTO> getListaConsegne() {
		return listaConsegne;
	}
	public void setListaConsegne(ArrayList<ConsegnaDTO> listaConsegne) {
		this.listaConsegne = listaConsegne;
	}
	public Integer getAnno() {
		return anno;
	}
	public void setAnno(Integer anno) {
		this.anno = anno;
	}


	@Override
	public String toString() {
		return "ClasseDTO [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", listaStudenti="
				+ listaStudenti.size() + ", listaConsegne=" + listaConsegne.size() + ", anno=" + anno + "]";
	}
	
	
}
