package org.seke.filmania.service.impl;

import java.util.Set;

import org.seke.filmania.dao.MovieDAO;
import org.seke.filmania.dao.RatingDAO;
import org.seke.filmania.dao.RatingService;
import org.seke.filmania.domain.Movie;
import org.seke.filmania.domain.Rating;
import org.springframework.transaction.annotation.Transactional;

public class RatingServiceImpl implements RatingService {

	private RatingDAO radingDAO;

	private MovieDAO movieDAO;

	@Transactional
	public Rating saveRating(Rating rating) {
		Movie movie = rating.getMovie();
		int numberOfRatings = movie.getRatings().size();
		double score = calculateScore(movie.getRatings());
		movie.setRank((score + rating.getMark()) / (numberOfRatings + 1));
		movieDAO.save(movie);
		return getRadingDAO().saveRating(rating);
	}

	public RatingDAO getRadingDAO() {
		return radingDAO;
	}

	public void setRadingDAO(RatingDAO radingDAO) {
		this.radingDAO = radingDAO;
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
