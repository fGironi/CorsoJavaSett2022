package srl.neotech.services;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.dao.CompanyDAO;
import srl.neotech.entity.ProductionCompany;
import srl.neotech.model.CompanyDTO;
import srl.neotech.requestresponse.InsertCompanyRequest;

@Service
public class CompanyService {

	@Autowired
	CompanyDAO companyDAO;
	
	Mapper mapper;

	public CompanyDTO getCompany(Integer company_id) {
		mapper=new DozerBeanMapper();
		ProductionCompany pc=companyDAO.getCompany(company_id);
		System.out.println("informazione poco utile: la compagnia ha fatto il film "+ pc.getMovies().iterator().next().getTitle());
		CompanyDTO company=mapper.map(pc, CompanyDTO.class);
		return company;
	}

	@Transactional
	public void insertCompany(InsertCompanyRequest request, Boolean override) {
		mapper=new DozerBeanMapper();
		ProductionCompany pc=mapper.map(request, ProductionCompany.class);
		if (override==true) companyDAO.updateCompany(pc);
		else if (override==false) companyDAO.addCompany(pc);
	}
	
	
}
