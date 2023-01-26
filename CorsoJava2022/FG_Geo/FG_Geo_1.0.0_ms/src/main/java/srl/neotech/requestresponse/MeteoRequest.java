package srl.neotech.requestresponse;

import srl.neotech.model.MeteoInfoDTO;

public class MeteoRequest {

	private MeteoInfoDTO daily;

	public MeteoInfoDTO getDaily() {
		return daily;
	}

	public void setDaily(MeteoInfoDTO daily) {
		this.daily = daily;
	}
}
