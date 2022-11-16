package srl.neotech.aeroporto;

public class Excelsior extends Passeggero {

	private Boolean haChampagne=false;
	private Boolean haFiore=false;
	
	public Excelsior() {
		super();
		this.setClasse(ClasseViaggiatore.Excelsior);
	}

	public Boolean getHaChampagne() {
		return haChampagne;
	}

	public void setHaChampagne(Boolean haChampagne) {
		this.haChampagne = haChampagne;
	}

	public Boolean getHaFiore() {
		return haFiore;
	}

	public void setHaFiore(Boolean haFiore) {
		this.haFiore = haFiore;
	}

	
	
}
