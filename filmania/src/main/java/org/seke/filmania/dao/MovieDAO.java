package org.seke.filmania.dao;

import java.util.List;

import org.seke.filmania.domain.Movie;

/**
 * DAO service for Movie.
 * 
 * @author Nenad Seke
 * 
 */
public interface MovieDAO {

	/**
	 * Persist movie in repository.
	 * 
	 * @param movie
	 */
	public void create(Movie movie);

	/**
	 * Retrieves all movies from repository.
	 * 
	 * @return
	 */
	public List<Movie> retriveAllMovies();

	/**
	 * Retrieve movie from repository.
	 * 
	 * @param id
	 * @return
	 */
	public Movie retrieve(long id);
}
