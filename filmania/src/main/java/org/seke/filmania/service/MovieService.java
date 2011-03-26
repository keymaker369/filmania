package org.seke.filmania.service;

import org.seke.filmania.domain.Movie;
import org.seke.filmania.model.MovieBean;
import org.springframework.transaction.annotation.Transactional;

/**
 * Business service for manipulating movies.
 * @author Nenad Seke
 *
 */
public interface MovieService {

	@Transactional
	public void saveMovie(MovieBean movieBean);
	
	@Transactional
	public void saveMovie(Movie movie);
	
}
