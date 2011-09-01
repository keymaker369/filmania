package org.seke.filmania.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.seke.filmania.dao.MovieDAO;
import org.seke.filmania.domain.Movie;
import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * 
 * @author Nenad Seke Mar 26, 2011
 */
@SuppressWarnings("unchecked")
public class MovieDAOImpl extends JpaDaoSupport implements MovieDAO {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.seke.filmania.dao.MovieDAO#create(org.seke.filmania.domain.Movie)
	 */
	public void save(Movie movie) {
		if (movie.getId() == null) {
			getJpaTemplate().persist(movie);
		}else{
			getJpaTemplate().merge(movie);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.dao.MovieDAO#retriveAllMovies()
	 */
	public List<Movie> retriveAllMovies() {
		EntityManager manager = getJpaTemplate().getEntityManagerFactory().createEntityManager();

		return manager.createNamedQuery(Movie.GET_All_MOVIES).getResultList();
	}

	public Movie retrieve(long id) {
		return getJpaTemplate().find(Movie.class, id);
	}

	public List<Movie> retrieveMoviesStartingWith(String movieName) {
		EntityManager manager = getJpaTemplate().getEntityManagerFactory().createEntityManager();
		return manager.createQuery("select m from Movie m where m.name like '" + movieName + "%'").getResultList();
	}

}
