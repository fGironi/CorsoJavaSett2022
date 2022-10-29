package srl.neotech.java07;

public class Vampiro extends Mostro {

	private String nomeClasse="il vampiro";	
	
		
	public String getNomeClasse() {
		return nomeClasse;
	}

	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}

	@Override
	public void attacca() {
		System.out.println(this.nomeClasse+" morde al collo");
		
	}

	@Override
	public void difendi() {
		System.out.println(this.nomeClasse+" evita il colpo trasformandosi in nebbia");
	}

	@Override
	public void muori() {
		System.out.println(this.nomeClasse+" viene ridotto in cenere");
	}

	@Override
	public void caccia() {
		System.out.println(this.nomeClasse+" va a caccia di vergini");
	}

	@Override
	public void vaInLetargo() {
		System.out.println(this.nomeClasse+" si chiude nella sua bara");
	}
	
	

}
