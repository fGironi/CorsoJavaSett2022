package srl.neotech.eserciziJava04;
import java.util.*;
import java.text.*;



public class ProdAlimentare extends Prodotto {

	private Date scadenza;

	
	
	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}

	public String getScadenza() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String scadenza = sdf.format(new Date()); 
		return scadenza;
	}

	public void setScadenza(String scadenza) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		this.scadenza = sdf.parse(scadenza);
				}
	@Override
	public String info() {
		return "scadenza: "+this.scadenza;
	}
	
	

}
