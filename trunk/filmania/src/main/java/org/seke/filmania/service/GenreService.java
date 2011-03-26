package org.seke.filmania.service;

import java.util.List;

import org.seke.filmania.domain.Genre;
import org.seke.filmania.model.GenreBean;
import org.springframework.transaction.annotation.Transactional;

/**
 * Business service for Genre.
 * 
 * @author Nenad Seke
 * 
 */
public interface GenreService {

	/**
	 * Creates new genre.
	 * 
	 * @param genre
	 */
	@Transactional
	public void saveGenre(Genre genre);

	/**
	 * Retrieves all Genres.
	 * 
	 * @return
	 */
	public List<Genre> getAllGenres();

	/**
	 * Retrieves all GenreBeans.
	 * 
	 * @return
	 */
	public List<GenreBean> getAllGenreBeans();

	/**
	 * Retrieves genre for given name.
	 * @param name
	 * @return
	 */
	public Genre retrieveGenre(String name);

}
