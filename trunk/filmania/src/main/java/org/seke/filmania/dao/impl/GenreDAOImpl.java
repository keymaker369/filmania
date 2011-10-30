/**
 * 
 */
package org.seke.filmania.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.seke.filmania.dao.GenreDAO;
import org.seke.filmania.domain.Genre;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @author nenad.seke
 * 
 */
@SuppressWarnings("unchecked")
@Repository(value = "genreDAO")
public class GenreDAOImpl implements GenreDAO {

	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.dao.GenreDAO#create()
	 */
	public void create(Genre genre) {
		em.persist(genre);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.dao.GenreDAO#retrieveAll()
	 */

	public List<Genre> retrieveAll() {
		return em.createNamedQuery(Genre.GET_ALL_GENRES).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.dao.GenreDAO#retrieve(java.lang.String)
	 */
	public Genre retrieve(String name) {
		return (Genre) em.createNamedQuery(Genre.GET_GENRE_BY_NAME).setParameter("name", name).getSingleResult();
	}

	public void updateGenre(Genre genre) {
		em.merge(genre);
	}

}
