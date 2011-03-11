package org.seke.filmania.service;

import org.seke.filmania.dao.GenreDAO;
import org.seke.filmania.domain.Genre;

/**
 * Business service for Genre.
 * 
 * @author nenad.seke
 * 
 */
public class GenreServiceImpl implements GenreService {

	private GenreDAO genreDao;

	public void saveGenre(Genre genre) {
		getGenreDao().create(genre);
	}

	public GenreDAO getGenreDao() {
		return genreDao;
	}

	public void setGenreDao(GenreDAO genreDao) {
		this.genreDao = genreDao;
	}

}
