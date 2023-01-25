package srl.neotech.requestresponse;

import java.util.ArrayList;

import srl.neotech.model.ComuneAutoDTO;

public class AutoCompleteResponse extends ResponseBase {

	private ArrayList<ComuneAutoDTO> nomiComuni;

	public ArrayList<ComuneAutoDTO> getNomiComuni() {
		return nomiComuni;
	}

	public void setNomiComuni(ArrayList<ComuneAutoDTO> nomiComuni) {
		this.nomiComuni = nomiComuni;
	}
}
