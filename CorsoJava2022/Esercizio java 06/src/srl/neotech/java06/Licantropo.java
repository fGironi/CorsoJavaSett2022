package srl.neotech.java06;

public class Licantropo implements Mostro, Umano {

	private Integer forzaUmano;
	private Integer forzaMostro;
	private Boolean trasformato;
	
	public Licantropo(Integer forzaUmano, Integer forzaMostro, Boolean trasformato) {
		super();
		this.forzaUmano = forzaUmano;
		this.forzaMostro = forzaMostro;
		this.trasformato = trasformato;
	}

	public Licantropo() {
		super();
	}

	public Integer getForzaUmano() {
		return forzaUmano;
	}

	public void setForzaUmano(Integer forzaUmano) {
		this.forzaUmano = forzaUmano;
	}

	public Integer getForzaMostro() {
		return forzaMostro;
	}

	public void setForzaMostro(Integer forzaMostro) {
		this.forzaMostro = forzaMostro;
	}

	public Boolean getTrasformato() {
		return trasformato;
	}

	public void setTrasformato(Boolean trasformato) {
		this.trasformato = trasformato;
	}

	@Override
	public String showForza() {
		if (this.getTrasformato()==true) {
			return "il licantropo ha "+this.getForzaMostro()+" forza";
		}
		else {return "il licantropo ha "+this.getForzaUmano()+" forza";}
	}

	@Override
	public void combatti() {
		System.out.println("il licantropo sferra calci e pugni e infligge "+this.getForzaUmano()+" danni");
		
	}

	@Override
	public void azzanna() {
		System.out.println("il licantropo azzanna alla gola e infligge "+this.getForzaMostro()+" danni");
		
	}
	
	public void trasforma() {
		if (this.getTrasformato()==true) {
			this.setTrasformato(false);
			System.out.println("il licantropo diventa un umano");
		}
		else {
			this.setTrasformato(true);
			System.out.println("il licantropo diventa un mostro");
					}
	}

	public void attacca() {
		if (this.getTrasformato()==true) {
			this.azzanna();
		}
		else {this.combatti();}
	}
	
	
	
	
}
