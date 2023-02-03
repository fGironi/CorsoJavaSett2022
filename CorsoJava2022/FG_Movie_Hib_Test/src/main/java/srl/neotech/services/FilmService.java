package srl.neotech.services;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.dao.FilmDAO;
import srl.neotech.entity.Movie;
import srl.neotech.model.MovieDTO;

@Service
public class FilmService {

	@Autowired
	FilmDAO filmDao;
	
	Mapper mapper=new DozerBeanMapper();
	
	
	
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
