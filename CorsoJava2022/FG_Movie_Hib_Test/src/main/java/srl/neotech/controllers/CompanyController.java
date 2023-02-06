package srl.neotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import srl.neotech.dto.CompanyDTO;
import srl.neotech.requestresponse.InsertCompanyRequest;
import srl.neotech.requestresponse.ResponseBase;
import srl.neotech.services.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	CompanyService companyService;

	@GetMapping(value="getCompany")
	ResponseBase getCompany(@RequestParam Integer company_id) {
		ResponseBase response=new ResponseBase();
		try {
			CompanyDTO company=companyService.getCompany(company_id);
			response.setSimpleData(company);
			response.setCode("OK");
		}catch (Exception e) {
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		return response;
	}
	
	@PostMapping(value="insertCompany")
	ResponseBase insertCompany(@RequestParam Boolean override, @RequestBody InsertCompanyRequest request) {
		ResponseBase response=new ResponseBase();
		try {
			companyService.insertCompany(request, override);
			response.setCode("OK");
		}catch (Exception e) {
			response.setCode("KO");
			response.setDescr(e.getMessage());
		}
		return response;
	}
	
	
}
