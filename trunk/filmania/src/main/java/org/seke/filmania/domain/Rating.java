package org.seke.filmania.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RATING")
public class Rating {

	@Id
	private RatingId ratingId;

	//
	// @ManyToOne
	// private User user;
	//
	// @ManyToOne
	// private Movie movie;

	// private int value;
	//
	// public RatingId getRatingId() {
	// return ratingId;
	// }
	//
	// public void setRatingId(RatingId ratingId) {
	// this.ratingId = ratingId;
	// }

	// public User getUser() {
	// return user;
	// }
	//
	// public void setUser(User user) {
	// this.user = user;
	// }
	//
	// public Movie getMovie() {
	// return movie;
	// }
	//
	// public void setMovie(Movie movie) {
	// this.movie = movie;
	// }

	// public int getValue() {
	// return value;
	// }
	//
	// public void setValue(int value) {
	// this.value = value;
	// }

	@IdClass(Rating.class)
	public static class RatingId implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 4078766891792538922L;
		@ManyToOne
		private User user;
		@ManyToOne
		private Movie movie;
		private int value;

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Movie getMovie() {
			return movie;
		}

		public void setMovie(Movie movie) {
			this.movie = movie;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}
}
