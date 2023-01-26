package srl.neotech.requestresponse;

import java.util.ArrayList;

import srl.neotech.model.PrevisioneDTO;

public class PrevisioniResponse extends ResponseBase{

	private ArrayList<PrevisioneDTO> previsioni;

	public ArrayList<PrevisioneDTO> getPrevisioni() {
		return previsioni;
	}

	public void setPrevisioni(ArrayList<PrevisioneDTO> previsioni) {
		this.previsioni = previsioni;
	}
}
