package org.seke.filmania.service;

import java.util.List;

import org.seke.filmania.domain.Comment;
import org.seke.filmania.domain.Movie;
import org.seke.filmania.domain.User;
import org.seke.filmania.model.MovieBean;
import org.springframework.transaction.annotation.Transactional;

/**
 * Business service for manipulating movies.
 * 
 * @author Nenad Seke
 * 
 */
public interface MovieService {

	@Transactional
	public void saveMovie(MovieBean movieBean);

	@Transactional
	public void saveMovie(Movie movie);

	/**
	 * Retrieves all movies.
	 * 
	 * @param movieBean
	 */
	public List<Movie> retriveAllMovies();

	/**
	 * Retrieves movie for given id.
	 * @param id
	 * @return Movie
	 */
	public Movie retrieveMovie(long id);

	public List<Movie> retrieveMoviesStartingWith(String movieName);
	
	@Transactional
	public void addMovieComment(long movieId,Comment comment,String username);

}
