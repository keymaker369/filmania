package org.seke.filmania.controller;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;

import org.seke.filmania.controller.validation.CommentValidator;
import org.seke.filmania.controller.validation.MovieValidator;
import org.seke.filmania.domain.Movie;
import org.seke.filmania.domain.User;
import org.seke.filmania.model.MovieBean;
import org.seke.filmania.service.GenreService;
import org.seke.filmania.service.MovieService;
import org.seke.filmania.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@InitBinder(value = "newMovie")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new MovieValidator());
    }
	
	@RequestMapping(value = "/movie/add")
	public ModelAndView openAddMoviePage() {
		MovieBean movieBean = new MovieBean();
		movieBean.setAllGenres(getGenreService().getAllGenreBeans());
		return new ModelAndView("/movie/add", "newMovie", movieBean);
	}

	@RequestMapping(value = "/movie/add", params = "saveNewMovie", method = RequestMethod.POST)
	public ModelAndView saveNewMovie(@Valid @ModelAttribute("newMovie") MovieBean movieBean, BindingResult result, Principal principal) {
		if(result.hasErrors()){
			return new ModelAndView("/movie/add");
		}
		
		User tempUser = getUserService().retrieveUser(principal.getName());
		movieBean.setUser(tempUser);
		movieBean.setInputDate(new Timestamp(System.currentTimeMillis()));
		getMovieService().saveMovie(movieBean);
		return new ModelAndView("redirect:/movie/movies", "newMovie", movieBean);
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

	@RequestMapping(value = "/movie/movies", method = RequestMethod.POST, params = "searchMovie")
	public ModelAndView searchMovies(@RequestParam("movieName") String movieName) {
		List<Movie> movies = getMovieService().retrieveMoviesStartingWith(movieName);
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
