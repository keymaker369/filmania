package org.seke.filmania.model;

import org.seke.filmania.domain.Genre;

public class GenreBean {

	private long id;
	private Genre genre;
	private boolean assigned;
	private String name;

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public boolean isAssigned() {
		return assigned;
	}

	public void setAssigned(boolean assigned) {
		this.assigned = assigned;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
