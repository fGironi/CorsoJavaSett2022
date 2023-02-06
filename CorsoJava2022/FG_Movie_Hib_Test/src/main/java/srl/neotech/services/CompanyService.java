package srl.neotech.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.dao.CompanyDAO;
import srl.neotech.dto.CompanyDTO;
import srl.neotech.dto.MovieDTO;
import srl.neotech.entity.Movie;
import srl.neotech.entity.ProductionCompany;
import srl.neotech.requestresponse.InsertCompanyRequest;

@Service
public class CompanyService {

	@Autowired
	CompanyDAO companyDAO;
	
	Mapper mapper;

	public CompanyDTO getCompany(Integer company_id) {
		mapper=new DozerBeanMapper();
		ProductionCompany pc=companyDAO.getCompany(company_id);
		CompanyDTO company=mapper.map(pc, CompanyDTO.class);
		//navigare l'hashset dell'entity non sembra funzionare e manda l'app in loop. Creare un'arraylist usando l'hashset
		//come costruttore restituisce un'arraylist completa e navigabile. bah.
		ArrayList<Movie> moviesEntity=new ArrayList<Movie>(pc.getMovies());
		ArrayList<MovieDTO> movies=new ArrayList<MovieDTO>();
		System.out.println("film della compagnia:");
		for (Movie m:moviesEntity) {
			MovieDTO mov=mapper.map(m, MovieDTO.class);
			movies.add(mov);
			System.out.println(mov.getTitle());
		}
		company.setMoviesList(movies);
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
