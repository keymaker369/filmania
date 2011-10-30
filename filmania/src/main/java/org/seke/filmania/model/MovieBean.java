package org.seke.filmania.model;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.seke.filmania.domain.User;

public class MovieBean {

	private String name;
	private List<GenreBean> allGenres = new LinkedList<GenreBean>();
	private Timestamp inputDate;
	private User user;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
