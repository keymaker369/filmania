package org.seke.filmania.service;

import java.util.List;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.seke.filmania.service.GenreService#saveGenre(org.seke.filmania.domain
	 * .Genre)
	 */
	public void saveGenre(Genre genre) {
		getGenreDao().create(genre);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.service.GenreService#getAllGenres()
	 */
	public List<Genre> getAllGenres() {

		return getGenreDao().retrieveAll();
	}

	public GenreDAO getGenreDao() {
		return genreDao;
	}

	public void setGenreDao(GenreDAO genreDao) {
		this.genreDao = genreDao;
	}

}
