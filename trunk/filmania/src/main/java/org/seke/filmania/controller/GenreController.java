package org.seke.filmania.controller;

import java.util.List;

import org.seke.filmania.domain.Genre;
import org.seke.filmania.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GenreController {

	@Autowired
	private GenreService genreService;

	@RequestMapping(value = "/genre/add")
	public ModelAndView openAddGenrePage() {
		Genre newGenre = new Genre();
		return new ModelAndView("/genre/add", "newGenre", newGenre);
	}

	@RequestMapping(value = "/genre/add", params = "saveNewGenre", method = RequestMethod.POST)
	public String saveNewGenre(Genre newGenre, BindingResult bindingResult) {
		genreService.saveGenre(newGenre);
		return "redirect:/genre/add";
	}

	@RequestMapping(value = "/genre/genres")
	public ModelAndView openViewGenresPage() {
		List<Genre> genres = getGenreService().getAllGenres();
		return new ModelAndView("/genre/genres","genres",genres);
	}

	@RequestMapping(value = "/genre/editGenre", method = RequestMethod.GET, params = "name")
	public ModelAndView loadPageEditGenre(@RequestParam("name") String name){
		Genre genreToEdit = getGenreService().retrieveGenre(name);
		return new ModelAndView("/genre/editGenre", "genre", genreToEdit); 
	}
	
	@RequestMapping(value = "/genre/editGenre", method = RequestMethod.POST, params = "updateGenre")
	public String edit(@ModelAttribute("genre") Genre genre){
		getGenreService().updateGenre(genre);
		return "redirect:/genre/genres"; 
	}
	
	/**
	 * @return the genreService
	 */
	public GenreService getGenreService() {
		return genreService;
	}

	/**
	 * @param genreService
	 *            the genreService to set
	 */
	public void setGenreService(GenreService genreService) {
		this.genreService = genreService;
	}

}
