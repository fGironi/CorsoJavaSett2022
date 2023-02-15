package srl.neotech.dto;

import java.math.BigDecimal;

public class CollabEvaluationDTO {

	private Integer id;
	private String personName;
	private Integer avgBudget;
	private Integer avgRev; 
	private BigDecimal avgPop;
	private BigDecimal avgVote;
	private Integer movieCount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public Integer getAvgBudget() {
		return avgBudget;
	}
	public void setAvgBudget(Integer avgBudget) {
		this.avgBudget = avgBudget;
	}
	public Integer getAvgRev() {
		return avgRev;
	}
	public void setAvgRev(Integer avgRev) {
		this.avgRev = avgRev;
	}
	public BigDecimal getAvgPop() {
		return avgPop;
	}
	public void setAvgPop(BigDecimal avgPop) {
		this.avgPop = avgPop;
	}
	public BigDecimal getAvgVote() {
		return avgVote;
	}
	public void setAvgVote(BigDecimal avgVote) {
		this.avgVote = avgVote;
	}
	public Integer getMovieCount() {
		return movieCount;
	}
	public void setMovieCount(Integer movieCount) {
		this.movieCount = movieCount;
	}
	public CollabEvaluationDTO(Integer id, String personName, Integer avgBudget, Integer avgRev, BigDecimal avgPop,
			BigDecimal avgVote, Integer movieCount) {
		super();
		this.id = id;
		this.personName = personName;
		this.avgBudget = avgBudget;
		this.avgRev = avgRev;
		this.avgPop = avgPop;
		this.avgVote = avgVote;
		this.movieCount = movieCount;
	}

	
}
