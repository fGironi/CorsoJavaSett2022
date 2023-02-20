package srl.neotech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import srl.neotech.dto.ProductionCompanyDTO;
import srl.neotech.requestresponse.ResponseBase;
import srl.neotech.services.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	CompanyService companyService;

	@GetMapping("/getCompaniesByMinimumBudget")
	public ResponseBase getCompaniesByMinimumBudget(@RequestParam Integer budget, Integer page) {
		ResponseBase response=new ResponseBase();
		try {
			List<ProductionCompanyDTO> companies= companyService.getCompaniesByMinimumBudget(budget, page);
			response.setCode("OK");
			response.setData(companies);
			response.setDescr("Returned companies with a movie having budget>"+budget+"$");
			
		} catch (Exception e) {
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		return response;
	}
	
}
