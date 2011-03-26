package org.seke.filmania.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "GENRE")
@NamedQueries({ @NamedQuery(name = Genre.GET_GENRE_BY_NAME, query = "Select g from Genre g where g.name= :name ") })
public class Genre {

	public static final String GET_GENRE_BY_NAME = "Genre.getGenreByName";

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private long id;
	@Column(name = "NAME", nullable = false)
	private String name;
	@ManyToMany
	private List<Movie> movies;

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

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

}
