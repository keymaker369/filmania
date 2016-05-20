package org.seke.filmania.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.seke.filmania.dao.RatingDAO;
import org.seke.filmania.domain.Rating;
import org.seke.filmania.domain.RatingId;
import org.springframework.stereotype.Repository;

@Repository(value = "ratingDAO")
public class RatingDaoImpl implements RatingDAO {

	@PersistenceContext
	private EntityManager em;

	public Rating saveRating(Rating rating) {
		if (rating.getRatingId() == null || rating.getRatingId().getId() == null){
			RatingId id = new RatingId(null, rating.getUser().getId(), rating.getMovie().getId());
			rating.setRatingId(id);
			em.persist(rating);
		}
		else
			em.merge(rating);
		return rating;
	}

}
