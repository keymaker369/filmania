package org.seke.filmania.service.impl;

import java.util.Set;

import org.seke.filmania.dao.MovieDAO;
import org.seke.filmania.dao.RatingDAO;
import org.seke.filmania.dao.RatingService;
import org.seke.filmania.domain.Movie;
import org.seke.filmania.domain.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingDAO ratingDAO;

	@Autowired
	private MovieDAO movieDAO;

	@Transactional
	public Rating saveRating(Rating rating) {
		Movie movie = rating.getMovie();
		int numberOfRatings = movie.getRatings().size();
		double score = calculateScore(movie.getRatings());
		movie.setRank((score + rating.getMark()) / (numberOfRatings + 1));
		movieDAO.save(movie);
		return getRatingDAO().saveRating(rating);
	}

	public RatingDAO getRatingDAO() {
		return ratingDAO;
	}

	public void setRatingDAO(RatingDAO ratingDAO) {
		this.ratingDAO = ratingDAO;
	}


	public MovieDAO getMovieDAO() {
		return movieDAO;
	}

	public void setMovieDAO(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	private double calculateScore(Set<Rating> ratings) {
		double score = 0;
		for (Rating rating : ratings) {
			score += rating.getMark();
		}
		return score;
	}

}
