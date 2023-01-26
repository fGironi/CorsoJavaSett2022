package srl.neotech.model;

public class PrevisioneDTO {

	private String time;
	private Integer weathercode;
	private Float temperature_2m_max;
	private Float temperature_2m_min;
	private Float rain_sum;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getWeathercode() {
		return weathercode;
	}
	public void setWeathercode(Integer weathercode) {
		this.weathercode = weathercode;
	}
	public Float getTemperature_2m_max() {
		return temperature_2m_max;
	}
	public void setTemperature_2m_max(Float temperature_2m_max) {
		this.temperature_2m_max = temperature_2m_max;
	}
	public Float getTemperature_2m_min() {
		return temperature_2m_min;
	}
	public void setTemperature_2m_min(Float temperature_2m_min) {
		this.temperature_2m_min = temperature_2m_min;
	}
	public Float getRain_sum() {
		return rain_sum;
	}
	public void setRain_sum(Float rain_sum) {
		this.rain_sum = rain_sum;
	}
	
	
}
