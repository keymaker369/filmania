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
@Table(name = "comment", catalog = "filmania")
public class Comment implements java.io.Serializable {

	private CommentId id;
	private User user;
	private Movie movie;
	private String content;
	private Date inputdate;

	public Comment() {
	}

	public Comment(CommentId id, User user, Movie movie) {
		this.id = id;
		this.user = user;
		this.movie = movie;
	}

	public Comment(CommentId id, User user, Movie movie, String content, Date inputdate) {
		this.id = id;
		this.user = user;
		this.movie = movie;
		this.content = content;
		this.inputdate = inputdate;
	}

	@EmbeddedId
	@AttributeOverrides({ 
		@AttributeOverride(name = "id", column = @Column(name = "ID", nullable = false)), 
		@AttributeOverride(name = "userId", column = @Column(name = "USER_ID", nullable = false)),
		@AttributeOverride(name = "movieId", column = @Column(name = "MOVIE_ID", nullable = false)) })
	public CommentId getId() {
		return this.id;
	}

	public void setId(CommentId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MOVIE_ID", nullable = false, insertable = false, updatable = false)
	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Column(name = "CONTENT")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INPUTDATE", length = 19)
	public Date getInputdate() {
		return this.inputdate;
	}

	public void setInputdate(Date inputdate) {
		this.inputdate = inputdate;
	}

}
