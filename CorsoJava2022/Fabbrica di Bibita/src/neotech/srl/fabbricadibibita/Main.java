package neotech.srl.fabbricadibibita;

public class Main {

	public static void main(String[] args) {
		Fabbrica fab=new Fabbrica();
		fab.creaListaCisterne();
		fab.riempiCisterne();
		
		Integer bibita=0;
		for(Cisterna c:fab.getListaisterne()) if (c.getLivelloGas()>fab.getThreshold()) bibita=(bibita+c.getQuantita());
		System.out.println("quantità di bibita vendibile attualmente: "+bibita);
		
		bibita=0; Integer cisterneAttive=0;
		for(Cisterna c:fab.getListaisterne()) {
			System.out.println(c.getTipologia()+" "+c.getLivelloGas()+" su "+fab.getThreshold()+", evaporazione: "+c.getEvapPerDi());
			for (int i=0; i<7; i++) {
				c.setLivelloGas(c.getLivelloGas()-c.getEvapPerDi());
				if (c.getLivelloGas()<fab.getThreshold()) {
				 System.out.println("cisterna svuotata al giorno"+i); i=7;
				}
			}
		//	System.out.println(c.getTipologia()+" ridotta a "+c.getLivelloGas()+" su "+fab.getThreshold());
			if (c.getLivelloGas()>=fab.getThreshold()) {
				bibita=(bibita+c.getQuantita()); //System.out.println("prodotta "+bibita+" bibita");
				cisterneAttive++;
			}
		//	else System.out.println("cisterna non funzionante");
		}
		System.out.println(cisterneAttive+"quantità di bibita vendibile tra 7 giorni: "+bibita);
		
		
		
	
		bibita=1;
		Integer giorni=1;
		while (bibita>0) {
			bibita=0; cisterneAttive=0;
			for (Cisterna c:fab.getListaisterne()) {
				if (c.getLivelloGas()>=fab.getThreshold()) {
					cisterneAttive++;
					bibita=(bibita+c.getQuantita());
		//			System.out.println("funzionante:");
				}
			c.setLivelloGas(c.getLivelloGas()-c.getEvapPerDi());
		//		System.out.println(c.getTipologia()+" "+c.getLivelloGas()+" su "+fab.getThreshold());
			}
			if (giorni==7) System.out.println(bibita);
			giorni++; 
			
			System.out.println(giorni+"° giorno, cisterne: "+cisterneAttive+", bibita:"+bibita);
		}
	
		System.out.println("tra "+giorni+" giorni si esauriranno le scorte di bibita vendibile");
		
	}
	
	

}
