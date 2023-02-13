package srl.neotech.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.dao.FilmDao;
import srl.neotech.dto.Film;
import srl.neotech.entity.Movie;

@Service
public class FilmService {

	@Autowired
	FilmDao filmDao;
	
	@Autowired
	ModelMapper mapper;
	
	
	
	public Film getFilm(Integer film_id) {
		Movie m= filmDao.getMovie(film_id);
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Film f=mapper.map(m,Film.class);
		return f;
	}

	public List<Film> getFilmByActor(String name) {
		
		List<Movie> movies=filmDao.getMovieByActor(name);
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<Film> films=new ArrayList<>();
		for(Movie movie:movies) {
			films.add(modelMapper.map(movie, Film.class));
		}
		return films;
	}

	
	@Transactional
	public void insertFilm(Film f) {
		ModelMapper modelMapper = new ModelMapper();
		Movie m=modelMapper.map(f,Movie.class);
		filmDao.insertMovie(m);
		
	}
}
