package srl.neotech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.dao.repository.RepositoryAutomobili;

@Service
public class SaloneService {

	@Autowired
	RepositoryAutomobili repoAuto;
	
	private Integer autoCount=0;
	
	public String generaIdAuto() {
		
		String numero;
		if (autoCount<10) numero="00"+autoCount;
		else if (autoCount<100) numero="0"+autoCount;
		else numero=autoCount.toString();
		String idAuto;
		idAuto="V"+numero;
		autoCount++;
		return idAuto;
	}
}
