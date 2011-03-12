/**
 * 
 */
package org.seke.filmania.dao;

import java.util.List;

import org.seke.filmania.domain.Genre;
import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * @author nenad.seke
 * 
 */
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

}
