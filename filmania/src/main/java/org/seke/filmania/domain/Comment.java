package org.seke.filmania.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENT")
public class Comment {

	@Id
	private CommentID commentId;

	// @ManyToOne
	// private User user;
	// @ManyToOne
	// private Movie movie;
	@Column(name = "CONNTENT")
	private String conntent;
	@Column(name = "INPUTDATE")
	private Date inputDate;

	//
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

	@IdClass(value = Comment.class)
	public static class CommentID implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -492862153635102131L;

		@ManyToOne
		public User user;

		@ManyToOne
		public Movie movie;

	}

}
