package org.seke.filmania.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.seke.filmania.dao.MovieDAO;
import org.seke.filmania.domain.Genre;
import org.seke.filmania.domain.Movie;
import org.seke.filmania.model.GenreBean;
import org.seke.filmania.model.MovieBean;
import org.seke.filmania.service.GenreService;
import org.seke.filmania.service.MovieService;

public class MovieServiceImpl implements MovieService {

	private MovieDAO movieDAO;

	private GenreService genreService;

	public void saveMovie(MovieBean movieBean) {
		Movie movie = createMovieFromMovieBean(movieBean);
		saveMovie(movie);
	}

	public void saveMovie(Movie movie) {
		getMovieDAO().create(movie);
	}

	public List<Movie> retriveAllMovies() {
		return getMovieDAO().retriveAllMovies();
	}

	private Movie createMovieFromMovieBean(MovieBean movieBean) {
		Movie movie = new Movie();
		movie.setName(movieBean.getName());
		movie.setInputDate(movieBean.getInputDate());
		movie.setGenres(new LinkedList<Genre>());
		for (GenreBean genreBean : movieBean.getAllGenres()) {
			if (genreBean.isAssigned()) {
				movie.getGenres().add(getGenreService().retrieveGenre(genreBean.getName()));
			}
		}
		return movie;
	}

	public Movie retrieveMovie(long id) {
		return getMovieDAO().retrieve(id);
	}

	public MovieDAO getMovieDAO() {
		return movieDAO;
	}

	public void setMovieDAO(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	public GenreService getGenreService() {
		return genreService;
	}

	public void setGenreService(GenreService genreService) {
		this.genreService = genreService;
	}

}
