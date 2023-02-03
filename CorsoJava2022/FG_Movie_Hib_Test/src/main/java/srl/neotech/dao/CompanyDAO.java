package srl.neotech.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import srl.neotech.entity.ProductionCompany;

@Component
public class CompanyDAO {
	
	@Autowired
	EntityManager eManager;

	public ProductionCompany getCompany(Integer company_id) {
		return eManager.find(ProductionCompany.class, company_id);
	}

	public void updateCompany(ProductionCompany pc) {
		eManager.merge(pc);
	}
	public void addCompany(ProductionCompany pc) {
		eManager.persist(pc);
	}

}
