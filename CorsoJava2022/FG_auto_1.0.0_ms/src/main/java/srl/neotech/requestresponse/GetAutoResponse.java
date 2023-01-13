package srl.neotech.requestresponse;

import srl.neotech.model.AutoDTO;

public class GetAutoResponse extends ResponseBase{

	private AutoDTO auto;

	public AutoDTO getAuto() {
		return auto;
	}

	public void setAuto(AutoDTO auto) {
		this.auto = auto;
	}
}
