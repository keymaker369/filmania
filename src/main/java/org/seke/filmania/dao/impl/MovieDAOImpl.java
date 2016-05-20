package org.seke.filmania.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.seke.filmania.dao.MovieDAO;
import org.seke.filmania.domain.Movie;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Nenad Seke Mar 26, 2011
 */
@SuppressWarnings("unchecked")
@Repository(value = "movieDAO")
public class MovieDAOImpl implements MovieDAO {
	
	@PersistenceContext
	private EntityManager em;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.seke.filmania.dao.MovieDAO#create(org.seke.filmania.domain.Movie)
	 */
	public void save(Movie movie) {
		if (movie.getId() == null) {
			em.persist(movie);
		}else{
			em.merge(movie);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.dao.MovieDAO#retriveAllMovies()
	 */
	public List<Movie> retriveAllMovies() {

		return em.createNamedQuery(Movie.GET_All_MOVIES).setFirstResult(0).setMaxResults(100).getResultList();
	}

	public Movie retrieve(long id) {
		return em.find(Movie.class, id);
	}

	public List<Movie> retrieveMoviesStartingWith(String movieName) {
		return em.createQuery("SELECT m FROM Movie m WHERE m.name LIKE '" + movieName + "%'").getResultList();
	}

}
