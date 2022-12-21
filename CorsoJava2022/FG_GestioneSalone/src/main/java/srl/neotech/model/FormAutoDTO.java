package srl.neotech.model;

import java.util.ArrayList;

public class FormAutoDTO {

	private AutomobileDTO automobile;
	private ArrayList<String> idAccessori;
	
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
	
	
}
