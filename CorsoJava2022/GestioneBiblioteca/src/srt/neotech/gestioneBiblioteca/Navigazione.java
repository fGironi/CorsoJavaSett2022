package srt.neotech.gestioneBiblioteca;

import java.util.HashMap;
import java.util.Scanner;

public class Navigazione {
	/*
X	CL	classificareLibro  -->aggiunta di un libro alla lista dei libri della Biblioteca

X	XL	rimuovereLibro     -->rimozione di un libro dalla lista dai libri della Biblioteca

X	LL  listaLibri         -->visualizzare la lista dei libri e per ogni libro stampare le info

X	IA	iscrivereAssociato -->aggiunta di un associato alla lista degli Associati

X	XA	cancellareAssociato-->rimozione di un associato dalla lista degli Associati

X	LA  listaAssociati     -->visualizzare la lista degli associati e per ogni associato stampare le info (compresa la lista dei libriPresi)

X	PL	presaLibro         -->aggiunta alla lista deli libri dell'associato

	RL	restituzioneLibro  -->rimozione dalla lista deli libri dell'associato

	XX  uscita             -->uscita dal programma
	
	SL ricercaLibro			->..
	
	SA ricercaAssociato		->..
	
	
	
	*/
	
	public void classificareLibro(Scanner scan, Biblioteca bib) {
		Libro nuovoL=new Libro();
			nuovoL.setIdLibro("L"+bib.getListaLibri().size());
		System.out.println("inserire il titolo del nuovo libro:");
			nuovoL.setTitolo(scan.nextLine());
		System.out.println("inserire l'autore del nuovo libro:");
			nuovoL.setAutore(scan.nextLine());
		System.out.println("inserire il genere del nuovo libro: (");
		System.out.println("\"fan\"=fantasy, \"gia\"=giallo, \"ros\"=rosa, \"hor\"=horror, \"sag\"=saggio, \"bam\"=bambini");
			String lGenere=scan.nextLine();
			if (lGenere.equals("fan")) nuovoL.setSezione(Genere.fantasy);
			if (lGenere.equals("gia")) nuovoL.setSezione(Genere.giallo);
			if (lGenere.equals("ros")) nuovoL.setSezione(Genere.rosa);
			if (lGenere.equals("hor")) nuovoL.setSezione(Genere.horror);
			if (lGenere.equals("sag")) nuovoL.setSezione(Genere.saggio);
			if (lGenere.equals("bam")) nuovoL.setSezione(Genere.bambini);
		System.out.println("inserire il numero dello scaffale in cui verra' riposto il libro");
			nuovoL.setScaffale(scan.nextInt());
			nuovoL.setStato(StatoLibro.Disponibile);
		bib.getListaLibri().put(nuovoL.getIdLibro(), nuovoL);
		System.out.println("aggiunto correttamente un nuovo libro nella lista della biblioteca");
		System.out.println(nuovoL);
	}
	
	public void rimuovereLibro(Scanner scan, Biblioteca bib) {
		System.out.println("inserire l'id del libro da rimuovere");
		String remoL=scan.nextLine();
		if (bib.getListaLibri().containsKey(remoL)) {
			System.out.println("vuoi rimuovere questo libro? (\"y\"/\"n\""); 
			System.out.println(bib.getListaLibri().get(remoL));
			String userConfirm=scan.nextLine();
			Boolean confirmed=false;
			while (confirmed==false) {
				if (userConfirm.equals("y")) {
					bib.getListaLibri().get(remoL).setStato(StatoLibro.Rimosso);
					System.out.println("libro rimosso:");
					System.out.println(bib.getListaLibri().get(remoL));
					confirmed=true;
				}
				else if (userConfirm.equals("n")) {
					System.out.println("d'accordo, ritorno al menu' principale");
					confirmed=true;
				}
				else {
					System.out.println("comando non riconosciuto");
					System.out.println("vuoi rimuovere questo libro? (\"y\"/\"n\")"); 
				}
			}
						
		}
		else System.out.println("l'id non corrisponde a nessun libro presente in biblioteca");
	}
	
	public void vediListaLibri(Scanner scan, Biblioteca bib) {
		for (Libro lib:bib.getListaLibri().values()) {
			if (lib.getStato()!=StatoLibro.Rimosso) System.out.println(lib);
		}
	}
	
