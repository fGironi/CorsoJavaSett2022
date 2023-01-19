package srl.neotech.dao.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import srl.neotech.model.AccessorioDTO;
import srl.neotech.model.Alimentazione;
import srl.neotech.model.AutoDTO;
import srl.neotech.model.Colore;
import srl.neotech.model.Costruttore;
import srl.neotech.model.TipologiaAcc;


@Repository
public class AutoRepository2 {

	
	@Autowired
    private NamedParameterJdbcTemplate  jdbcTemplate;
	
	@Autowired 
	private PlatformTransactionManager transactionManager;
	
	
	public AutoDTO getAuto(String id) {
		//Parametri da passsare alla query
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("idAuto", id);
		//Query
		String query="select * from accessorio where idAuto = :idAuto";
		
		List<AccessorioDTO> listaAcc_=jdbcTemplate.query(
				query,
                params,
                (rs, rowNum) ->new AccessorioDTO(rs.getInt("id"), rs.getString("descrizione"), rs.getInt("costo"), TipologiaAcc.valueOf(rs.getString("tipologia")))
				);
		ArrayList<AccessorioDTO> listaAcc=new ArrayList<AccessorioDTO>();
		listaAcc.addAll(listaAcc_);
		
		String query2="select * from auto where id = :idAuto";
		AutoDTO auto=jdbcTemplate.queryForObject(
				query2,
                params,
                (rs, rowNum) ->new AutoDTO(
                		rs.getString("id"), 
                		rs.getString("targa"), 
                		rs.getString("modello"), 
                		Colore.valueOf(rs.getString("colore")), 
                		Alimentazione.valueOf(rs.getString("alimentazione")), 
                		Costruttore.valueOf(rs.getString("costruttore")),  
                		rs.getInt("anno"), 
                		rs.getInt("costoBase"), 
                		rs.getInt("costoTot"), 
                		listaAcc)
        );
		return auto;
	}
	/*
	
	public List<AutoDTO> getListaAuto(){
		//Parametri da passsare alla query
		MapSqlParameterSource params=new MapSqlParameterSource();
		//Query
		String query="select * from auto";
		
		List<AutoDTO> listaAuto=jdbcTemplate.query(
				query,
                params,
                (rs, rowNum) ->new Elemento(rs.getInt("id"), rs.getString("descrizione"))
        );
		return listaAuto;
	}
	
	
	public void addElemento(Elemento elemento) {
		//configurazione TX
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
	    TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
		
		//Parametri da passsare alla query
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("idElemento", elemento.getId());
		params.addValue("descrElemento", elemento.getDescrizione());
				
		//Query
		String query="insert into Elemento(id, descrizione) VALUES (:idElemento, :descrElemento)";
		try {
			jdbcTemplate.update(query,params);
			transactionManager.commit(transactionStatus);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transactionManager.rollback(transactionStatus);
		}
	}
	
	
	public void updateElemento (AutoDTO auto) {
		//configurazione TX
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
	    TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
	    
	  //Parametri da passsare alla query
	  MapSqlParameterSource params=new MapSqlParameterSource();
	  params.addValue("idElemento", auto.getId());
	  params.addValue("descrElemento", auto.getCostoBase());
	  
	  //Query
	  String query="update Elemento set descrizione=:descElemento where id=:idElemento";
	  
	  try {
		jdbcTemplate.update(query,params);
		transactionManager.commit(transactionStatus);
	} catch (DataAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		transactionManager.rollback(transactionStatus);
	}
	}
	
	public void deleteElemento(Integer idelemento) {
		//configurazione TX
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
	    TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
	    
	  //Parametri da passsare alla query
	  MapSqlParameterSource params=new MapSqlParameterSource();
	  params.addValue("idElemento", idelemento);
	 
	  //Query
	  String query="delete Elemento where id=:idElemento";
	 
	  try {
		jdbcTemplate.update(query,params);
		transactionManager.commit(transactionStatus);
	} catch (DataAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		transactionManager.rollback(transactionStatus);
	}
	  
	  
	}
	*/
}