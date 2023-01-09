package srl.neotech.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import srl.neotech.dao.repository.MagiaRepository;
import srl.neotech.model.EffettoDTO;
import srl.neotech.model.MagiaDTO;
import srl.neotech.model.Mago;
import srl.neotech.model.iconaMag;
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
		
		MagiaDTO caldo =new MagiaDTO();
		caldo.setNome("caldo");
		EffettoDTO e1= new EffettoDTO(3,2,2);
		caldo.setEffetto(e1);
		this.impostaIcone(caldo);
		mb.add(caldo);
		
		MagiaDTO freddo =new MagiaDTO();
		freddo.setNome("freddo");
		EffettoDTO e2= new EffettoDTO(1,2,2);
		freddo.setEffetto(e2);
		freddo.setId(this.idMagia(freddo));
		this.impostaIcone(freddo);
		mb.add(freddo);
		
		MagiaDTO mollo =new MagiaDTO();
		mollo.setNome("mollo");
		EffettoDTO e3= new EffettoDTO(2,1,2);
		mollo.setEffetto(e3);
		mollo.setId(this.idMagia(mollo));
		this.impostaIcone(mollo);
		mb.add(mollo);
		
		MagiaDTO rigido =new MagiaDTO();
		rigido.setNome("rigido");
		EffettoDTO e4= new EffettoDTO(2,3,2);
		rigido.setEffetto(e4);
		rigido.setId(this.idMagia(rigido));
		this.impostaIcone(rigido);
		mb.add(rigido);
		
		MagiaDTO veleno =new MagiaDTO();
		veleno.setNome("veleno");
		EffettoDTO e5= new EffettoDTO(2,2,1);
		veleno.setEffetto(e5);
		veleno.setId(this.idMagia(veleno));
		this.impostaIcone(veleno);
		mb.add(veleno);
		
		MagiaDTO cura =new MagiaDTO();
		cura.setNome("cura");
		EffettoDTO e6= new EffettoDTO(2,2,3);
		cura.setEffetto(e6);
		cura.setId(this.idMagia(cura));
		this.impostaIcone(cura);
		mb.add(cura);
		
		return mb;
	}
	
	public void impostaIcone(MagiaDTO magia) {
		EffettoDTO e=magia.getEffetto();
		
		if (e.getCalore()==0) magia.getIcone().add(iconaMag.GHIACCIO);
		if (e.getCalore()==1) magia.getIcone().add(iconaMag.FREDDO);
		if (e.getCalore()==3) magia.getIcone().add(iconaMag.CALDO);
		if (e.getCalore()==4) magia.getIcone().add(iconaMag.FUOCO);
		
		if (e.getSolidita()==0) magia.getIcone().add(iconaMag.LIQUIDO);
		if (e.getSolidita()==1) magia.getIcone().add(iconaMag.MOLLO);
		if (e.getSolidita()==3) magia.getIcone().add(iconaMag.RIGIDO);
		if (e.getSolidita()==4) magia.getIcone().add(iconaMag.PIETRA);
		
		if (e.getSalute()==0) magia.getIcone().add(iconaMag.TOSSICO);
		if (e.getSalute()==1) magia.getIcone().add(iconaMag.VELENO);
		if (e.getSalute()==3) magia.getIcone().add(iconaMag.CURA);
		if (e.getSalute()==4) magia.getIcone().add(iconaMag.RIGENERA);
	}
	
	public String idMagia(MagiaDTO magia) {
		EffettoDTO e=magia.getEffetto();
		String id="M"+e.getCalore()+""+e.getSolidita()+""+e.getSalute();
		return id;
	}
}
