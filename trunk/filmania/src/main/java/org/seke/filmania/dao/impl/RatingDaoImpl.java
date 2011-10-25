package org.seke.filmania.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.seke.filmania.dao.RatingDAO;
import org.seke.filmania.domain.Rating;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;

@Repository(value = "ratingDAO")
public class RatingDaoImpl implements RatingDAO {

	@PersistenceContext
	private EntityManager em;

	public Rating saveRating(Rating rating) {
		if (rating.getRatingId().getId() == null)
			em.persist(rating);
		else
			em.merge(rating);
		return rating;
	}

}
