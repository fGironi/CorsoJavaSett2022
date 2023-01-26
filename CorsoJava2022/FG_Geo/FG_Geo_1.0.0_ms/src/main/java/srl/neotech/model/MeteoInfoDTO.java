package srl.neotech.model;

import java.util.ArrayList;

public class MeteoInfoDTO {

	private ArrayList<String> time=new ArrayList<String>();
	private ArrayList<Integer> weathercode = new ArrayList<Integer>();
	private ArrayList<Float> temperature_2m_max =new ArrayList<Float>();
	private ArrayList<Float> temperature_2m_min =new ArrayList<Float>();
	private ArrayList<Float> rain_sum =new ArrayList<Float>();
	
	
	
	public ArrayList<String> getTime() {
		return time;
	}
	public void setTime(ArrayList<String> time) {
		this.time = time;
	}
	public ArrayList<Integer> getWeathercode() {
		return weathercode;
	}
	public void setWeathercode(ArrayList<Integer> weathercode) {
		this.weathercode = weathercode;
	}
	public ArrayList<Float> getTemperature_2m_max() {
		return temperature_2m_max;
	}
	public void setTemperature_2m_max(ArrayList<Float> temperature_2m_max) {
		this.temperature_2m_max = temperature_2m_max;
	}
	public ArrayList<Float> getTemperature_2m_min() {
		return temperature_2m_min;
	}
	public void setTemperature_2m_min(ArrayList<Float> temperature_2m_min) {
		this.temperature_2m_min = temperature_2m_min;
	}
	public ArrayList<Float> getRain_sum() {
		return rain_sum;
	}
	public void setRain_sum(ArrayList<Float> rain_sum) {
		this.rain_sum = rain_sum;
	}
	
	
}
