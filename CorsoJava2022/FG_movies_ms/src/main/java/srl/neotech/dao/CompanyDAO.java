package srl.neotech.dao;


import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import srl.neotech.entity.ProductionCompany;
import srl.neotech.repository.ProductionCompanyRepository;

@Component
public class CompanyDAO {

	@Autowired
	EntityManager eManager;
	
	@Autowired
	ProductionCompanyRepository companyRepository;

	public List<ProductionCompany> getCompaniesByMinimumBudget(Integer budget, Integer page) {
		Pageable pageRequest=PageRequest.of(page, 50, Sort.by("companyName"));
		return companyRepository.getCompaniesByMinimumBudget(budget, pageRequest);
	}
	
}
