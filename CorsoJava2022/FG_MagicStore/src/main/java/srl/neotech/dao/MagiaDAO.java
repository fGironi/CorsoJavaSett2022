package srl.neotech.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import srl.neotech.dao.repository.MagiaRepository;
import srl.neotech.model.EffettoDTO;
import srl.neotech.model.EffettoMag;
import srl.neotech.model.MagiaDTO;
import srl.neotech.model.Mago;
import srl.neotech.model.NegozioDTO;
import srl.neotech.model.TipologiaEff;
import srl.neotech.requestresponse.MagoRequest;

@Component
public class MagiaDAO {

	@Autowired
	MagiaRepository magiaRepo;	
	
	private Integer contaUtenti=0;
	
	
	public Mago nuovoUtente(MagoRequest magoReq){
		Mago mago=new Mago();
		mago.setNome(magoReq.getNome());
		mago.setAvatarURL(magoReq.getAvatarURL());
		mago.setFama(0);
		mago.setOro(0);
		mago.setStress(0);
		mago.setListaMagie(this.magieBase());
		Character lettera=mago.getNome().charAt(0);
		String nuovoID="Mago"+lettera+this.contaUtenti;
		mago.setId(nuovoID.toUpperCase());
		magiaRepo.getListaUtenti().put(nuovoID, mago);
		mago.setNegozio(new NegozioDTO());
		mago.getNegozio().getEffettiPossibili().addAll(magiaRepo.getListaEffetti());
		mago.getNegozio().setGiorno(0);
		System.out.println("creato nuovo mago:");
		System.out.println(mago);
		return mago;
	}

	public Integer getContaUtenti() {
		return contaUtenti;
	}

	public void setContaUtenti(Integer contaUtenti) {
		this.contaUtenti = contaUtenti;
	}
	
	public ArrayList<MagiaDTO> magieBase(){
		ArrayList<MagiaDTO> mb=new ArrayList<MagiaDTO>();
		
		MagiaDTO caldo =new MagiaDTO(EffettoMag.CALDO, null, null);
		caldo.setNome("Caldo");
		mb.add(caldo);
		
		MagiaDTO freddo =new MagiaDTO();
		freddo.setNome("Freddo");
		EffettoDTO e2= new EffettoDTO(1,2,2);
		freddo.setEffetto(e2);
		freddo.setId(this.idMagia(freddo));
		this.impostaIcone(freddo);
		mb.add(freddo);
		
		MagiaDTO mollo =new MagiaDTO();
		mollo.setNome("Mollo");
		EffettoDTO e3= new EffettoDTO(2,1,2);
		mollo.setEffetto(e3);
		mollo.setId(this.idMagia(mollo));
		this.impostaIcone(mollo);
		mb.add(mollo);
		
		MagiaDTO rigido =new MagiaDTO();
		rigido.setNome("Rigido");
		EffettoDTO e4= new EffettoDTO(2,3,2);
		rigido.setEffetto(e4);
		rigido.setId(this.idMagia(rigido));
		this.impostaIcone(rigido);
		mb.add(rigido);
		
		MagiaDTO veleno =new MagiaDTO();
		veleno.setNome("Veleno");
		EffettoDTO e5= new EffettoDTO(2,2,1);
		veleno.setEffetto(e5);
		veleno.setId(this.idMagia(veleno));
		this.impostaIcone(veleno);
		mb.add(veleno);
		
		MagiaDTO cura =new MagiaDTO();
		cura.setNome("Cura");
		EffettoDTO e6= new EffettoDTO(2,2,3);
		cura.setEffetto(e6);
		cura.setId(this.idMagia(cura));
		this.impostaIcone(cura);
		mb.add(cura);
		
		return mb;
	}
	
	
	public String idMagia(MagiaDTO magia) {
		EffettoDTO e=magia.getEffetto();
		String id="M"+e.getCalore()+""+e.getSolidita()+""+e.getSalute();
		return id;
	}
}
