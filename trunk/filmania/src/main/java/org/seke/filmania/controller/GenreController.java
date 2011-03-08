package org.seke.filmania.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GenreController {

	@RequestMapping(value = "/genre/add")
	public String openAddgenrePage() {
		return "/genre/add";
	}
}
