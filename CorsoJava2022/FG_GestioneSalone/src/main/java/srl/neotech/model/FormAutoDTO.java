package srl.neotech.model;

import java.util.ArrayList;

public class FormAutoDTO {

	private AutomobileDTO automobile;
	private String idAutoMod;
	private ArrayList<String> idAccessori;
	private String idAccTap;
	private String idAccCer;
	private String idAccTet;
	private String idAccCar;
	private String idAccInt;
	
	
	public FormAutoDTO(AutomobileDTO automobile) {
		super();
		this.automobile = automobile;
		this.idAccessori = new ArrayList<String>();
	}

	public AutomobileDTO getAutomobile() {
		return automobile;
	}

	public void setAutomobile(AutomobileDTO automobile) {
		this.automobile = automobile;
	}

	public ArrayList<String> getIdAccessori() {
		return idAccessori;
	}

	public void setIdAccessori(ArrayList<String> idAccessori) {
		this.idAccessori = idAccessori;
	}

	public String getIdAccTap() {
		return idAccTap;
	}

	public void setIdAccTap(String idAccTap) {
		this.idAccTap = idAccTap;
	}

	public String getIdAccCer() {
		return idAccCer;
	}

	public void setIdAccCer(String idAccCer) {
		this.idAccCer = idAccCer;
	}

	public String getIdAccTet() {
		return idAccTet;
	}

	public void setIdAccTet(String idAccTet) {
		this.idAccTet = idAccTet;
	}

	public String getIdAccCar() {
		return idAccCar;
	}

	public void setIdAccCar(String idAccCar) {
		this.idAccCar = idAccCar;
	}

	public String getIdAccInt() {
		return idAccInt;
	}

	public void setIdAccInt(String idAccInt) {
		this.idAccInt = idAccInt;
	}

	public String getIdAutoMod() {
		return idAutoMod;
	}

	public void setIdAutoMod(String idAutoMod) {
		this.idAutoMod = idAutoMod;
	}
	
	
}
