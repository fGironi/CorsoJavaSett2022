package srl.neotech.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import srl.neotech.dao.GeoDAO;
import srl.neotech.model.ComuneAutoDTO;
import srl.neotech.model.ComuneDTO;
import srl.neotech.model.GeoLocalizzazioneDTO;
import srl.neotech.model.MeteoInfoDTO;
import srl.neotech.model.PrevisioneDTO;
import srl.neotech.model.ProvinciaDTO;
import srl.neotech.model.RegioneDTO;
import srl.neotech.requestresponse.MeteoRequest;

@Service
public class GeoService {
	
	@Autowired
	GeoDAO geoDAO;
	
	WebClient.Builder builder = WebClient.builder();
	

	public ArrayList<RegioneDTO> getListaRegioni() {
		return geoDAO.getListaRegioni();
	}

	public ArrayList<ProvinciaDTO> getListaProvince(Integer idReg) {
		return geoDAO.getlistaProvince(idReg);
	}

	public ArrayList<ComuneDTO> getListaComuni(String siglaProv) {
		return geoDAO.getListaComuni(siglaProv);
	}

	public ArrayList<ComuneAutoDTO> getListaComuniAuto(String input) {
		return geoDAO.getListaComuniAuto(input);
	}
	
	public String getMeteoUrl(GeoLocalizzazioneDTO geo) {
		String meteo_url="https://api.open-meteo.com/v1/forecast?latitude="+geo.getLatitudine()+"&longitude="+geo.getLongitudine()+"&daily=weathercode,temperature_2m_max,temperature_2m_min,rain_sum&timezone=Europe/Berlin";
		return meteo_url;
	}

	public GeoLocalizzazioneDTO getGeoLocal(String istat) {
		GeoLocalizzazioneDTO geo= geoDAO.getGeoLocal(istat);
		return geo;
	}

	public String getIstat(String comune) {
		return geoDAO.getIstat(comune);
	}

	public MeteoInfoDTO meteoInfo(GeoLocalizzazioneDTO geo) {
		MeteoRequest meteoRequest= builder.build()
				.get()
				.uri(this.getMeteoUrl(geo))
				.retrieve()
				.bodyToMono(MeteoRequest.class)
				.block();
		MeteoInfoDTO meteoInfo=meteoRequest.getDaily();
		return meteoInfo;
	}

	public ArrayList<PrevisioneDTO> previsioni(MeteoInfoDTO meteo){
		ArrayList<PrevisioneDTO> previsioni=new ArrayList<PrevisioneDTO>();
		for (int i=0; i<meteo.getTime().size(); i++) {
			PrevisioneDTO prev=new PrevisioneDTO();
			prev.setRain_sum(meteo.getRain_sum().get(i));
			prev.setTemperature_2m_max(meteo.getTemperature_2m_max().get(i));
			prev.setTemperature_2m_min(meteo.getTemperature_2m_min().get(i));
			prev.setTime(meteo.getTime().get(i));
			prev.setWeathercode(meteo.getWeathercode().get(i));
			previsioni.add(prev);
		}
		return previsioni;
	}
	
	public ArrayList<PrevisioneDTO> getPrevisioni(String istat) {
		GeoLocalizzazioneDTO geo=this.getGeoLocal(istat);
		MeteoInfoDTO meteo=this.meteoInfo(geo);
		ArrayList<PrevisioneDTO> previsioni=this.previsioni(meteo);
		return previsioni;
	}
	
}
