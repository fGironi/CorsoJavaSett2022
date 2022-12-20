package srl.neotech.model;


public enum Alimentazione {

	BENZINA("benzina"),
	DIESEL("diesel"),
	GPL("GPL"),
	ELETTRICA("elettrica"),
	IBRIDA("ibrida");
	
	private String name;
	
	private Alimentazione(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
