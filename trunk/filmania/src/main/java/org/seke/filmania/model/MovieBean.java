package org.seke.filmania.model;

import java.sql.Timestamp;
import java.util.List;

public class MovieBean {

	private String name;
	private List<GenreBean> allGenres;
	private Timestamp inputDate;

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

	public Timestamp getInputDate() {
		return inputDate;
	}

	public void setInputDate(Timestamp inputDate) {
		this.inputDate = inputDate;
	}

}
