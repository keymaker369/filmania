package org.seke.filmania.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.seke.filmania.dao.GenreDAO;
import org.seke.filmania.domain.Genre;
import org.seke.filmania.model.GenreBean;
import org.seke.filmania.service.GenreService;
import org.seke.filmania.utils.GenreUtils;
import org.springframework.transaction.annotation.Transactional;

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
	 * @see org.seke.filmania.service.GenreService#saveGenre(org.seke.filmania.domain .Genre)
	 */
	public void saveGenre(Genre genre) {
		genreDao.create(genre);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.service.GenreService#getAllGenres()
	 */
	public List<Genre> getAllGenres() {
		return genreDao.retrieveAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.service.GenreService#getAllGenreBeans()
	 */
	public List<GenreBean> getAllGenreBeans() {
		List<GenreBean> genreBeans = new ArrayList<GenreBean>();
		List<Genre> genres = genreDao.retrieveAll();
		for (Genre genre : genres) {
			genreBeans.add(GenreUtils.createGenreBeanFromGenre(genre));
		}
		return genreBeans;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.service.GenreService#retrieveGenre(java.lang.String)
	 */
	public Genre retrieveGenre(String name) {
		return getGenreDao().retrieve(name);
	}

	/*
	 * (non-Javadoc)
	 * @see org.seke.filmania.service.GenreService#updateGenre(org.seke.filmania.domain.Genre)
	 */
	
	@Transactional
	public void updateGenre(Genre genre) {
		getGenreDao().updateGenre(genre);
	}

	public GenreDAO getGenreDao() {
		return genreDao;
	}

	public void setGenreDao(GenreDAO genreDao) {
		this.genreDao = genreDao;
	}


}
