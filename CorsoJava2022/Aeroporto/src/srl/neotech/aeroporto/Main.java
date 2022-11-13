package srl.neotech.aeroporto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import com.github.javafaker.Faker;

public class Main {

	public static void main(String[] args) {
		Aeroporto aero=new Aeroporto();
		Random rnd=new Random();
		Faker faker=new Faker();
		Scanner input=new Scanner(System.in);
		//prerandomizzazione delle destinazioni
		String d1=faker.country().capital(); 
		String d2=faker.country().capital(); 
		String d3=faker.country().capital();
		//preRandomizzazione dell'orario di arrivo/partenza
		ArrayList<Integer> tempiArrivi=new ArrayList<Integer>();
		ArrayList<Integer> tempiPartenze=new ArrayList<Integer>();
		for (int t=1; t<203; t++) {tempiArrivi.add(t+1); tempiPartenze.add(t);}
		Collections.shuffle(tempiArrivi);
		Collections.shuffle(tempiPartenze);
		
		//Creazione di 10000 passeggeri random pronti al check-in
		for (int i=0; i<10000; i++) {
			Passeggero p=new Passeggero();
			//imposto l'id del passeggero
			p.setIdPasseggero("P"+i);
			//randomizzazione della classe del passeggero
			Integer rndclv=rnd.nextInt(3);
			if (rndclv==0) p.setClasse(ClasseViaggiatore.Business);
			else if (rndclv==1) p.setClasse(ClasseViaggiatore.Excelsior);
			else if (rndclv==2) p.setClasse(ClasseViaggiatore.Turista);
			//randomizzazione del genere del passeggero
			Integer rndMF=rnd.nextInt(2);
			if (rndMF==0) p.setMf("M");
			else if (rndMF==1) p.setMf("F");
			//randomizzazione del nome del passeggero
			p.setNominativo(faker.name().fullName());
			//randomizzazione dell'eta del passeggero (18-65)
			p.setEta(rnd.nextInt(18,66));
			//randomizzazione del possesso dei bagagli
			Integer rndbgl=rnd.nextInt(5);
			if (rndbgl<2) p.setHaBagagli(false);
			else p.setHaBagagli(true);
			//randomizzazione della destinazione
			Integer rnddst=rnd.nextInt(3);
			if (rnddst==0) p.setDestinazione(d1);
			if (rnddst==1) p.setDestinazione(d2);
			if (rnddst==2) p.setDestinazione(d3);
			
			
			aero.getListaPasseggeri().put(p.getIdPasseggero(), p);			
		}
		
		
		//creazione di 300 aerei random, di cui 200 in arrivo e 100 in partenza
		for (int i=0; i<300; i++) {
			Aereo a;
			
			//randomizzazione del modello
			Integer rndmdl=rnd.nextInt(6);
			if (rndmdl== 0)	a=new Modello("Airbus A320", 170);
			else if (rndmdl== 1)	 a=new Modello("Boeing 777", 120);
			else if (rndmdl== 2)	 a=new Modello("Boeing 737", 70);
			else if (rndmdl== 3)	 a=new Modello("Airbus A220", 50);
			else if (rndmdl== 4)	 a=new Modello("Boeing 717", 60);
			else 					 a=new Modello("Airbus A330", 150);
			
			// Impostazione dell'id univoco dell'aereo
			a.setIdAereo("A"+i);
		
			//Randomizzazione della compagnia aerea
			Integer rndcmp=rnd.nextInt(6);
			
			if (rndcmp==0) a.setCompagnia("Ryanair");
			if (rndcmp==1) a.setCompagnia("EasyJet");
			if (rndcmp==2) a.setCompagnia("AirFrance");
			if (rndcmp==3) a.setCompagnia("Lufthansa");
			if (rndcmp==4) a.setCompagnia("International Airlines Group");
			else		   a.setCompagnia("ITA Airways");
			
			
				
			
			if (i<100) {
				//imposto l'orario dei voli in partenza
				Integer rndtime=(tempiPartenze.get(0))*5;
				tempiPartenze.remove(0);
				a.setOrario(rndtime);
				
				//imposto la distanza e la velocita a 0
				a.setDistanza(0);
				a.setVelocita(0);
				
				//imposto lo stato
				a.setStato(StatoAereo.IN_PARTENZA);
				
				//randomizzazione della destinazione
				Integer rnddst=rnd.nextInt(3);
				if (rnddst==0) a.setDestinazione(d1);
				if (rnddst==1) a.setDestinazione(d2);
				if (rnddst==2) a.setDestinazione(d3);
				
				
				aero.getAereiInPartenza().put(a.getIdAereo(), a);
			}
			else if (i>=100) {
				//imposto l'orario dei voli in arrivo
				Integer rndtime=(tempiArrivi.get(0))*5;
				tempiArrivi.remove(0);
				a.setOrario(rndtime);
				
				a.setDestinazione("Aereoporto BLL");
				
				//Imposto la distanza e lo stato
				if (rndtime>90) {a.setDistanza((2*(rndtime-90))+90); a.setVelocita(10);	}
				else if (rndtime==90) {	a.setDistanza(90); a.setVelocita(9); 	}
				else if (rndtime==85) {	a.setDistanza(81); a.setVelocita(9);	}
				else if (rndtime==80) {	a.setDistanza(72); a.setVelocita(8);	}
				else if (rndtime==75) {	a.setDistanza(64); a.setVelocita(8);	}
				else if (rndtime==70) { a.setDistanza(56); a.setVelocita(7);	}
				else if (rndtime==65) {	a.setDistanza(49); a.setVelocita(7);	}
				else if (rndtime==60) { a.setDistanza(42); a.setVelocita(6);	}
				else if (rndtime==55) { a.setDistanza(36); a.setVelocita(6);	}
				else if (rndtime==50) { a.setDistanza(30); a.setVelocita(5);	}
				else if (rndtime==45) { a.setDistanza(25); a.setVelocita(5);	}
				else if (rndtime==40) { a.setDistanza(20); a.setVelocita(4);	}
				else if (rndtime==35) { a.setDistanza(16); a.setVelocita(4);	}
				else if (rndtime==30) { a.setDistanza(12); a.setVelocita(3);	}
				else if (rndtime==25) { a.setDistanza(9); a.setVelocita(3);		}
				else if (rndtime==20) { a.setDistanza(6); a.setVelocita(2);		}
				else if (rndtime==15) { a.setDistanza(4); a.setVelocita(2);		}
				else if (rndtime==10) { a.setDistanza(2); a.setVelocita(1);		}
				else if (rndtime==5) { a.setDistanza(1); a.setVelocita(1);		}
				
				if (a.getDistanza()>100) { a.setStato(StatoAereo.FUORI_SPAZIO_AEREO);}
				else {a.setStato(StatoAereo.IN_AVVICINAMENTO);}
				
				
				//popolo i passeggeri degli aerei in arrivo
				Integer passArr=rnd.nextInt(1,20);
				for (int j=0; j<passArr; j++) {
					Passeggero p=new Passeggero();
					p.setIdPasseggero(a.getIdAereo()+"-P"+j);
					//randomizzazione della classe del passeggero
					Integer rndclv=rnd.nextInt(3);
					if (rndclv==0) p.setClasse(ClasseViaggiatore.Business);
					else if (rndclv==1) p.setClasse(ClasseViaggiatore.Excelsior);
					else if (rndclv==2) p.setClasse(ClasseViaggiatore.Turista);
					//randomizzazione del genere del passeggero
					Integer rndMF=rnd.nextInt(2);
					if (rndMF==0) p.setMf("M");
					else if (rndMF==1) p.setMf("F");
					//randomizzazione del nome del passeggero
					p.setNominativo(faker.name().fullName());
					//randomizzazione dell'eta del passeggero (18-65)
					p.setEta(rnd.nextInt(18,66));
					//randomizzazione del possesso dei bagagli
					Integer rndbgl=rnd.nextInt(5);
					if (rndbgl<2) p.setHaBagagli(false);
					else p.setHaBagagli(true);
					a.getListaPasseggeri().put(p.getIdPasseggero(), p);	
				}
				aero.getAereiInArrivo().put(a.getIdAereo(), a);
			}
					
		}
		
		//Esecuzione effettiva del programma
		Integer tempo=0;
		SimpleDateFormat sdf = new SimpleDateFormat("HH.mm");
		@SuppressWarnings("deprecation") //lo so che e' deprecato ma funziona, please understand
		Date d= new Date (2022, 9, 27, 6, 0);
		Calendar calendar = Calendar.getInstance();
		ArrayList<String> idAereiUsciti=new ArrayList<String>();
		
		System.out.println("Programma gestione areoporto. premere invio o scrivere una qualsiasi cosa per procedere allo stacco di tempo successivo.");
		System.out.println("Se si inserisce l'id di un aereo si potranno vedere le relative informazioni");
		input.nextLine();
		while (tempo<=1020) {
			calendar.setTime(d);
		    calendar.add(Calendar.MINUTE, tempo);
			Date nd=calendar.getTime();
			System.out.println("alle ore "+sdf.format(nd));
			//Ciclo degli aerei in partenza
			for (Aereo a:aero.getAereiInPartenza().values()) {
				//movimento aerei:
				a.setDistanza(a.getDistanza()+a.getVelocita());
				//partenza aereo
				calendar.setTime(d);
			    calendar.add(Calendar.MINUTE, a.getOrario());
				Date ad=calendar.getTime();
				if (a.getOrario().equals(tempo+5)) {
					System.out.println("Aereo "+a.getIdAereo()+" ["+a.getModello().getCodiceModello()+" "
							+ ""+a.getModello().getCompagnia()+"] delle "+sdf.format(ad)+" per "+a.getDestinazione()+" e' in partenza");
					//prendo i passeggeri dell'aereo (sperimentalissimo)
					for (Passeggero p: aero.getListaPasseggeri().values()) {
						if (p.getDestinazione().equals(a.getDestinazione())) {
							aero.checkin(p);
							a.getListaPasseggeri().put(p.getIdPasseggero(), p);
							if (a.getListaPasseggeri().size()>(a.getModello().getCapienzaNumPasseggeri())/2) {
								if (rnd.nextInt(2)==0) break;
							}
							if (a.getListaPasseggeri().size()==a.getModello().getCapienzaNumPasseggeri()) break;	
							
						}
					}
					for (String s:a.getListaPasseggeri().keySet()) {
						aero.getListaPasseggeri().remove(s);
					}
					
				}
				//Faccio decollare l'aereo
				if (a.getOrario().equals(tempo)) {
					aero.decollo(a);
				}
				//Accelerazione aereo
				if (a.getDistanza()==90) a.setVelocita(10);
				if (a.getDistanza()==72) a.setVelocita(9);
				if (a.getDistanza()==56) a.setVelocita(8);
				if (a.getDistanza()==42) a.setVelocita(7);
				if (a.getDistanza()==30) a.setVelocita(6);
				if (a.getDistanza()==20) a.setVelocita(5);
				if (a.getDistanza()==12) a.setVelocita(4);
				if (a.getDistanza()==6) a.setVelocita(3);
				if (a.getDistanza()==2)  a.setVelocita(2); 
				if (a.getDistanza()>0) System.out.println("Aereo "+a.getIdAereo()+" in allontanamento. distanza:"+a.getDistanza()+" velocita:"+a.getVelocita());
				if (a.getDistanza()>100) {
					idAereiUsciti.add(a.getIdAereo());
					System.out.println("Aereo "+a.getIdAereo()+" uscito dalla zona di competenza");
				}
			
			}
			
			
			
			
			
			//Ciclo degli aerei in arrivo
			for (Aereo a:aero.getAereiInArrivo().values()) {
				a.setDistanza(a.getDistanza()-a.getVelocita());
				if (a.getDistanza()==aero.getRaggioDiAzione()) System.out.println("Aereo "+a.getIdAereo()+" entrato nel raggio d'azione");
				if (a.getDistanza()<aero.getRaggioDiAzione()&&a.getDistanza()>0) {
					a.setStato(StatoAereo.IN_AVVICINAMENTO);
					//decelerazione aereo
					if (a.getDistanza()==90) a.setVelocita(9);
					if (a.getDistanza()==72) a.setVelocita(8);
					if (a.getDistanza()==56) a.setVelocita(7);
					if (a.getDistanza()==42) a.setVelocita(6);
					if (a.getDistanza()==30) a.setVelocita(5);
					if (a.getDistanza()==20) a.setVelocita(4);
					if (a.getDistanza()==12) a.setVelocita(3);
					if (a.getDistanza()==6) a.setVelocita(2);
					if (a.getDistanza()==2) a.setVelocita(1);
					System.out.println("Aereo "+a.getIdAereo()+" in avvicinamento. Distanza: "+a.getDistanza()+". Velocita: "+a.getVelocita());
	
				}
				if (a.getDistanza()==0) { aero.atterraggio(a);
					idAereiUsciti.add(a.getIdAereo());
				}
			}
			
		
			
			String userIn=input.nextLine();
			if (aero.getAereiInArrivo().containsKey(userIn)) {
				Aereo arA=(aero.getAereiInArrivo().get(userIn));
				System.out.println("Aereo in arrivo:");
				arA.bestToString();
				input.nextLine();
			}
			if (aero.getAereiInPartenza().containsKey(userIn)) {
				Aereo arP=(aero.getAereiInPartenza().get(userIn));
				System.out.println("Aereo in partenza:");
				arP.bestToString();
				input.nextLine();
			}
			
			//rimozione degli aerei
			for (String s:idAereiUsciti) {
				if (aero.getAereiInPartenza().containsKey(s)) 	aero.getAereiInPartenza().remove(s); 
				if (aero.getAereiInArrivo().containsKey(s)) 	aero.getAereiInArrivo().remove(s);
			}
		
			tempo=tempo+5;
			System.out.println("----------------------------");
			
		}
		System.out.println("si chiude");
		input.close();

	}

}
