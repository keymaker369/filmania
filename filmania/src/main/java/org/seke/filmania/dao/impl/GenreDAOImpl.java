/**
 * 
 */
package org.seke.filmania.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.seke.filmania.dao.GenreDAO;
import org.seke.filmania.domain.Genre;
import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * @author nenad.seke
 * 
 */
@SuppressWarnings("unchecked")
public class GenreDAOImpl extends JpaDaoSupport implements GenreDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.dao.GenreDAO#create()
	 */
	public void create(Genre genre) {
		getJpaTemplate().persist(genre);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.dao.GenreDAO#retrieveAll()
	 */

	public List<Genre> retrieveAll() {
		return getJpaTemplate().find("from Genre");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.dao.GenreDAO#retrieve(java.lang.String)
	 */
	public Genre retrieve(String name) {
		EntityManager manager = getJpaTemplate().getEntityManagerFactory().createEntityManager();
		return (Genre) manager.createNamedQuery(Genre.GET_GENRE_BY_NAME).setParameter("name", name).getSingleResult();
	}

	public void updateGenre(Genre genre) {
		getJpaTemplate().merge(genre);
	}

}
