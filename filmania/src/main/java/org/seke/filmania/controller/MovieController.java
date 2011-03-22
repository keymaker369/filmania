package org.seke.filmania.controller;

import org.seke.filmania.model.MovieBean;
import org.seke.filmania.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Nenad Seke
 * 
 */
@Controller
public class MovieController {

	@Autowired
	private GenreService genreService;

	@RequestMapping(value = "/movie/add")
	public ModelAndView openAddMoviePage() {
		MovieBean movieBean = new MovieBean();
		movieBean.setAllGenres(genreService.getAllGenreBeans());
		return new ModelAndView("/movie/add", "newMovie", movieBean);
	}

	@RequestMapping(value = "/movie/add", params = "saveNewMovie", method = RequestMethod.POST)
	public ModelAndView saveNewMovie(MovieBean movieBean) {
		System.out.println(movieBean.getName());
		return new ModelAndView("redirect:/movie/add", "newMovie", movieBean);
	}

	public GenreService getGenreService() {
		return genreService;
	}

	public void setGenreService(GenreService genreService) {
		this.genreService = genreService;
	}

}