	public void iscriviAssociato(Scanner scan, Biblioteca bib) {
		Associato nAs=new Associato();
		nAs.setIdAssociato("A"+bib.getListaAssociati().size());
		System.out.println("inserire il nominativo del nuovo associato");
		nAs.setNominativo(scan.nextLine());
		nAs.setStato(StatoAssociato.Attivo);
		HashMap<String, Libro> nLP=new HashMap<String, Libro>();
		nAs.setLibriPresi(nLP);
		System.out.println("inserito nuovo associato:");
		bib.getListaAssociati().put(nAs.getIdAssociato(), nAs);
		bib.getListaAssociati().get(nAs.getIdAssociato());
	}
	
	public void rimuovereAssociato(Scanner scan, Biblioteca bib) {
		System.out.println("inserire l'id dell'associato da rimuovere");
		String remoA=scan.nextLine();
		if (bib.getListaAssociati().containsKey(remoA)) {
			System.out.println("vuoi rimuovere questo associato? (\"y\"/\"n\""); 
			System.out.println(bib.getListaAssociati().get(remoA));
			String userConfirm=scan.nextLine();
			Boolean confirmed=false;
			while (confirmed==false) {
				if (userConfirm.equals("y")) {
					bib.getListaAssociati().get(remoA).setStato(StatoAssociato.Rimosso);
					System.out.println("Associato rimosso:");
					System.out.println(bib.getListaAssociati().get(remoA));
					confirmed=true;
				}
				else if (userConfirm.equals("n")) {
					System.out.println("d'accordo, ritorno al menu' principale");
					confirmed=true;
				}
				else {
					System.out.println("comando non riconosciuto");
					System.out.println("vuoi rimuovere questo associato? (\"y\"/\"n\")"); 
				}
			}
						
		}
		else System.out.println("l'id non corrisponde a nessun associato della biblioteca");
	}
	
	public void vediListaAssociati(Scanner scan, Biblioteca bib) {
		for (Associato ass:bib.getListaAssociati().values()) {
			if (ass.getStato()!=StatoAssociato.Rimosso) System.out.println(ass);
		}
	}
	
	public void presaLibro(Scanner scan, Biblioteca bib) {
		Boolean confirmAss=false;	Boolean confirmLib=false;	Boolean confirmAll=false;
		String idAss=null; String idLib=null;
		while (confirmAss==false) {
			System.out.println("inserire l'id dell'associato che sta prendendo il libro:");
			idAss=scan.nextLine();
			if (bib.getListaAssociati().containsKey(idAss)) {
				System.out.println(bib.getListaAssociati().get(idAss));
				if (bib.getListaAssociati().get(idAss).getStato()==StatoAssociato.Rimosso) {
					System.out.println("l'associato e' stato rimosso e non può prendere libri");
					confirmAll=true;
				}
				confirmAss=true;
			}
			else System.out.println("l'id non corrisponde a nessun associato della biblioteca");
		}
		while (confirmLib==false) {
			System.out.println("inserire l'id del libro che l'associato sta prendendo:");
			idLib=scan.nextLine();
			if (bib.getListaLibri().containsKey(idLib)) {
				System.out.println(bib.getListaLibri().get(idLib));
				if (bib.getListaLibri().get(idLib).getStato()!=StatoLibro.Disponibile) {
					System.out.println("il libro non e' disponibile");
					confirmAll=true;
				}
				confirmLib=true;
			}
			else System.out.println("l'id non corrisponde a nessun libro della biblioteca");
		}
		while (confirmAll==false) {
			System.out.println("questo associato sta prendendo questo libro, confermi? (\"y\"/\"n\")");
			System.out.println(bib.getListaAssociati().get(idAss));
			System.out.println(bib.getListaLibri().get(idLib));
			String userConfirm=scan.nextLine();
			if (userConfirm.equals("y")) {
				bib.getListaLibri().get(idLib).setStato(StatoLibro.InPrestito);
				bib.getListaAssociati().get(idAss).getLibriPresi().put(idLib, bib.getListaLibri().get(idLib));
				System.out.println("libro aggiunto ai libri presi dall'associato");
				confirmAll=true;
			}
			else if (userConfirm.equals("n")) {
				System.out.println("d'accordo, ritorno al menu' principale");
				confirmAll=true;
			}
		}
	}
	
