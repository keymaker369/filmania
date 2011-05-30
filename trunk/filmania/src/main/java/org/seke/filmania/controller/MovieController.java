package org.seke.filmania.controller;

import java.sql.Timestamp;
import java.util.List;

import org.seke.filmania.domain.Movie;
import org.seke.filmania.domain.User;
import org.seke.filmania.model.MovieBean;
import org.seke.filmania.service.GenreService;
import org.seke.filmania.service.MovieService;
import org.seke.filmania.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Nenad Seke
 * 
 */
@Controller
public class MovieController {

	@Autowired
	private GenreService genreService;

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/movie/add")
	public ModelAndView openAddMoviePage() {
		MovieBean movieBean = new MovieBean();
		movieBean.setAllGenres(getGenreService().getAllGenreBeans());
		return new ModelAndView("/movie/add", "newMovie", movieBean);
	}

	@RequestMapping(value = "/movie/add", params = "saveNewMovie", method = RequestMethod.POST)
	public ModelAndView saveNewMovie(MovieBean movieBean, BindingResult bindingResult) {
		//TODO izmeni ovo. User ce da se vadi iz sesije.to je ulogovan user.
		User tempUser = getUserService().retrieveUser(1);movieBean.setUser(tempUser); 
		movieBean.setInputDate(new Timestamp(System.currentTimeMillis()));
		getMovieService().saveMovie(movieBean);
		return new ModelAndView("redirect:/movie/add", "newMovie", movieBean);
	}

	@RequestMapping(value = "/movie/view")
	public ModelAndView viewMovie(@RequestParam(value = "id") String id) {
		Movie movie = getMovieService().retrieveMovie(Long.parseLong(id));
		return new ModelAndView("/movie/view", "movie", movie);
	}

	@RequestMapping(value = "/movie/movies")
	public ModelAndView openShowAllMoviesPage() {
		List<Movie> movies = getMovieService().retriveAllMovies();
		return new ModelAndView("/movie/movies", "movies", movies);
	}

	public GenreService getGenreService() {
		return genreService;
	}

	public void setGenreService(GenreService genreService) {
		this.genreService = genreService;
	}

	public MovieService getMovieService() {
		return movieService;
	}

	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
