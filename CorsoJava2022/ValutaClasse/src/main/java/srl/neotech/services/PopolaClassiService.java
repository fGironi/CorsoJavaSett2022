package srl.neotech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.dao.ClasseDAO;
import srl.neotech.model.ClasseDTO;
import srl.neotech.model.StudenteDTO;
import srl.neotech.model.forms.NuovaClasseForm;

@Service
public class PopolaClassiService {

	@Autowired
	ClasseDAO repoClasse;
	
	private Integer contaClassi=0;
	private Integer contaStudenti=0;
	
	public String creaIDclasse(ClasseDTO classe) {
		Character c=classe.getNome().charAt(0);
		String nuovoID="C"+classe.getAnno()+c+contaClassi;
		contaClassi++;
		return nuovoID;
	}
	
	public String creaIDstudente(StudenteDTO stud) {
		Character c=stud.getNominativo().charAt(0);
		String nuovoID="S"+stud.getClasse().getAnno()+c+contaStudenti;
		contaStudenti++;
		return nuovoID;
	}
	
	public void assegnaStudenteClasse(StudenteDTO stud) {
		ClasseDTO classe = stud.getClasse();
		if (repoClasse.getListaClassi().values().contains(classe)) {
			classe.getListaStudenti().add(stud);
		}
		else {
			System.out.println("Errore: la classe inserita non è stata inizializzata");
		}
	}
	
	public void classeFormBinder(NuovaClasseForm classeForm) {
		ClasseDTO classe=classeForm.getClasse();
		classe.setId(this.creaIDclasse(classe));
		for (String s:classeForm.getNomiStudenti()) {
			StudenteDTO stud=new StudenteDTO();
			stud.setClasse(classe);
			stud.setNominativo(s);
			stud.setId(this.creaIDstudente(stud));
			classe.getListaStudenti().add(stud);
		}
		System.out.println("creata una nuova classe"); System.out.println(classe);
		repoClasse.getListaClassi().put(classe.getId(), classe);
		
	}
}
