package srl.neotech.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import srl.neotech.dao.repository.MagiaRepository;
import srl.neotech.model.EffettoDTO;
import srl.neotech.model.Mago;

@Component
public class MagiaDAO {

	@Autowired
	MagiaRepository magiaRepo;	
	
	private Integer contaUtenti=0;
	
	
	public MagiaDAO() {
		magiaRepo.setListaEffetti(this.listaEffetti());
	}

	public ArrayList<EffettoDTO> listaEffetti() {
		ArrayList<EffettoDTO> listaEffetti=new ArrayList<EffettoDTO>();
		for (int i=-2; i<3; i++) {
			EffettoDTO e=new EffettoDTO();
			e.setCalore(i);
			for (int j=-2; j<3; j++) {
				e.setSalute(j);
				for (int k=-2; k<3; k++) {
					e.setSolidita(k);
				}
			}
		if ((e.getCalore()==1 && e.getSalute()==0 && e.getSolidita()==0)||(e.getCalore()==0 && e.getSalute()==1 && e.getSolidita()==0)|| (e.getCalore()==0 && e.getSalute()==0 && e.getSolidita()==1)) {
			System.out.println("effetto di base non aggiunto alla lista");
		}
		else if ((e.getCalore()==-1 && e.getSalute()==0 && e.getSolidita()==0)||(e.getCalore()==0 && e.getSalute()==-1 && e.getSolidita()==0)|| (e.getCalore()==0 && e.getSalute()==0 && e.getSolidita()==-1)) {
			System.out.println("effetto di base non aggiunto alla lista");
		}
		else listaEffetti.add(e);
		}
		
		return listaEffetti;
	}
	
	public Mago nuovoUtente(Mago mago){
		Character lettera=mago.getNome().charAt(0);
		String nuovoID="Mago"+lettera+this.contaUtenti;
		mago.setId(nuovoID.toUpperCase());
				
		return mago;
	}

	public Integer getContaUtenti() {
		return contaUtenti;
	}

	public void setContaUtenti(Integer contaUtenti) {
		this.contaUtenti = contaUtenti;
	}
}
