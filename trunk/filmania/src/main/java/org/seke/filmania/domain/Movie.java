package org.seke.filmania.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
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

	private Integer id;
	private User user;
	private String name;
	private Date inputdate;
	private Double rank;
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Set<Genre> genres = new HashSet<Genre>(0);

	public Movie() {
	}

	public Movie(User user) {
		this.user = user;
	}

	public Movie(User user, String name, Date inputdate, Double rank, Set<Comment> comments, Set<Genre> genres) {
		this.user = user;
		this.name = name;
		this.inputdate = inputdate;
		this.rank = rank;
		this.comments = comments;
		this.genres = genres;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "NAME", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INPUTDATE", length = 19)
	public Date getInputdate() {
		return this.inputdate;
	}

	public void setInputdate(Date inputdate) {
		this.inputdate = inputdate;
	}

	@Column(name = "RANK", precision = 22, scale = 0)
	public Double getRank() {
		return this.rank;
	}

	public void setRank(Double rank) {
		this.rank = rank;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "movie_genre", catalog = "filmania", 
			joinColumns = { @JoinColumn(name = "MOVIE_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "GENRE_ID", nullable = false, updatable = false) })
	public Set<Genre> getGenres() {
		return this.genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

}
