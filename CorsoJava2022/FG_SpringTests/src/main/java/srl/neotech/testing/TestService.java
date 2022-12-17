package srl.neotech.testing;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class TestService {

	//Variabili a fine di testing
	private Integer contaConnessioni=0;
	private Integer contaOggettcreati=0;
	private HashMap<String, TestModelOggetto> mapOgg;
	
	public TestService(){
		this.mapOgg=new HashMap<String, TestModelOggetto>();
		TestModelOggetto og1=new TestModelOggetto("A1", "Sfera", 5); this.mapOgg.put(og1.getId(), og1);
		TestModelOggetto og2=new TestModelOggetto("B2", "Cubo", 4); this.mapOgg.put(og2.getId(), og2);
		TestModelOggetto og3=new TestModelOggetto("C3", "Piramide", 8); this.mapOgg.put(og3.getId(), og3);
	}
	
	
	public void assegnaCodiceInventario(TestComponentInventario inv) {
		
		if (inv.getCodiceInventario()==null) {
			this.contaConnessioni++;
			inv.setCodiceInventario("Ciao"+this.contaConnessioni);
			System.out.println("Assegnato un nuovo codice inventario: "+inv.getCodiceInventario());
		}
		else {
			System.out.println("richiesta da codice inventario "+inv.getCodiceInventario());
		
		}
	}
	
	
	public void aggiungiOggetto (TestComponentInventario inv, TestModelOggetto ogg) {
		inv.getListaInventario().add(ogg);
		System.out.println("Aggiunto oggetto "+ogg+" nell'inventario "+inv.getCodiceInventario());
	}
	
	
	public String stampaInventario (TestComponentInventario inv) {
		System.out.println("Stampo la lista dell'inventario "+inv.getCodiceInventario());
		String stampa="";
		for (TestModelOggetto ogg: inv.getListaInventario()) {
			System.out.println(ogg);
			stampa=(stampa+" "+ogg.getNome()+",");
		}
		return stampa;
	}

	public Integer calcolaValoreInventario (TestComponentInventario inv) {
		System.out.println("Calcolo il valore complessivo dell'inventario "+inv.getCodiceInventario());
		inv.setValoreInventario(0);
		for (TestModelOggetto ogg: inv.getListaInventario()) {
			inv.setValoreInventario(inv.getValoreInventario()+ogg.getValore());
		}
		System.out.println("valore complessivo: "+inv.getValoreInventario());
		Integer totale=inv.getValoreInventario();
		return totale;
	}
	
	public void assegnaIdOggetto(TestModelOggetto oggetto) {
		String nuovoID="U"+this.contaOggettcreati;
		this.contaOggettcreati++;
		oggetto.setId(nuovoID);
	}
	
	

	public Integer getContaConnessioni() {
		return contaConnessioni;
	}


	public void setContaConnessioni(Integer contaConnessioni) {
		this.contaConnessioni = contaConnessioni;
	}


	public HashMap<String, TestModelOggetto> getMapOgg() {
		return mapOgg;
	}


	public void setMapOgg(HashMap<String, TestModelOggetto> mapOgg) {
		this.mapOgg = mapOgg;
	}


	public Integer getContaOggettcreati() {
		return contaOggettcreati;
	}


	public void setContaOggettcreati(Integer contaOggettcreati) {
		this.contaOggettcreati = contaOggettcreati;
	}
}
