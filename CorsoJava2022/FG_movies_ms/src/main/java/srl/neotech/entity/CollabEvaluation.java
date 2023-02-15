package srl.neotech.entity;

import java.math.BigDecimal;

public interface CollabEvaluation {

	Integer getId();
	String getPersonName();
	Integer getAvgBudget();
	Integer getAvgRev(); 
	BigDecimal getAvgPop();
	BigDecimal getAvgVote();
	Integer getMovieCount();
}
