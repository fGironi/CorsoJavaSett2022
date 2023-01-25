package srl.neotech.dao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import srl.neotech.model.ComuneAutoDTO;
import srl.neotech.model.ComuneDTO;
import srl.neotech.model.GeoLocalizzazioneDTO;
import srl.neotech.model.ProvinciaDTO;
import srl.neotech.model.RegioneDTO;

@Repository
public class GeoRepository {
	
	@Autowired
    private NamedParameterJdbcTemplate  jdbcTemplate;
	

	public List<RegioneDTO> getListaRegioni() {
		//Parametri da passsare alla query
		MapSqlParameterSource params=new MapSqlParameterSource();
		//Query
		String query="select * from regione";
			
		List<RegioneDTO> listaRegioni=jdbcTemplate.query(
				query,
		        params,
		        (rs, rowNum) ->new RegioneDTO(rs.getInt("id_regione"), rs.getString("regione"))
		        );
		return listaRegioni;
	}

	public List<ProvinciaDTO> getListaProvince(Integer idReg) {
		//Parametri da passsare alla query
				MapSqlParameterSource params=new MapSqlParameterSource();
				params.addValue("id_regione", idReg);
				//Query
				String query="select * from provincia where id_regione=:id_regione";
					
				List<ProvinciaDTO> listaProvince=jdbcTemplate.query(
						query,
				        params,
				        (rs, rowNum) ->new ProvinciaDTO(rs.getString("sigla"), rs.getString("provincia"))
				        );
				return listaProvince;
	}

	public List<ComuneDTO> getListaComuni(String siglaProv) {
		//Parametri da passsare alla query
				MapSqlParameterSource params=new MapSqlParameterSource();
				params.addValue("sigla", siglaProv);
				//Query
				String query="select * from citta where provincia=:sigla";
					
				List<ComuneDTO> listaComuni=jdbcTemplate.query(
						query,
				        params,
				        (rs, rowNum) ->new ComuneDTO(rs.getString("istat"), rs.getString("comune"), rs.getString("provincia"))
				        );
				return listaComuni;
	}

	public List<ComuneAutoDTO> getListaComuniAuto(String input) {
		//Parametri da passsare alla query
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("input", input+"%");
		//Query
		String query="select comune, istat from citta where comune LIKE :input";
			
		List<ComuneAutoDTO> listaComuni=jdbcTemplate.query(
				query,
		        params,
		        (rs, rowNum) -> new ComuneAutoDTO(rs.getString("comune"), rs.getString("comune"), rs.getString("istat"))
		        );
		return listaComuni;
	}

	public GeoLocalizzazioneDTO getGeoLocal(String istat) {
		//Parametri da passsare alla query
				MapSqlParameterSource params=new MapSqlParameterSource();
				params.addValue("istat", istat);
				//Query
				String query="select * from geoloc where istat=:istat";
					
				GeoLocalizzazioneDTO geo=jdbcTemplate.queryForObject(
						query, 
						params,  
						(rs, rowNum) -> new GeoLocalizzazioneDTO(rs.getString("lng"), rs.getString("lat"))
					);
				return geo;
	}

	public String getIstat(String comune) {
		// TODO Auto-generated method stub
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("comune", comune);
		//Query
		String query="select istat from citta where comune=:comune";
			
		String istat=jdbcTemplate.queryForObject(
				query, 
				params,  
				(rs, rowNum) -> rs.getString("istat")
			);
		return istat;
	}
}
