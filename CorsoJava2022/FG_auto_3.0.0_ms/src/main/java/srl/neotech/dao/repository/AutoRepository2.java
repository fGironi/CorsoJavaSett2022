package srl.neotech.dao.repository;

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
import srl.neotech.requestresponse.SearchAutoRequest;
import srl.neotech.requestresponse.UpdateAutoRequest;


@Repository
public class AutoRepository2 {

	
	@Autowired
    private NamedParameterJdbcTemplate  jdbcTemplate;
	
	@Autowired 
	private PlatformTransactionManager transactionManager;
	
	public Integer getIdCounter(String cAutocAcc){
		//Parametri da passare alla query
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("cName", cAutocAcc);
		//Query
		String query="select counter from IDCOUNTER where nome = :cName";
		Integer idCounter=jdbcTemplate.queryForObject(
				query,
                params,
                (rs, rowNum) -> rs.getInt("counter") 
				);
		return idCounter;
	}
	
	public void increaseIdCounter(String cAutocAcc) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
	    TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
		//Parametri da passare alla query
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("cName", cAutocAcc);
		//Query
		String query="update IDCOUNTER set counter=counter+1 where nome = :cName";
		try {
			jdbcTemplate.update(query,params);
			transactionManager.commit(transactionStatus);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transactionManager.rollback(transactionStatus);
		}
	}
	
	
	public AutoDTO getAuto(String id) {
		//Parametri da passare alla query
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("idAuto", id);
		//Query
		String query="select * from AUTO where id = :idAuto";
		AutoDTO auto=jdbcTemplate.queryForObject(
				query,
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
                		null)
        );
		return auto;
	}
	
	public List<AccessorioDTO> getAccessori(String id) {
		//Parametri da passare alla query
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("idAuto", id);
		//Query
		String query="select * from ACCESSORIO where idAuto = :idAuto";
			
		List<AccessorioDTO> listaAcc=jdbcTemplate.query(
				query,
		        params,
	            (rs, rowNum) ->new AccessorioDTO(rs.getInt("id"), rs.getString("descrizione"), rs.getInt("costo"), TipologiaAcc.valueOf(rs.getString("tipologia")))
				);
		return listaAcc;		
	}
	
	
	public List<AutoDTO> getListaAuto(){
		//Parametri da passsare alla query
		MapSqlParameterSource params=new MapSqlParameterSource();
		//Query
		String query="select * from AUTO";
		
		List<AutoDTO> listaAuto=jdbcTemplate.query(
				query,
                params,
                (rs, rowNum) ->new AutoDTO(rs.getString("id"), rs.getString("targa"), rs.getString("modello"), Colore.valueOf(rs.getString("colore")), Alimentazione.valueOf(rs.getString("alimentazione")), Costruttore.valueOf(rs.getString("costruttore")), rs.getInt("anno"), rs.getInt("costoBase"), rs.getInt("costoTot"))
        );
		return listaAuto;
	}
	
	
	public void addAuto(AutoDTO auto) {
		//configurazione TX
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
	    TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
		
		//Parametri da passsare alla query
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("id", auto.getId());
		params.addValue("targa", auto.getTarga());
		params.addValue("modello", auto.getModello());
		params.addValue("colore", auto.getColore().name());
		params.addValue("alimentazione", auto.getAlimentazione().name());
		params.addValue("costruttore", auto.getCostruttore().name());
		params.addValue("anno", auto.getAnno());
		params.addValue("costoBase", auto.getCostoBase());
		params.addValue("costoTot", auto.getCostoTot());
		//Query
		String query="insert into AUTO(id, targa, modello, colore, alimentazione, costruttore, anno, costoBase, costoTot) VALUES (:id, :targa, :modello, :colore, :alimentazione, :costruttore, :anno, :costoBase, :costoTot)";
		
		try {
			jdbcTemplate.update(query,params);
			transactionManager.commit(transactionStatus);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transactionManager.rollback(transactionStatus);
		}
	}
	
	
	public void addAccessorio(String idAuto, AccessorioDTO acc) {
		//configurazione TX
				TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
			    TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
				
				//Parametri da passsare alla query
				MapSqlParameterSource params=new MapSqlParameterSource();
				params.addValue("idAcc", acc.getId());
				params.addValue("descrizione", acc.getDescrizione());
				params.addValue("costo", acc.getCosto());
				params.addValue("tipologia", acc.getTipologia().name());
				params.addValue("idAuto", idAuto);
				
				String query="insert into ACCESSORIO(id, descrizione, costo, tipologia, idAuto) VALUES (:idAcc, :descrizione, :costo, :tipologia, :idAuto)";

				try {
					jdbcTemplate.update(query,params);
					transactionManager.commit(transactionStatus);
				} catch (DataAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					transactionManager.rollback(transactionStatus);
				}
	}
	
	public void removeAuto(String id) {
		//configurazione TX
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
		   
		//Parametri da passsare alla query
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("id", id);
		 
		//Query
		String query="delete from AUTO where id=:id; delete from ACCESSORIO where idAuto=:id";
		 
		try {
			jdbcTemplate.update(query,params);
			transactionManager.commit(transactionStatus);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transactionManager.rollback(transactionStatus);
		}
	}
	
	public void removeAccessorio(Integer idAcc, String idAuto) {
		//configurazione TX
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
		   
		//Parametri da passsare alla query
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("idAcc", idAcc);
		params.addValue("idAuto", idAuto);
		 
		//Query
		String query="delete from ACCESSORIO where id=:idAcc AND idAuto=:idAuto";
		 
		try {
			jdbcTemplate.update(query,params);
			transactionManager.commit(transactionStatus);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transactionManager.rollback(transactionStatus);
		}
	}
	
	public List<AutoDTO> searchAuto (SearchAutoRequest request) {
		//Parametri da passsare alla query
		MapSqlParameterSource params=new MapSqlParameterSource();
		//Query
		String query="select * from AUTO WHERE ";
		Boolean isANDSearch=false;
		if (request.getId()!=null && request.getId().isEmpty()==false) {
			System.out.println("l'utente ha inserito un id");
			query=query+" id='"+request.getId()+"'";
			isANDSearch=true;
		}
		
		if (request.getTarga()!=null && request.getTarga().isEmpty()==false) {
			System.out.println("l'utente ha inserito una targa");
			if (isANDSearch==true) query=query+"AND ";
			query=query+" targa LIKE'%"+request.getTarga()+"%'";
			isANDSearch=true;
		}
		if (request.getCostruttore()!=null) {
			System.out.println("l'utente ha inserito un costruttore");
			if (isANDSearch==true) query=query+"AND ";
			query=query+" costruttore='"+request.getCostruttore().name()+"'";
			isANDSearch=true;
		}
		if (request.getModello()!=null && request.getModello().isEmpty()==false) {
			System.out.println("l'utente ha inserito un modello");
			if (isANDSearch==true) query=query+"AND ";
			query=query+" modello LIKE'%"+request.getModello()+"%'";
			isANDSearch=true;
		}
		if (request.getAnnoMin()!=null) {
			if (isANDSearch==true) query=query+"AND ";
			query=query+" anno>"+request.getAnnoMin();
			isANDSearch=true;
		}
		if (request.getAnnoMax()!=null) {
			if (isANDSearch==true) query=query+"AND ";
			query=query+" anno<"+request.getAnnoMax();
			isANDSearch=true;
		}
		if (request.getCostoBaseMin()!=null) {
			if (isANDSearch==true) query=query+"AND ";
			query=query+" costoBase>"+request.getCostoBaseMin();
			isANDSearch=true;
		}
		if (request.getCostoBaseMax()!=null) {
			if (isANDSearch==true) query=query+"AND ";
			query=query+" costoBase<"+request.getCostoBaseMin();
			isANDSearch=true;
		}
		if (request.getCostoTotMin()!=null) {
			if (isANDSearch==true) query=query+"AND ";
			query=query+" costoTot>"+request.getCostoTotMin();
			isANDSearch=true;
		}
		if (request.getCostoTotMax()!=null) {
			if (isANDSearch==true) query=query+"AND ";
			query=query+" costoTot<"+request.getCostoTotMax();
			isANDSearch=true;
		}
		if (request.getAlimentazione()!=null) {
			if (isANDSearch==true) query=query+"AND ";
			query=query+" alimentazione='"+request.getAlimentazione().name()+"'";
			isANDSearch=true;
		}
		if (request.getColore()!=null && request.getColore().isEmpty()==false) {
			if (isANDSearch==true) query=query+"AND ";
			query=query+" colore LIKE '%"+request.getColore()+"%'";
			isANDSearch=true;
		}	
			
		List<AutoDTO> listaAuto=jdbcTemplate.query(
				query,
		        params,
		        (rs, rowNum) ->new AutoDTO(rs.getString("id"), rs.getString("targa"), rs.getString("modello"), Colore.valueOf(rs.getString("colore")), Alimentazione.valueOf(rs.getString("alimentazione")), Costruttore.valueOf(rs.getString("costruttore")), rs.getInt("anno"), rs.getInt("costoBase"), rs.getInt("costoTot"))
		);
		return listaAuto;
		
	}
	
	public void updateAuto (UpdateAutoRequest request) {
		//configurazione TX
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
	    TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
	    Boolean isANDUpdate=false;
	  //Parametri da passsare alla query
	  MapSqlParameterSource params=new MapSqlParameterSource();
	  params.addValue("id", request.getId());
	  System.out.println("inizializzata modifica dell'auto "+request.getId());
	  
	  String query="update AUTO SET";
	  
	  if (request.getTarga()!=null && request.getTarga().isBlank()==false) {
		  params.addValue("targa", request.getTarga());
		  System.out.println("modifica della targa a "+request.getTarga());
		  query=query+" targa=:targa";
		  isANDUpdate=true;
	  }
		
	  if (request.getAlimentazione()!=null) {
		  params.addValue("alimentazione", request.getAlimentazione().name());
		  if (isANDUpdate==true) query=query+", ";
		  System.out.println("modifica dell'alimentazione a "+request.getAlimentazione());
		  query=query+" alimentazione=:alimentazione";
		  isANDUpdate=true;
	  }
		
		if (request.getCostruttore()!=null) {
			params.addValue("costruttore", request.getCostruttore().name());
			if (isANDUpdate==true) query=query+", ";
			System.out.println("modifica del costruttore a "+request.getCostruttore());
			query=query+" costruttore=:costruttore";
			isANDUpdate=true;
		}
		
		if (request.getColore()!=null) {
			params.addValue("colore", request.getColore().name());
			if (isANDUpdate==true) query=query+", ";
			System.out.println("modifica del colore a "+request.getColore());
			query=query+" colore=:colore";
			isANDUpdate=true;
		}
		
		
		if (request.getCostoBase()!=null) {
			params.addValue("costoBase", request.getCostoBase());
			if (isANDUpdate==true) query=query+", ";
			System.out.println("modifica del costoBase a "+request.getCostoBase());
			query=query+" costoBase=:costoBase";
			isANDUpdate=true;
		}
		
		if (request.getModello()!=null && request.getModello().isBlank()==false) {
			params.addValue("modello", request.getModello());
			if (isANDUpdate==true) query=query+", ";
			System.out.println("modifica del modello a "+request.getModello());
			query=query+" modello=:modello";
			isANDUpdate=true;
		}
		
		if (request.getAnno()!=null) {
			params.addValue("anno", request.getAnno());
			if (isANDUpdate==true) query=query+", ";
			System.out.println("modifica dell'anno a "+request.getAnno());
			query=query+" anno=:anno";
			isANDUpdate=true;
		}
	  
		  //Query
		  query=query+" where id=:id";
		  
		  try {
			jdbcTemplate.update(query,params);
			transactionManager.commit(transactionStatus);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transactionManager.rollback(transactionStatus);
		}
	}
	
	public void aggiornaCostoTot(String idAuto, Integer nuovoCostoTot) {
		//configurazione TX
			  	TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
			    TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
			  //Parametri da passsare alla query
			  MapSqlParameterSource params=new MapSqlParameterSource();
			  params.addValue("id", idAuto);
			  params.addValue("costoTot", nuovoCostoTot);
			  String query="update AUTO set costoTot=:costoTot where id=:id";
			  try {
					jdbcTemplate.update(query,params);
					transactionManager.commit(transactionStatus);
				} catch (DataAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					transactionManager.rollback(transactionStatus);
				}
	}
	  
	  
	
	
}