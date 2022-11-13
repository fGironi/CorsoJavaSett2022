package srl.neotech.aeroporto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Aereo {
/*
 * Un Aereo possiede le proprietà: idUnivoco, orario, compagniaAerea, modello,  Passeggeri, velocità (da 1 a 10), 
 * distanzaDallAeroporto(da 1 a 500), stato (IN_PARTENZA,DECOLLATO,FUORI_SPAZIO_AEREO,IN_AVVICINAMENTO,ATTERRATO).
 */
	
	private String idAereo;
	private Integer orario;
	private String compagnia;
	private Modello modello;
	private HashMap<String, Passeggero> listaPasseggeri;
	private Integer velocita;
	private Integer distanza;
	private StatoAereo stato;
	private String destinazione;
	
	
	public String getIdAereo() {
		return idAereo;
	}
	public void setIdAereo(String idAereo) {
		this.idAereo = idAereo;
	}
	public Integer getOrario() {
		return orario;
	}
	public void setOrario(Integer orario) {
		this.orario = orario;
	}
	public String getCompagnia() {
		return compagnia;
	}
	public void setCompagnia(String compagnia) {
		this.compagnia = compagnia;
	}
	public Modello getModello() {
		return modello;
	}
	public void setModello(Modello modello) {
		this.modello = modello;
	}
	public HashMap<String, Passeggero> getListaPasseggeri() {
		return listaPasseggeri;
	}
	public void setListaPasseggeri(HashMap<String, Passeggero> listaPasseggeri) {
		this.listaPasseggeri = listaPasseggeri;
	}
	public Integer getVelocita() {
		return velocita;
	}
	public void setVelocita(Integer velocita) {
		this.velocita = velocita;
	}
	public Integer getDistanza() {
		return distanza;
	}
	public void setDistanza(Integer distanza) {
		this.distanza = distanza;
	}
	public StatoAereo getStato() {
		return stato;
	}
	public void setStato(StatoAereo stato) {
		this.stato = stato;
	}
	public String getDestinazione() {
		return destinazione;
	}
	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}
	
	public void bestToString() {
	SimpleDateFormat sdf = new SimpleDateFormat("HH.mm");
	@SuppressWarnings("deprecation") //lo so che e' deprecato ma funziona, please understand
	Date d= new Date (2022, 9, 27, 6, 0);
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(d);
    calendar.add(Calendar.MINUTE, this.getOrario());
	Date ad=calendar.getTime();
	System.out.println("Aereo [idAereo=" + idAereo + ", orario=" + sdf.format(ad) + ", compagnia=" + compagnia + ", modello=" + modello.getCodiceModello()
			+ ", Passeggeri=" + listaPasseggeri.size() + ", velocita=" + velocita + ", distanza=" + distanza
			+ ", stato=" + stato + ", destinazione=" + destinazione + "]");
	for (Passeggero p:this.listaPasseggeri.values()) {
		System.out.println(p);
	}
	}
}