	public void restituzioneLibro(Scanner scan, Biblioteca bib) {
		Boolean confirmAss=false;	Boolean confirmLib=false;	Boolean confirmAll=false;
		String idAss=null; String idLib=null;
		while (confirmAss==false) {
			System.out.println("inserire l'id dell'associato che sta restituendo il libro:");
			idAss=scan.nextLine();
			if (bib.getListaAssociati().containsKey(idAss)) {
				System.out.println(bib.getListaAssociati().get(idAss));
				confirmAss=true;
			}
			else System.out.println("l'id non corrisponde a nessun associato della biblioteca");
		}
		while (confirmLib==false) {
			System.out.println("inserire l'id del libro che l'associato sta restituendo:");
			idLib=scan.nextLine();
			if (bib.getListaAssociati().get(idAss).getLibriPresi().containsKey(idLib)) {
				System.out.println(bib.getListaAssociati().get(idAss).getLibriPresi().get(idLib));
				confirmLib=true;
			}
			else System.out.println("l'id non corrisponde a nessun libro preso dall'associato");
		}
		while (confirmAll==false) {
			System.out.println("questo associato sta restituendo questo libro, confermi? (\"y\"/\"n\")");
			System.out.println(bib.getListaAssociati().get(idAss));
			System.out.println(bib.getListaLibri().get(idLib));
			String userConfirm=scan.nextLine();
			if (userConfirm.equals("y")) {
				bib.getListaLibri().get(idLib).setStato(StatoLibro.Disponibile);
				bib.getListaAssociati().get(idAss).getLibriPresi().remove(idLib);
				System.out.println("libro rimosso dai libri presi dall'associato");
				confirmAll=true;
			}
			else if (userConfirm.equals("n")) {
				System.out.println("d'accordo, ritorno al menu' principale");
				confirmAll=true;
			}
		}
	}
	
	public void ricercaLibro(Scanner scan, Biblioteca bib) {
		Boolean ricercaFatta=false;
		while (ricercaFatta==false) {
			System.out.println("Scegliere il criterio con cui cercare il libro: \"ID\", \"titolo\", \"autore\" o \"genere\"");
			System.out.println("Scrivi \"quit\" per uscire");
			String modoRicerca=scan.nextLine();
			if (modoRicerca.equals("ID")) {
				System.out.println("inserire l'id da cercare");
				String cercaID=scan.nextLine();
				for (Libro lib:bib.getListaLibri().values()) {
					if (lib.getIdLibro().equals(cercaID)) System.out.println(lib);
				}
			
			}
			else if (modoRicerca.equals("titolo")) {
				System.out.println("inserire il titolo da cercare");
				String cercaTit=scan.nextLine();
				for (Libro lib:bib.getListaLibri().values()) {
					if (lib.getTitolo().contains(cercaTit)) System.out.println(lib);
				}
			}
			
			else if (modoRicerca.equals("autore")) {
				System.out.println("inserire l'autore da cercare");
				String cercaAut=scan.nextLine();
				for (Libro lib:bib.getListaLibri().values()) {
					if (lib.getAutore().contains(cercaAut)) System.out.println(lib);
				}
			
			}
			else if (modoRicerca.equals("genere")) {
				System.out.println("inserire il genere da cercare");
				String cercaGen=scan.nextLine();
				for (Libro lib:bib.getListaLibri().values()) {
					if (lib.getTitolo().equals(cercaGen)) System.out.println(lib);
				}
			
			}
			else if (modoRicerca.equals("quit")) {
				System.out.println("fine ricerca");
				ricercaFatta=true;
			}
			else System.out.println("comando non accettato");
		}
	}
	public void ricercaAssociato(Scanner scan, Biblioteca bib) {
		Boolean ricercaFatta=false;
		while (ricercaFatta==false) {
			System.out.println("Scegliere il criterio con cui cercare l'associato: \"ID\", o \"nome\"");
			System.out.println("Scrivi \"quit\" per uscire");
			String modoRicerca=scan.nextLine();
			if (modoRicerca.equals("ID")) {
				System.out.println("inserire l'id da cercare");
				String cercaID=scan.nextLine();
				for (Associato ass:bib.getListaAssociati().values()) {
					if (ass.getIdAssociato().equals(cercaID)) System.out.println(ass);
				}
			
			}
			else if (modoRicerca.equals("nome")) {
				System.out.println("inserire il nome da cercare");
				String cercaNome=scan.nextLine();
				for (Associato ass:bib.getListaAssociati().values()) {
					if (ass.getNominativo().contains(cercaNome)) System.out.println(ass);
				}
			}
			else if (modoRicerca.equals("quit")) {
				System.out.println("fine ricerca");
				ricercaFatta=true;
			}
			else System.out.println("comando non accettato");
		}
	}
	
}
