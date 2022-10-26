package srl.neotech.java06;

public class Vampiro implements Mostro {

	private Integer forza;

	public Vampiro(Integer forza) {
		super();
		this.forza = forza;
	}

	public Vampiro() {
		super();
	}

	public Integer getForza() {
		return forza;
	}

	public void setForza(Integer forza) {
		this.forza = forza;
	}

	@Override
	public String showForza() {
		return "il vampiro ha "+this.getForza()+" forza";
	}

	@Override
	public void azzanna() {
		System.out.println("il vampiro morde il collo e fa "+this.getForza()+" danni");
		
	}
	
	
}
