package srl.neotech.dao.repository;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
public class ListaParoleDAO {

	Faker faker=new Faker();
	
	public ArrayList<String> listaPoke() {
		ArrayList<String> listaParole=new ArrayList<String>();
		listaParole=new ArrayList<String>();
		for (int i=0; i<100; i++) {
			String s=faker.pokemon().name();
			if (listaParole.contains(s)){
				i--;
			}
			else listaParole.add(s);
		}
		return listaParole;
	}
	
	public ArrayList<String> listaZelda() {
		ArrayList<String> listaParole=new ArrayList<String>();
		listaParole=new ArrayList<String>();
		while (listaParole.size()<100) {
			String s=faker.zelda().character();
			if (listaParole.contains(s)==false){
				listaParole.add(s);
			}
		}
		return listaParole;
	}
	public ArrayList<String> listaRock() {
		ArrayList<String> listaParole=new ArrayList<String>();
		while (listaParole.size()<100) {
			String s=faker.rockBand().name();
			if (listaParole.contains(s)==false){
				listaParole.add(s);
			}
		}
		return listaParole;
	}
	
	public ArrayList<String> listaLoL() {
		ArrayList<String> listaParole=new ArrayList<String>();
		while (listaParole.size()<100) {
			String s=faker.leagueOfLegends().champion();
			if (s.equals("Alister")) s="Alistar";
			if (listaParole.contains(s)==false){
				listaParole.add(s);
			}
		}
		return listaParole;
	}
	
	public ArrayList<String> listaCapitali(){
		ArrayList<String> listaParole=new ArrayList<String>();
		ArrayList<String> caps = new ArrayList<>(Arrays.asList(
				"KABUL", "TIRANA", "ALGERI", "LA VELLA", "LUANDA", "SAINT JOHN\'S", "RIAD", "BUENOS AIRES", "EREVAN", "CANBERRA", "VIENNA", "BAKU", "NASSAU",
				"MANAMA", "DACCA", "BRIDGETOWN", "BRUXELLES", "BELMOPAN", "PORTO NOVO", "THIMPHU", "MINSK", "SUCRE", "LA PAZ", "SARAJEVO", "GABORONE", "BRASILIA", "BANDAR SERI BEGAWAN",
				"SOFIA", "OUAGADOUGOU", "GITEGA", "PHNOM PENH", "YAOUNDE", "OTTAWA", "PRAIA", "PRAGA", "BANGUI", "N\'DJAMENA", "SANTIAGO",
				"PECHINO", "NICOSIA", "BOGOTA", "MORONI", "BRAZZAVILLE", "KINSHASA", "PYONGYANG", "SEUL", "YAMOUSSOUKRO", "SAN JOSE", "ZAGABRIA", "L\'AVANA", "COPENAGHEN", "ROSEAU", "SANTO DOMINGO",
				"QUITO", "IL CAIRO", "SAN SALVADOR", "ABU DHABI", "ASMARA", "TALLINN", "ADDIS ABEBA", "SUVA", "MANILA", "HELSINKI", "PARIGI", "LIBREVILLE", "BANJUL", "TBILISI", "BERLINO", "ACCRA",
				"KINGSTON", "TOKYO", "GIBUTI", "AMMAN", "ATENE", "SAINT GEORGE\'S", "CITTA DEL GUATEMALA", "CONAKRY", "BISSAU", "MALABO", "GEORGETOWN", "PORT AU PRINCE", "TEGUCIGALPA",
				"NUOVA DELHI", "GIACARTA", "TEHERAN", "BAGHDAD", "DUBLINO", "REYKJAVIK", "MAJURO", "GERUSALEMME", "ROMA", "NAIROBI", "ASTANA", "BISKEK", "TARAWA SUD", "AL KUWAIT",
				"VIENTIANE", "MASERU", "RIGA", "BEIRUT", "MONROVIA", "TRIPOLI", "VADUZ", "VILNIUS", "LUSSEMBURGO", "SKOPJE", "ANTANANARIVO", "LILONGWE", "KUALA LUMPUR", "MALE", "BAMAKO",
				"LA VALLETTA", "RABAT", "NOUAKCHOTT", "PORT LOUIS", "CITTA DEL MESSICO", "PALIKIR", "CHISINAU", "MONACO", "ULAN BATOR", "PODGORICA", "MAPUTO", "WINDHOEK", "KATMANDU", "MANAGUA",
				"NIAMEY", "ABUJA", "OSLO", "WELLINGTON", "MASCATE", "AMSTERDAM", "ISLAMABAD", "NGERULMUD", "RAMALLAH", "PORT MORESBY", "ASUNCION", "LIMA", "VARSAVIA", "LISBONA", "DOHA", "LONDRA",
				"BUCAREST", "KIGALI", "HONIARA", "APIA", "SAN MARINO", "CASTRIES", "DAKAR", "SAO TOME", "BELGRADO", "VICTORIA", "FREETOWN", "SINGAPORE", "DAMASCO", "BRATISLAVA", "LUBIANA", "MOGADISCIO", "MADRID",
				"SRI JAYAWARDENAPURA", "WASHINGTON", "BLOEMFONTEIN", "CITTA DEL CAPO", "PRETORIA", "KHARTUM", "GIUBA", "PARAMARIBO", "STOCCOLMA", "BERNA", "MBABANE",
				"DUSHANBE", "DODOMA", "BANGKOK", "DILI", "LOME", "NUKU\'ALOFA", "PORT OF SPAIN", "TUNISI", "ANKARA", "ASGABAT", "FUNAFUTI", "KIEV", "KAMPALA",
				"BUDAPEST", "MONTEVIDEO", "TASHKENT", "PORT VILA", "CITTA DEL VATICANO", "CARACAS", "HANOI", "SANA\'A", "LUSAKA", "HARARE"));
		
		listaParole.addAll(caps);
			
		return listaParole;
	}
	
	public ArrayList<String> listaAnimaliEng() {
		ArrayList<String> listaParole=new ArrayList<String>();
		while (listaParole.size()<100) {
			String s=faker.animal().name();
			if (listaParole.contains(s)==false){
				listaParole.add(s);
			}
		}
		return listaParole;
	}
	
}
