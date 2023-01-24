package srl.neotech.requestresponse;

import java.util.ArrayList;

import srl.neotech.model.RegioneDTO;

public class ListaRegioniResponse extends ResponseBase{
	
	private ArrayList<RegioneDTO> regioni;

	public ArrayList<RegioneDTO> getRegioni() {
		return regioni;
	}

	public void setRegioni(ArrayList<RegioneDTO> regioni) {
		this.regioni = regioni;
	}

}
