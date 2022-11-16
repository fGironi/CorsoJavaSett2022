package srl.neotech.aeroporto;

public class Business extends Passeggero {
	
	private Boolean haGiornale=false;
	public Business() {
		super();
		this.setClasse(ClasseViaggiatore.Business);
	}

	public Boolean getHaGiornale() {
		return haGiornale;
	}
	public void setHaGiornale(Boolean haGiornale) {
		this.haGiornale = haGiornale;
	}
}