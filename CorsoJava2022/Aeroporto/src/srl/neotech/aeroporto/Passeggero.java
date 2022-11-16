package srl.neotech.aeroporto;

public class Passeggero {
/*
 * Una Passeggero possiede le proprietà: idUnivoco, MF, eta, classeViaggiatore, haBagli, haChampagne, haFiore, haGiornale. 
 * (La classeViaggiatore è di tipo: Business, Excelsior, Turista), haBagagli,haFiore,haGiornale (si,no)
 */
	private String idPasseggero;
	private String nominativo;
	private String mf;
	private Integer eta;
	private ClasseViaggiatore classe;
	private Boolean haBagagli;


	private String destinazione;
	
	
	public String getIdPasseggero() {
		return idPasseggero;
	}
	public void setIdPasseggero(String idPasseggero) {
		this.idPasseggero = idPasseggero;
	}
	public String getMf() {
		return mf;
	}
	public void setMf(String mf) {
		this.mf = mf;
	}
	public Integer getEta() {
		return eta;
	}
	public void setEta(Integer eta) {
		this.eta = eta;
	}
	public ClasseViaggiatore getClasse() {
		return classe;
	}
	public void setClasse(ClasseViaggiatore classe) {
		this.classe = classe;
	}
	public Boolean getHaBagagli() {
		return haBagagli;
	}
	public void setHaBagagli(Boolean haBagagli) {
		this.haBagagli = haBagagli;
	}


	public String getNominativo() {
		return nominativo;
	}
	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}
	public String getDestinazione() {
		return destinazione;
	}
	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}
	@Override
	public String toString() {
		return "Passeggero " + idPasseggero + "["+nominativo+", Genere=" + mf + ", eta=" + eta
				+ ", classe=" + classe + ", Bagagli=" + haBagagli;
	}
	
	
}
