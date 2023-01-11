package srl.neotech.services;

import java.time.LocalTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import srl.neotech.dao.MagiaDAO;
import srl.neotech.dao.repository.MagiaRepository;
import srl.neotech.model.ClienteDTO;
import srl.neotech.model.EffettoDTO;
import srl.neotech.model.EffettoMag;
import srl.neotech.model.MagiaDTO;
import srl.neotech.model.Mago;
import srl.neotech.model.NegozioDTO;
import srl.neotech.model.ProblemaDTO;

@Service
public class MagiaService {
	
	@Autowired
	MagiaRepository magiaRepo;
	@Autowired
	MagiaDAO magiaDAO;
	
	Faker faker;
	
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
	
	public void avanzaTempo(Mago mago) {
		LocalTime ora=mago.getNegozio().getOra();
		LocalTime nuovaOra=ora.plusMinutes(30);
		mago.getNegozio().setOra(nuovaOra);
		if (ora.isAfter(LocalTime.parse("20:00"))) {
			System.out.println("sono passate le 20! nuovo giorno");
			this.nuovoGiorno(mago);
		}
	}
	
	public void nuovoGiorno(Mago mago) {
		mago.getNegozio().setGiorno(mago.getNegozio().getGiorno()+1);
		mago.getNegozio().setOra(LocalTime.parse("08:00"));
		mago.getNegozio().getClientiAttuali().add(this.clienteRandom(mago.getNegozio()));
	}
	
	public void loopClienti(Mago mago) {
		Random rnd=new Random();
		if (rnd.nextInt(10)<=(mago.getFama()+1)) {
			mago.getNegozio().getClientiAttuali().add(this.clienteRandom(mago.getNegozio()));
		}
	}
	public ClienteDTO clienteRandom(NegozioDTO negozio) {
		Random rnd=new Random();
		ClienteDTO clRnd=new ClienteDTO();
		clRnd.setNome(faker.funnyName().name());
		clRnd.setOro(rnd.nextInt(1, 3 +1));
		clRnd.setPazienza(rnd.nextInt(3, 4 +1));
		ProblemaDTO prob=new ProblemaDTO();
		prob.setOggetto(faker.animal().name());
		
		clRnd.setProblema(null);
		return null;
	}
	
}
