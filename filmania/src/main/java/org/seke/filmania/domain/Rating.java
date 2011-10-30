package org.seke.filmania.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RATING")
public class Rating implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8577896571409976635L;
	
	
	private RatingId ratingId;

	private User user;
	
	private Movie movie;
	
	private int mark;

	private Date inputDate;

	public Rating() {
	}

	public Rating(RatingId ratingId, User user, Movie movie) {
		this.ratingId = ratingId;
		this.user = user;
		this.movie = movie;
	}

	public Rating(RatingId ratingId, User user, Movie movie, int mark, Date inputDate) {
		this.ratingId = ratingId;
		this.user = user;
		this.movie = movie;
		this.mark = mark;
		this.inputDate = inputDate;
	}

	@EmbeddedId
	@AttributeOverrides({ 
		@AttributeOverride(name = "id", column = @Column(name = "ID", nullable = false)), 
		@AttributeOverride(name = "userId", column = @Column(name = "USER_ID", nullable = false)),
		@AttributeOverride(name = "movieId", column = @Column(name = "MOVIE_ID", nullable = false)) })
	public RatingId getRatingId() {
		return ratingId;
	}

	public void setRatingId(RatingId ratingId) {
		this.ratingId = ratingId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MOVIE_ID", nullable = false, insertable = false, updatable = false)
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Column(name = "MARK")
	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INPUTDATE", length = 19)
	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

}
