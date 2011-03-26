package org.seke.filmania.utils;

import org.seke.filmania.domain.Genre;
import org.seke.filmania.model.GenreBean;

public class GenreUtils {
	
	/**
	 * Creates new {@link GenreBean} object from {@link Genre} object.
	 * 
	 * @param genre
	 * @return
	 */
	public static GenreBean createGenreBeanFromGenre(Genre genre) {
		GenreBean genreBean = new GenreBean();
		genreBean.setGenre(genre);
		genreBean.setName(genre.getName());
		return genreBean;
	}
	
	/**
	 * Creates new {@link Genre} object from {@link GenreBean} object.
	 * 
	 * @param genre
	 * @return
	 */
	public static Genre createGenreFromGenreBean(GenreBean genreBean) {
		Genre genre = new Genre();
		genre.setName(genreBean.getName());
		return genre;
	}
}
