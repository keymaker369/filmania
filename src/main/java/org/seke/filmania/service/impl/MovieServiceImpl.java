package org.seke.filmania.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.seke.filmania.dao.CommentDAO;
import org.seke.filmania.dao.MovieDAO;
import org.seke.filmania.domain.Comment;
import org.seke.filmania.domain.Genre;
import org.seke.filmania.domain.Movie;
import org.seke.filmania.domain.User;
import org.seke.filmania.model.GenreBean;
import org.seke.filmania.model.MovieBean;
import org.seke.filmania.service.GenreService;
import org.seke.filmania.service.MovieService;
import org.seke.filmania.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDAO movieDAO;

	@Autowired
	private GenreService genreService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentDAO commentDAO;

	public void saveMovie(MovieBean movieBean) {
		Movie movie = createMovieFromMovieBean(movieBean);
		saveMovie(movie);
	}

	public void saveMovie(Movie movie) {
		getMovieDAO().save(movie);
	}

	public List<Movie> retriveAllMovies() {
		return getMovieDAO().retriveAllMovies();
	}

	private Movie createMovieFromMovieBean(MovieBean movieBean) {
		Movie movie = new Movie();
		movie.setName(movieBean.getName());
		movie.setInputDate(new Date(movieBean.getInputDate().getTime()));
		movie.setGenres(new HashSet<Genre>());
		for (GenreBean genreBean : movieBean.getAllGenres()) {
			if (genreBean.isAssigned()) {
				movie.getGenres().add(getGenreService().retrieveGenre(genreBean.getId() + ""));
			}
		}
		movie.setRank(new Double(0));
		movie.setUser(movieBean.getUser());
		return movie;
	}

	public List<Movie> retrieveMoviesStartingWith(String movieName) {
		return getMovieDAO().retrieveMoviesStartingWith(movieName);
	}

	public Movie retrieveMovie(long id) {
		return getMovieDAO().retrieve(id);
	}

	public void addMovieComment(long movieId, Comment comment, String username) {
		User user = getUserService().retrieveUser(username);
		Movie movie = getMovieDAO().retrieve(movieId);
		comment.setMovie(movie);
		comment.setUser(user);
		getCommentDAO().saveComment(comment);
	}

	public MovieDAO getMovieDAO() {
		return movieDAO;
	}

	public void setMovieDAO(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public GenreService getGenreService() {
		return genreService;
	}

	public void setGenreService(GenreService genreService) {
		this.genreService = genreService;
	}

	public CommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

}
