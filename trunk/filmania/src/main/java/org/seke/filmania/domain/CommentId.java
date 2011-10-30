package org.seke.filmania.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
/**
 * Composite id for Comment object.
 */
@Embeddable
public class CommentId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -275636493390380334L;
	
	private Long id;
	
	private Long userId;
	
	private Long movieId;

	public CommentId() {
	}

	public CommentId(Long id, Long userId, Long movieId) {
		this.id = id;
		this.userId = userId;
		this.movieId = movieId;
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "USER_ID", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "MOVIE_ID", nullable = false)
	public Long getMovieId() {
		return this.movieId;
	}

	public void setMovieId(Long movieId) {
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
	
	@Override
	public int hashCode() {
		return id.hashCode() + userId.hashCode() + movieId.hashCode();
	}

}
