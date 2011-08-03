package org.seke.filmania.dao;

import java.util.List;

import org.seke.filmania.domain.Genre;

/**
 * DAO interface for Genre
 * 
 * @author nenad.seke
 * 
 */
public interface GenreDAO {

	public void create(Genre genre);

	/**
	 * Returns all genres from database.
	 * 
	 * @return
	 */
	public List<Genre> retrieveAll();

	/**
	 * Retrieves genre for given name.
	 * 
	 * @param name
	 * @return
	 */
	public Genre retrieve(String name);

	/**
	 * Updates genre in database.
	 * 
	 * @param genre
	 */
	public void updateGenre(Genre genre);
}
