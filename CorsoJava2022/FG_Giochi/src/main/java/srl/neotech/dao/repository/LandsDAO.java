package srl.neotech.dao.repository;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import srl.neotech.landCount.model.BasicLand;
import srl.neotech.landCount.model.LandDTO;
import srl.neotech.landCount.model.ManaColor;

@Component
public class LandsDAO {

	private HashMap<String, LandDTO> listaTerre;
	
	

	public LandsDAO() {
		HashMap<String, LandDTO> listaTerre=new HashMap<String, LandDTO>();
		for (int i=0; i<4; i++) {
			//TODO Aggiungo quattro volte una copia di ogni terra
		}
		for (int j=0; j<100; j++) {
			
			ManaColor col;
			if (j<20) col=ManaColor.Bianco;
			else if (j<40) col=ManaColor.Blu;
			else if (j<60) col=ManaColor.Nero;
			else if (j<80) col=ManaColor.Rosso;
			else col=ManaColor.Verde;
			LandDTO l=new BasicLand(col);
			String idTerra=l.getNome();
			for (ManaColor mc:l.getManaAdded().keySet()) {
				idTerra=idTerra+mc;
			}
			idTerra=idTerra+j;
			listaTerre.put(idTerra, l);
		}
		
		
		
		this.listaTerre = listaTerre;
	}

	public HashMap<String, LandDTO> getListaTerre() {
		return listaTerre;
	}

	public void setListaTerre(HashMap<String, LandDTO> listaTerre) {
		this.listaTerre = listaTerre;
	}
	
	
}
