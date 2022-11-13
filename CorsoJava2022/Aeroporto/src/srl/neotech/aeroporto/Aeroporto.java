package srl.neotech.aeroporto;

import java.util.HashMap;

public class Aeroporto {
//	L'aeroporto ha: Aerei, Passeggeri, raggioDiAzione che indica il raggio in 
//	km(da 1 a 100) entro il quale gestisce gli Aerei, intorno al proprio spazio aereo.
	private HashMap <String, Aereo> aereiInPartenza;
	private HashMap <String, Aereo> aereiInArrivo;
	private HashMap <String, Passeggero> listaPasseggeri;
	private Integer raggioDiAzione;
	
	
	public Aeroporto() {
		super();
		this.aereiInPartenza=new HashMap <String, Aereo>();
		this.aereiInArrivo=new HashMap <String, Aereo>();
		this.listaPasseggeri=new HashMap <String, Passeggero>();
		this.raggioDiAzione=100;
	}

	
	
	
	public HashMap<String, Aereo> getAereiInPartenza() {
		return aereiInPartenza;
	}




	public void setAereiInPartenza(HashMap<String, Aereo> aereiInPartenza) {
		this.aereiInPartenza = aereiInPartenza;
	}




	public HashMap<String, Aereo> getAereiInArrivo() {
		return aereiInArrivo;
	}




	public void setAereiInArrivo(HashMap<String, Aereo> aereiInArrivo) {
		this.aereiInArrivo = aereiInArrivo;
	}




	public HashMap<String, Passeggero> getListaPasseggeri() {
		return listaPasseggeri;
	}

	public void setListaPasseggeri(HashMap<String, Passeggero> listaPasseggeri) {
		this.listaPasseggeri = listaPasseggeri;
	}

	public Integer getRaggioDiAzione() {
		return raggioDiAzione;
	}

	public void setRaggioDiAzione(Integer raggioDiAzione) {
		this.raggioDiAzione = raggioDiAzione;
	}

	public Aereo atterraggio(Aereo a) {
		if (a.getStato().equals(StatoAereo.IN_AVVICINAMENTO)) {
			System.out.println("faccio atterare l'aereo "+a.getIdAereo());
			a.setStato(StatoAereo.ATTERRATO);
			System.out.println("ci sono "+a.getListaPasseggeri().size()+" passeggeri a bordo");
			for (Passeggero p:a.getListaPasseggeri().values()) {
				this.checkout(p); 
				
				
			}
			
		}
		else if (a.getStato().equals(StatoAereo.ATTERRATO)) System.out.println("Errore: l'aereo e' gia' atterrato");
		else if (a.getStato().equals(StatoAereo.DECOLLATO)) System.out.println("Errore: l'aereo e' appena decollato");
		else if (a.getStato().equals(StatoAereo.FUORI_SPAZIO_AEREO)) System.out.println("Errore: l'aereo e' fuori dallo spazio aereo");
		else if (a.getStato().equals(StatoAereo.IN_PARTENZA)) System.out.println("Errore: l'aereo e' ancora in partenza");
				
		return a;
	}
	

	public Aereo decollo(Aereo a) {
		if (a.getStato().equals(StatoAereo.IN_PARTENZA)) {
			a.setStato(StatoAereo.DECOLLATO);
			System.out.println("Decollato l'aereo "+a.getIdAereo()+", ci sono a bordo "+a.getListaPasseggeri().size()+" passeggeri");
			a.setVelocita(1);
			}
		else if (a.getStato().equals(StatoAereo.ATTERRATO)) System.out.println("Errore: l'aereo e' appena' atterrato");
		else if (a.getStato().equals(StatoAereo.DECOLLATO)) System.out.println("Errore: l'aereo e' gia' decollato");
		else if (a.getStato().equals(StatoAereo.FUORI_SPAZIO_AEREO)) System.out.println("Errore: l'aereo e' fuori dallo spazio aereo");
		else if (a.getStato().equals(StatoAereo.IN_AVVICINAMENTO)) System.out.println("Errore: l'aereo e' ancora in avvicinamento");
				
		return a;
		
	}

	public Passeggero checkin(Passeggero p) {
		System.out.println("Checkin "+p);
		
		if (p.getClasse()==ClasseViaggiatore.Business) {
			p.setHaGiornale(true); 
			System.out.println("Aggiunto giornale ");
		}
		if (p.getClasse()==ClasseViaggiatore.Excelsior) {
			System.out.print("Aggiunto ");
			p.setHaChampagne(true); System.out.print("champagne ");
			if (p.getMf().equals("F")) {
				p.setHaFiore(true); System.out.print("e fiore");
			}
			System.out.println();
		}
		
		return p;
		
	}

	public Passeggero checkout(Passeggero p) {
		System.out.println("Checkout "+p);
		
		return p;
		
	}
	
}
