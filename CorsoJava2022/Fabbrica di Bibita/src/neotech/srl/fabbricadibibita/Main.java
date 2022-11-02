package neotech.srl.fabbricadibibita;

public class Main {

	public static void main(String[] args) {
		Fabbrica fab=new Fabbrica();
		fab.creaListaCisterne();
		fab.riempiCisterne();
		
		Integer bibita=0;
		for(Cisterna c:fab.getListaisterne()) if (c.getLivelloGas()>fab.getThreshold()) bibita=(bibita+c.getQuantita());
		System.out.println("quantità di bibita vendibile attualmente: "+bibita);
		
		bibita=0;
		for(Cisterna c:fab.getListaisterne()) {
			c.setLivelloGas(c.getLivelloGas()-(c.getEvapPerDi()*7));	
			if (c.getLivelloGas()>fab.getThreshold()) bibita=(bibita+c.getQuantita());
		}
		System.out.println("quantità di bibita vendibile tra 7 giorni: "+bibita);
		
	
		for(Cisterna c:fab.getListaisterne()) if (c.getLivelloGas()>fab.getThreshold()) bibita=(bibita+c.getQuantita());
		Integer giorni=0;
		while (bibita>0) {
			bibita=0; giorni++;
			for (Cisterna c:fab.getListaisterne()) {
				if (c.getLivelloGas()>fab.getThreshold()) bibita=(bibita+c.getQuantita());
				c.setLivelloGas(c.getLivelloGas()-c.getEvapPerDi());
			}
		}
		System.out.println("tra "+giorni+" giorni si esauriranno le scorte di bibita vendibile");
	}
	

}
