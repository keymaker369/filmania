package org.seke.filmania.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "COMMENT")
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8524802817720830386L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "ID", nullable = false)),
			@AttributeOverride(name = "userId", column = @Column(name = "USER_ID", nullable = false)),
			@AttributeOverride(name = "movieId", column = @Column(name = "MOVIE_ID", nullable = false)) })
	@GeneratedValue(strategy = GenerationType.AUTO)
	private CommentId commentId;
	@Column(name = "CONTENT")
	private String content;
	// TODO TemporalType.TIMESTAMP mislim da ovde ne treba timestam vec nesto
	// drugo jer ni u bazi ta kolona nije timestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INPUTDATE", length = 19)
	private Date inputDate;
	@MapsId(value = "userId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	private User user;
	@MapsId(value = "movieId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MOVIE_ID", nullable = false, insertable = false, updatable = false)
	private Movie movie;

	public Comment() {
	}

	public Comment(CommentId commentId, User user, Movie movie) {
		this.commentId = commentId;
		this.user = user;
		this.movie = movie;
	}

	public Comment(CommentId commentId, User user, Movie movie, String content,
			Date inputDate) {
		this.commentId = commentId;
		this.user = user;
		this.movie = movie;
		this.content = content;
		this.inputDate = inputDate;
	}

	public CommentId getCommentId() {
		return this.commentId;
	}

	public void setCommentId(CommentId commentId) {
		this.commentId = commentId;
	}

	@Transient
	public long getUserId() {
		return getCommentId().getUserId();
	}

	public void setUserId(long userId) {
		getCommentId().setUserId(userId);
	}

	@Transient
	public long getMovieId() {
		return getCommentId().getMovieId();
	}

	public void setMovieId(long movieId) {
		getCommentId().setMovieId(movieId);
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

}
