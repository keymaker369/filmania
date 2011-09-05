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
	private CommentId id;
	
	@MapsId(value = "userId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	private User user;
	
	@MapsId(value = "movieId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MOVIE_ID", nullable = false, insertable = false, updatable = false)
	private Movie movie;
	
	@Column(name = "CONTENT")
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INPUTDATE", length = 19)
	private Date inputDate;

	public Comment() {
	}

	public Comment(CommentId id, User user, Movie movie) {
		this.id = id;
		this.user = user;
		this.movie = movie;
	}

	public Comment(CommentId id, User user, Movie movie, String content, Date inputDate) {
		this.id = id;
		this.user = user;
		this.movie = movie;
		this.content = content;
		this.inputDate = inputDate;
	}

	public CommentId getId() {
		return this.id;
	}

	public void setId(CommentId id) {
		this.id = id;
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
