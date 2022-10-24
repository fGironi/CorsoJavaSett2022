package srl.neotech;

import java.util.ArrayList;

public class Campo {

	private ArrayList<Striscia> strisce=new ArrayList<Striscia>();
	private Integer lunghezza;

	public ArrayList<Striscia> creaStrisce() {
		for (int i=0; i<10; i++){
				Striscia s=new Striscia();
				s.setNumeroStriscia(i+1);
				s.setLunghezza(80);
				if (i%2!=0) {s.setAltezzaErba(10);
				
				}
				else {s.setAltezzaErba(5);
				
				}
				strisce.add(s);
			}
	
		return strisce;}
			
	
	public ArrayList<Striscia> getStrisce() {
		return strisce;
	}	

	public void setStrisce(ArrayList<Striscia> strisce) {

		this.strisce = strisce;
		}
	


	

	public Integer getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(Integer lunghezza) {
		this.lunghezza = lunghezza;
	}

	
}
