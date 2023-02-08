package srl.neotech.services;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.dao.FilmDAO;
import srl.neotech.dto.MovieDTO;
import srl.neotech.entity.Movie;

@Service
public class FilmService {

	@Autowired
	FilmDAO filmDao;
	
	ModelMapper mapper = new ModelMapper();

	
	
	public MovieDTO getFilm(Integer film_id) {
		Movie m= filmDao.getMovie(film_id);
	    MovieDTO f=mapper.map(m,MovieDTO.class);
		
		return f;
	}
	
	@Transactional
	public void insertFilm(MovieDTO f) {
		Movie m=mapper.map(f,Movie.class);
		
		filmDao.insertMovie(m);
		
	}
}
