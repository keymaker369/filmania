package org.seke.filmania.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MOVIE")
@NamedQueries({ @NamedQuery(name = Movie.GET_All_MOVIES, query = "from Movie m ") })
public class Movie {

	public static final String GET_All_MOVIES = "Movie.getAllMovies";

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	@Column(name = "NAME", length = 20)
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INPUTDATE", length = 19)
	private Date inputDate;
	@Column(name = "RANK", precision = 22, scale = 0)
	private Double rank;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "movie", cascade = {CascadeType.MERGE, CascadeType.PERSIST })
	private Set<Comment> comments = new HashSet<Comment>(0);
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "movie", cascade = {CascadeType.MERGE, CascadeType.PERSIST })
	private Set<Rating> ratings = new HashSet<Rating>(0);
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "MOVIE_GENRE", 
		joinColumns = { @JoinColumn(name = "MOVIE_ID", nullable = false, updatable = false) }, 
		inverseJoinColumns = { @JoinColumn(name = "GENRE_ID", nullable = false, updatable = false) })
	private Set<Genre> genres = new HashSet<Genre>(0);

	public Movie() {
	}

	public Movie(User user) {
		this.user = user;
	}

	public Movie(User user, String name, Date inputDate, Double rank,
			Set<Comment> comments, Set<Genre> genres) {
		this.user = user;
		this.name = name;
		this.inputDate = inputDate;
		this.rank = rank;
		this.comments = comments;
		this.genres = genres;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public Double getRank() {
		return this.rank;
	}

	public void setRank(Double rank) {
		this.rank = rank;
	}

	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Genre> getGenres() {
		return this.genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

}
