package org.seke.filmania.dao.impl;

import org.seke.filmania.dao.RatingDAO;
import org.seke.filmania.domain.Rating;
import org.springframework.orm.jpa.support.JpaDaoSupport;

public class RatingDaoImpl extends JpaDaoSupport implements RatingDAO {

	public Rating saveRating(Rating rating) {
		if (rating.getRatingId().getId() == null)
			getJpaTemplate().persist(rating);
		else
			getJpaTemplate().merge(rating);
		return rating;
	}

}
