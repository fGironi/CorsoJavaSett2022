package srt.neotech.gestioneBiblioteca;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import com.github.javafaker.Faker;


public class Main {

	public static void main(String[] args) {
		Faker faker=new Faker();
		Random rnd=new Random();
		Biblioteca bib=new Biblioteca();
		Navigazione nav=new Navigazione();
		Scanner scan=new Scanner(System.in);
		
		
		//Creazione di 100 libri casuali
		for (int i=0; i<100; i++) {
			Libro l=new Libro();
			l.setIdLibro("L"+i);
			//Titolo casuale
				Integer rndTtl=rnd.nextInt(0,10);
				if (rndTtl==0) l.setTitolo(faker.zelda().character()+": "+faker.zelda().game());
				if (rndTtl==1) l.setTitolo(faker.ancient().hero()+" & "+faker.ancient().god());
				if (rndTtl==2) l.setTitolo(faker.funnyName().name()+"'s adventures");
				if (rndTtl==3) l.setTitolo(faker.programmingLanguage().name()+" vs "+faker.programmingLanguage().name());
				if (rndTtl==4) l.setTitolo(faker.relationships().parent()+" "+faker.aviation().airport());
				if (rndTtl==5) l.setTitolo(faker.country().name()+", "+faker.address().city()+", "+faker.cat().breed());
				if (rndTtl==6) l.setTitolo("The power of "+faker.food().vegetable());
				if (rndTtl==7) l.setTitolo(faker.rockBand().name()+", "+faker.educator().course());
				if (rndTtl==8) l.setTitolo(faker.dog().breed()+": "+faker.shakespeare().kingRichardIIIQuote());
				if (rndTtl==9) l.setTitolo(faker.letterify("A???o n?? p?????e"));
			//Autore casuale
				Integer rndAut=rnd.nextInt(0, 3);
				if (rndAut==0) l.setAutore(faker.name().fullName());
				if (rndAut==1) l.setAutore(faker.funnyName().name());
				if (rndAut==2) l.setAutore(faker.name().nameWithMiddle());
			//Sezione casuale
				Integer rndGnr=rnd.nextInt(0,6);
				if (rndGnr==0) l.setSezione(Genere.fantasy);
				if (rndGnr==1) l.setSezione(Genere.bambini);
				if (rndGnr==2) l.setSezione(Genere.giallo);
				if (rndGnr==3) l.setSezione(Genere.horror);
				if (rndGnr==4) l.setSezione(Genere.rosa);
				if (rndGnr==5) l.setSezione(Genere.saggio);
			//Scaffale casuale
				Integer rndScf=rnd.nextInt(1,11);
				l.setScaffale(rndScf);
				
				l.setStato(StatoLibro.Disponibile);
				
				bib.getListaLibri().put(l.getIdLibro(), l);
		}
		// creazione di 100 associati casuali
		for (int i=0; i<100; i++) {
			Associato as=new Associato();
			as.setIdAssociato("A"+i);
			as.setNominativo(faker.name().firstName()+" "+faker.name().lastName());
			as.setStato(StatoAssociato.Attivo);
			HashMap<String, Libro>aLibri=new HashMap<String, Libro>();
			as.setLibriPresi(aLibri);
			bib.getListaAssociati().put(as.getIdAssociato(), as);
		}
		
		
		
		/* Loop for per il testing iniziale del programma
		 
		for (Libro l:bib.getListaLibri().values()) {
			System.out.println(l);
		}
		
		System.out.println("----------------------------");
		
		for (Associato as:bib.getListaAssociati().values()) {
			System.out.println(as);
		}
		*/		
		System.out.println("-----------------------------");
		Boolean userQuit=false;
		while (userQuit==false) {
			System.out.println("Benvenuto nella parte di ricerca del programma. Inserisci uno dei seguenti comandi:");
			System.out.println("\"CL\" per aggiungere un nuovo libro");
			System.out.println("\"XL\" per rimuovere un libro");
			System.out.println("\"LL\" per visualizzare la lista completa dei libri");
			System.out.println("\"IA\" per iscrivere un nuovo associato");
			System.out.println("\"XA\" per rimuovere un associato dalla lista della biblioteca");
			System.out.println("\"LA\" per visualizzare la lista completa degli associati");
			System.out.println("\"PL\" per segnare la presa di un libro da parte di un associato");
			System.out.println("\"RL\" per segnare la restituzione di un libro da parte di un associato");
			System.out.println("\"SL\" per cerca un libro");
			System.out.println("\"SA\" per cerca un associato");
			System.out.println("\"XX\" per uscire dal programma");
			
			String command=scan.nextLine();
			if (command.equals("CL")) nav.classificareLibro(scan, bib);
			if (command.equals("XL")) nav.rimuovereLibro(scan, bib);
			if (command.equals("LL")) nav.vediListaLibri(scan, bib);
			if (command.equals("IA")) nav.iscriviAssociato(scan, bib);
			if (command.equals("XA")) nav.rimuovereAssociato(scan, bib);
			if (command.equals("LA")) nav.vediListaAssociati(scan, bib);
			if (command.equals("PL")) nav.presaLibro(scan, bib);
			if (command.equals("RL")) nav.restituzioneLibro(scan, bib);
			if (command.equals("SL")) nav.ricercaLibro(scan, bib);
			if (command.equals("SA")) nav.ricercaAssociato(scan, bib);
			if (command.equals("XX")) userQuit=true;
			System.out.println("-----------------");
		}
		System.out.println("arrivederci");
	}

}
