package srl.neotech.requestresponse;

import java.util.ArrayList;

import srl.neotech.model.ProvinciaDTO;

public class ListaProvinceResponse extends ResponseBase{
	
	private ArrayList<ProvinciaDTO> province;

	public ArrayList<ProvinciaDTO> getProvince() {
		return province;
	}

	public void setProvince(ArrayList<ProvinciaDTO> province) {
		this.province = province;
	}


}
