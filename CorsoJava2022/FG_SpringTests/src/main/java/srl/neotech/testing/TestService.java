package srl.neotech.testing;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class TestService {

	private Integer contaConnessioni=0;
	private HashMap<String, TestComponentOggetto> mapOgg;
	
	public TestService(){
		this.mapOgg=new HashMap<String, TestComponentOggetto>();
		TestComponentOggetto og1=new TestComponentOggetto("A1", "Sfera", 5); this.mapOgg.put(og1.getId(), og1);
		TestComponentOggetto og2=new TestComponentOggetto("B2", "Cubo", 4); this.mapOgg.put(og2.getId(), og2);
		TestComponentOggetto og3=new TestComponentOggetto("C3", "Piramide", 8); this.mapOgg.put(og3.getId(), og3);
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
	
	
	public void aggiungiOggetto (TestComponentInventario inv, TestComponentOggetto ogg) {
		inv.getListaInventario().add(ogg);
		System.out.println("Aggiunto oggetto "+ogg+" nell'inventario "+inv.getCodiceInventario());
	}
	
	
	public String stampaInventario (TestComponentInventario inv) {
		System.out.println("Stampo la lista dell'inventario "+inv.getCodiceInventario());
		String stampa="";
		for (TestComponentOggetto ogg: inv.getListaInventario()) {
			System.out.println(ogg);
			stampa=(stampa+" "+ogg.getDescrizione()+",");
		}
		return stampa;
	}

	public Integer calcolaValoreInventario (TestComponentInventario inv) {
		System.out.println("Calcolo il valore complessivo dell'inventario "+inv.getCodiceInventario());
		inv.setValoreInventario(0);
		for (TestComponentOggetto ogg: inv.getListaInventario()) {
			inv.setValoreInventario(inv.getValoreInventario()+ogg.getValore());
		}
		System.out.println("valore complessivo: "+inv.getValoreInventario());
		Integer totale=inv.getValoreInventario();
		return totale;
	}
	
	

	public Integer getContaConnessioni() {
		return contaConnessioni;
	}


	public void setContaConnessioni(Integer contaConnessioni) {
		this.contaConnessioni = contaConnessioni;
	}


	public HashMap<String, TestComponentOggetto> getMapOgg() {
		return mapOgg;
	}


	public void setMapOgg(HashMap<String, TestComponentOggetto> mapOgg) {
		this.mapOgg = mapOgg;
	}
}
