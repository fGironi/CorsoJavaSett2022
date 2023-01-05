package srl.neotech.model.forms;

import java.util.ArrayList;

import srl.neotech.model.ClasseDTO;

public class NuovaClasseForm {

	private ClasseDTO classe;
	private ArrayList<String> nomiStudenti;
		
	
	public NuovaClasseForm(ClasseDTO classe) {
		super();
		this.classe = classe;
		this.nomiStudenti = new ArrayList<String>();
	}
	public NuovaClasseForm() {
		super();
		this.nomiStudenti = new ArrayList<String>();
	}
	public ClasseDTO getClasse() {
		return classe;
	}
	public void setClasse(ClasseDTO classe) {
		this.classe = classe;
	}
	public ArrayList<String> getNomiStudenti() {
		return nomiStudenti;
	}
	public void setNomiStudenti(ArrayList<String> nomiStudenti) {
		this.nomiStudenti = nomiStudenti;
	}	
	
	
}
