package org.seke.filmania.controller;

import java.security.Principal;
import java.util.Date;

import org.seke.filmania.dao.RatingService;
import org.seke.filmania.domain.Movie;
import org.seke.filmania.domain.Rating;
import org.seke.filmania.domain.RatingId;
import org.seke.filmania.domain.User;
import org.seke.filmania.model.AddMarkCommand;
import org.seke.filmania.service.MovieService;
import org.seke.filmania.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RatingController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private UserService userService;

	@Autowired
	private RatingService ratingService;

	@RequestMapping(value = "/movie/rateMovie", method = RequestMethod.GET, params = "idMovie")
	public ModelAndView loadAddMarkPage(@RequestParam("idMovie") String idMovie) {
		
		Movie movieToRate = getMovieService().retrieveMovie(Long.parseLong(idMovie));
		ModelAndView mav = new ModelAndView("/movie/rateMovie", "movie", movieToRate);
		mav.addObject("addMarkCommand", new AddMarkCommand());
		return mav;
	}

	@RequestMapping(value = "/movie/rateMovie", method = RequestMethod.POST, params = "saveMark")
	public String addCommentPage(@ModelAttribute("addMarkCommand") AddMarkCommand command, Principal principal) {

		Rating rating = new Rating();
		rating.setMark(command.getMark());
		rating.setInputDate(new Date(System.currentTimeMillis()));
		
		Movie commentedMovie = getMovieService().retrieveMovie(command.getMovieId());
		User tempUser = getUserService().retrieveUser(principal.getName());
		
		rating.setUser(tempUser);
		rating.setMovie(commentedMovie);
		
		getRatingService().saveRating(rating);
		return "redirect:/movie/view?id=" + command.getMovieId();
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

	public RatingService getRatingService() {
		return ratingService;
	}

	public void setRatingService(RatingService ratingService) {
		this.ratingService = ratingService;
	}

}
