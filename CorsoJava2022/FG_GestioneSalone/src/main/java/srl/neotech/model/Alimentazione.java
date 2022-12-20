package srl.neotech.model;


public enum Alimentazione {

	Benzina("benzina"),
	Diesel("diesel"),
	GPL("GPL"),
	Elettrica("elettrica"),
	Ibrida("ibrida");
	
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
