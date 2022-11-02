package neotech.srl.fabbricadibibita;

import java.util.*;

public class Fabbrica {
	private ArrayList<Cisterna> listaCisterne;
	private Integer threshold=15;
	
	public Fabbrica () {
		this.listaCisterne=new ArrayList<Cisterna>();
	}
	
	public ArrayList<Cisterna> getListaisterne() {
		return listaCisterne;
	}
	
	public void setListaCisterne(ArrayList<Cisterna> listaCisterne) {
		this.listaCisterne = listaCisterne;
	}
	
	public void creaListaCisterne() {
		Random rnd=new Random();
		for (int i=0; i<100; i++) {
			Cisterna c=new Cisterna(rnd);
			this.listaCisterne.add(c);
		}
	}
	
	public void riempiCisterne() {
		Random rnd=new Random();
	
		Integer quantitaRame=rnd.nextInt(1001);
		Integer evapPerDiRame=rnd.nextInt(1, 11);
		Integer livelloGasRame=rnd.nextInt(10, 101);
		
		Integer quantitaAcciaio=rnd.nextInt(1001);
		Integer evapPerDiAcciaio=rnd.nextInt(1, 11);
		Integer livelloGasAcciaio=rnd.nextInt(10, 101);
		
		Integer quantitaAlluminio=rnd.nextInt(1001);
		Integer evapPerDiAlluminio=rnd.nextInt(1, 11);;
		Integer livelloGasAlluminio=rnd.nextInt(10, 101);
		
		for (Cisterna c:this.listaCisterne)
			if (c.getTipologia()=="rame"){
				c.setEvapPerDi(evapPerDiRame);
				c.setLivelloGas(livelloGasRame);
				c.setQuantita(quantitaRame);
			}
			else if (c.getTipologia()=="acciaio") {
				c.setEvapPerDi(evapPerDiAcciaio);
				c.setLivelloGas(livelloGasAcciaio);
				c.setQuantita(quantitaAcciaio);
			}
			else if (c.getTipologia()=="alluminio") {
				c.setEvapPerDi(evapPerDiAlluminio);
				c.setLivelloGas(livelloGasAlluminio);
				c.setQuantita(quantitaAlluminio);
			}

		
		}

	public Integer getThreshold() {
		return threshold;
	}

	public void setThreshold(Integer threshold) {
		this.threshold = threshold;
	}
		
}