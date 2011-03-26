package org.seke.filmania.dao.impl;

import org.seke.filmania.dao.MovieDAO;
import org.seke.filmania.domain.Movie;
import org.springframework.orm.jpa.support.JpaDaoSupport;

public class MovieDAOImpl extends JpaDaoSupport implements MovieDAO{

	public void create(Movie movie) {
		getJpaTemplate().persist(movie);
	}

}
