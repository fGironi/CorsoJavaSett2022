package neotech.srl.fabbricadibibita;
import java.util.Random;

public class Cisterna {
	
	private String tipologia;
	private Integer quantita;
	private Integer evapPerDi;
	private Integer livelloGas;
	
	public Cisterna(Random rnd) {
		Integer i=rnd.nextInt(3);
		if(i==0) this.tipologia=TipologiaCisterna.rame.toString();
		if(i==1) this.tipologia=TipologiaCisterna.alluminio.toString();
		if(i==2) this.tipologia=TipologiaCisterna.acciaio.toString();
		
	}
	
	public Integer getQuantita() {
		return quantita;
	}
	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}
	public Integer getEvapPerDi() {
		return evapPerDi;
	}
	public void setEvapPerDi(Integer evapPerDi) {
		this.evapPerDi = evapPerDi;
	}
	public Integer getLivelloGas() {
		return livelloGas;
	}
	public void setLivelloGas(Integer livelloGas) {
		this.livelloGas = livelloGas;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	@Override
	public String toString() {
		return "Cisterna [tipologia=" + tipologia + ", quantita=" + quantita + ", evapPerDi=" + evapPerDi
				+ ", livelloGas=" + livelloGas + "]";
	}
	
	
	
	
}
