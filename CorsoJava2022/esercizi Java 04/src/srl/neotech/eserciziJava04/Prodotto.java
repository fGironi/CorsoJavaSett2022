package srl.neotech.eserciziJava04;

//interface ProdInfo {public String info();}

public class Prodotto { //implements ProdInfo {
	
	private String nome;
	private String codiceBarre;
	private String descrizione;
	private double prezzo;
	private boolean isAlimentare;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiceBarre() {
		return codiceBarre;
	}

	public void setCodiceBarre(String codiceBarre) {
		this.codiceBarre = codiceBarre;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public boolean isAlimentare() {
		return isAlimentare;
	}

	public void setAlimentare(boolean isAlimentare) {
		this.isAlimentare = isAlimentare;
	}

	public String info() {
		return "prodotto non specificato";
	}
	
	//applicaSconto2 trasforma il prezzo del prodotto sul momento e restituisce una diversa variabile
	public double applicaSconto1(double prezzo) {
		double pScontato;
		pScontato=prezzo-(prezzo/20);
		return pScontato;
	}
		
	//applicaSconto2 restituisce un prodotto il cui prezzo è stato trasformato perennemente
	public Prodotto applicaSconto2(Prodotto prod) {
		double pScontato;
		pScontato=prod.prezzo-(prod.prezzo/20);
		prod.prezzo=pScontato;
		return prod;
	}


}