package org.seke.filmania.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE")
@NamedQueries({ @NamedQuery(name = Movie.GET_All_MOVIES, query = "from Movie m ") })
public class Movie {

	public static final String GET_All_MOVIES = "Movie.getAllMovies";

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "INPUT_DATE")
	private Timestamp inputDate;
	@Column(name = "RANK")
	private double rank;
	@ManyToOne
	private User user;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Comment> comments;
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Genre> genres;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getInputDate() {
		return inputDate;
	}

	public void setInputDate(Timestamp inputDate) {
		this.inputDate = inputDate;
	}

	public double getRank() {
		return rank;
	}

	public void setRank(double rank) {
		this.rank = rank;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

}
