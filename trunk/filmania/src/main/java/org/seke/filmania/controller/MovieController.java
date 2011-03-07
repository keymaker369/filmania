package org.seke.filmania.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Nenad Seke
 * 
 */
@Controller
public class MovieController {

	@RequestMapping(value = "/movie/add")
	public String openAddMoviePage() {

		return "/movie/add";
	}

}
