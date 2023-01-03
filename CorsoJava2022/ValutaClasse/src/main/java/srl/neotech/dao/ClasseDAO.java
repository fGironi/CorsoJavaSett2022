package srl.neotech.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import srl.neotech.model.ClasseDTO;

@Component
public class ClasseDAO {

	private HashMap<String, ClasseDTO> listaClassi;
	
	
	public ClasseDAO () {
		this.listaClassi=new HashMap<String, ClasseDTO>();
	}


	public HashMap<String, ClasseDTO> getListaClassi() {
		return listaClassi;
	}


	public void setListaClassi(HashMap<String, ClasseDTO> listaClassi) {
		this.listaClassi = listaClassi;
	}
	
}
