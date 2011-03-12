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
	 * @return
	 */
	public List<Genre> retrieveAll();
}
