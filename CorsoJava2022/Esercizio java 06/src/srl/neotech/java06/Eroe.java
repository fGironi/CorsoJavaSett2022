package srl.neotech.java06;

public class Eroe implements Umano {

	private Integer forza;

	
	public Eroe() {
		super();
	}
	
	public Eroe(Integer forza) {
		super();
		this.forza = forza;
	}

	public Integer getForza() {
		return forza;
	}

	public void setForza(Integer forza) {
		this.forza = forza;
	}

	@Override
	public String showForza() {
		return "L'eroe ha "+this.getForza()+" forza";
	}

	@Override
	public void combatti() {
		System.out.println("l'eroe attacca con la spada e fa "+this.getForza()+" danni");
		
	}
	
	
}
