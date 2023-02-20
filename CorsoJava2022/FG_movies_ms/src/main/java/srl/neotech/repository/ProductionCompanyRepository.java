package srl.neotech.repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import srl.neotech.entity.ProductionCompany;

public interface ProductionCompanyRepository extends JpaRepository<ProductionCompany, Integer>, JpaSpecificationExecutor<ProductionCompany> {

	
	@Query("select distinct pc from ProductionCompany pc join pc.movies m where m.budget>=:budget")
	List<ProductionCompany> getCompaniesByMinimumBudget(Integer budget, Pageable pageRequest);
}