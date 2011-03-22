package org.seke.filmania.model;

import java.util.List;

public class MovieBean {

	private String name;
	private List<GenreBean> allGenres;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<GenreBean> getAllGenres() {
		return allGenres;
	}

	public void setAllGenres(List<GenreBean> allGenres) {
		this.allGenres = allGenres;
	}

}
