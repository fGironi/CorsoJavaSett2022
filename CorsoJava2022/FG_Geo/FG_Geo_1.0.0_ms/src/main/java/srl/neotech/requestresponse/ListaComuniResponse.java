package srl.neotech.requestresponse;

import java.util.ArrayList;

import srl.neotech.model.ComuneDTO;

public class ListaComuniResponse extends ResponseBase{
	
	private ArrayList<ComuneDTO> comuni;

	public ArrayList<ComuneDTO> getComuni() {
		return comuni;
	}

	public void setComuni(ArrayList<ComuneDTO> comuni) {
		this.comuni = comuni;
	}



}
