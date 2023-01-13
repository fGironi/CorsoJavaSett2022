package srl.neotech.requestresponse;

import java.util.ArrayList;

import srl.neotech.model.AutoDTO;

public class GetListaAutoResponse extends ResponseBase{

	private ArrayList <AutoDTO> listaAuto;

	public ArrayList <AutoDTO> getListaAuto() {
		return listaAuto;
	}

	public void setListaAuto(ArrayList <AutoDTO> listaAuto) {
		this.listaAuto = listaAuto;
	}
}
