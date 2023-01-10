package srl.neotech.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.dao.MagiaDAO;
import srl.neotech.dao.repository.MagiaRepository;
import srl.neotech.model.EffettoDTO;
import srl.neotech.model.EffettoMag;
import srl.neotech.model.MagiaDTO;
import srl.neotech.model.Mago;

@Service
public class MagiaService {
	
	@Autowired
	MagiaRepository magiaRepo;
	@Autowired
	MagiaDAO magiaDAO;
	
	public void imparaNuovaMagia(Mago mago) {
		MagiaDTO m=new MagiaDTO();
		Random rnd=new Random();
		Integer rndSpell=rnd.nextInt(mago.getNegozio().getEffettiPossibili().size());
		EffettoDTO e=mago.getNegozio().getEffettiPossibili().get(rndSpell);
		System.out.println("effetto scelto:" +e);
		m.setEffetto(e);
		magiaDAO.impostaIcone(m);
		String nuovoNome="";
		for (EffettoMag eff:m.getEffetti()) {
			nuovoNome=nuovoNome+eff;
		}
		m.setNome(nuovoNome);
		m.setId(magiaDAO.idMagia(m));
		mago.getListaMagie().add(m);
		mago.getNegozio().getEffettiPossibili().remove(e);
		System.out.println("imparata una nuova magia: "+e.getCalore()+""+e.getSolidita()+""+e.getSalute()+", effetti restanti: "+mago.getNegozio().getEffettiPossibili().size());
		
	}
	
}
