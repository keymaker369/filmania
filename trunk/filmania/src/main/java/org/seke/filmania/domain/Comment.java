package org.seke.filmania.domain;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENT")
public class Comment {

	@Id
	private CommentID commentId;

	@ManyToOne
	private User user;
	@ManyToOne
	private Movie movie;
	private String conntent;
	private Date inputDate;

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

	public String getConntent() {
		return conntent;
	}

	public void setConntent(String conntent) {
		this.conntent = conntent;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public CommentID getCommentId() {
		return commentId;
	}

	public void setCommentId(CommentID commentId) {
		this.commentId = commentId;
	}

	@Embeddable
	public static class CommentID {

		@ManyToOne
		@JoinColumn(name = "userID")
		public long userId;

		@ManyToOne
		@JoinColumn(name = "movieId")
		public long movieId;

	}

}
