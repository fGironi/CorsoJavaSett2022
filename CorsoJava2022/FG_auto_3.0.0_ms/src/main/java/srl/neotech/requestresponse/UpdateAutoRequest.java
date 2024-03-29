package srl.neotech.requestresponse;

import java.util.ArrayList;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import srl.neotech.model.AccessorioDTO;
import srl.neotech.model.Alimentazione;
import srl.neotech.model.Colore;
import srl.neotech.model.Costruttore;
import srl.neotech.services.EnumNamePattern;

@Valid
public class UpdateAutoRequest {

		@NotNull(message = "l'id dell'auto da aggiornare è un campo obbligatorio")
		private String id;
		@Size(max = 7, min = 5, message = "Targa non valida, la dimensione dovrebbe essre tra i 5 e i 7 caratteri")
		private String targa;
		@Size(min = 2, message = "Nome modello non valido. Il modello dovrebbe essere almeno di 2 caratteri")
		private String modello;
		@EnumNamePattern(regexp="ARANCIONE|ARANCIONEMETAL|ARANCIONEOPACO|BIANCO|BIANCOMETAL|BIANCOOPACO|BLU|BLUMETAL|BLUOPACO|GIALLO|GIALLOMETAL|GIALLOPACO|GRIGIO|GRIGIOMETAL|GRIGIOOPACO|MARRONE|MARRONEMETAL|MARRONEOPACO|NERO|NEROMETAL|NEROOPACO|ROSSO|ROSSOMETAL|ROSSOOPACO|VERDE|VERDEMETAL|VERDEOPACO|VIOLA|VIOLAMETAL|VIOLAOPACO", 
				message="colore non riconosciuto")
		private Colore colore; 
		private Alimentazione alimentazione;
		private Costruttore costruttore;
		//nota: se lavorassi con le date qua si potrebbe usare un ottimo validator @PastOrPresent
		@Range(min = 1970, max = 2023, message = "Anno non valido. L'anno dovrebbe essere compreso tra il 1970 ed il 2023")
		private Integer anno;
		@Min(value = 1000, message = "Costo base non valido, il minimo dovrebbe essere 1000")
		private Integer costoBase;
		private ArrayList<AccessorioDTO> accessoriDaAggiungere;
		private ArrayList<Integer> idAccessoriDaRimuovere;
		
		public String getTarga() {
			return targa;
		}
		public void setTarga(String targa) {
			this.targa = targa;
		}
		public String getModello() {
			return modello;
		}
		public void setModello(String modello) {
			this.modello = modello;
		}
		public Colore getColore() {
			return colore;
		}
		public void setColore(Colore colore) {
			this.colore = colore;
		}
		public Alimentazione getAlimentazione() {
			return alimentazione;
		}
		public void setAlimentazione(Alimentazione alimentazione) {
			this.alimentazione = alimentazione;
		}
		public Costruttore getCostruttore() {
			return costruttore;
		}
		public void setCostruttore(Costruttore costruttore) {
			this.costruttore = costruttore;
		}
		public Integer getAnno() {
			return anno;
		}
		public void setAnno(Integer anno) {
			this.anno = anno;
		}
		public Integer getCostoBase() {
			return costoBase;
		}
		public void setCostoBase(Integer costoBase) {
			this.costoBase = costoBase;
		}
		public ArrayList<AccessorioDTO> getAccessoriDaAggiungere() {
			return accessoriDaAggiungere;
		}
		public void setAccessoriDaAggiungere(ArrayList<AccessorioDTO> accessori) {
			this.accessoriDaAggiungere = accessori;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public ArrayList<Integer> getIdAccessoriDaRimuovere() {
			return idAccessoriDaRimuovere;
		}
		public void setIdAccessoriDaRimuovere(ArrayList<Integer> idAccessoriDaRimuovere) {
			this.idAccessoriDaRimuovere = idAccessoriDaRimuovere;
		}
		
		
		
}
