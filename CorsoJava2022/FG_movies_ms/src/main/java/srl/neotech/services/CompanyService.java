package srl.neotech.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.dao.CompanyDAO;
import srl.neotech.dto.ProductionCompanyDTO;
import srl.neotech.entity.ProductionCompany;

@Service
public class CompanyService {
	
	@Autowired
	CompanyDAO companyDAO;
	
	@Autowired
	ModelMapper mapper;
	

	public List<ProductionCompanyDTO> getCompaniesByMinimumBudget(Integer budget, Integer page) {
		List<ProductionCompany> companiesEntity=companyDAO.getCompaniesByMinimumBudget(budget, page);
		ArrayList<ProductionCompanyDTO> companies=new ArrayList<ProductionCompanyDTO>();
		for (ProductionCompany pc:companiesEntity) {
			ProductionCompanyDTO company=mapper.map(pc, ProductionCompanyDTO.class);
			companies.add(company);
		}
		return companies;
	}

}
