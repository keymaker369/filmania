package org.seke.filmania.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Composite id for Comment object.
 */
@Embeddable
public class CommentId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -275636493390380334L;
	private int id;
	private int userId;
	private int movieId;

	public CommentId() {
	}

	public CommentId(int id, int userId, int movieId) {
		this.id = id;
		this.userId = userId;
		this.movieId = movieId;
	}

	@Column(name = "ID", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "USER_ID", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "MOVIE_ID", nullable = false)
	public int getMovieId() {
		return this.movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CommentId))
			return false;
		CommentId castOther = (CommentId) other;

		return (this.getId() == castOther.getId()) && (this.getUserId() == castOther.getUserId()) && (this.getMovieId() == castOther.getMovieId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result + this.getUserId();
		result = 37 * result + this.getMovieId();
		return result;
	}

}
