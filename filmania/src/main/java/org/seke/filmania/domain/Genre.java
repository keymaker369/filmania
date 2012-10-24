package org.seke.filmania.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "GENRE")
@NamedQueries({
		@NamedQuery(name = Genre.GET_GENRE_BY_NAME, query = "Select g from Genre g where g.id= :name "),

		@NamedQuery(name = Genre.GET_ALL_GENRES, query = "Select g from Genre g ") })
public class Genre {

	public static final String GET_GENRE_BY_NAME = "Genre.getGenreByName";

	public static final String GET_ALL_GENRES = "Genre.getAllGenres";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	@Column(name = "NAME", length = 20)
	private String name;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "MOVIE_GENRE", 
		joinColumns = {@JoinColumn(name = "GENRE_ID", nullable = false, updatable = false) }, 
		inverseJoinColumns = { @JoinColumn(name = "MOVIE_ID", nullable = false, updatable = false) })
	private Set<Movie> movies = new HashSet<Movie>(0);

	public Genre() {
	}

	public Genre(String name, Set<Movie> movies) {
		this.name = name;
		this.movies = movies;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Movie> getMovies() {
		return this.movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
}
