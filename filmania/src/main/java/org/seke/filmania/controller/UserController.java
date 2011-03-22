package org.seke.filmania.controller;

import org.seke.filmania.domain.User;
import org.seke.filmania.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/add")
	public ModelAndView openAddNewUserPage() {
		return new ModelAndView("/user/add", "newUser", new User());
	}

	@RequestMapping(value = "/user/add", params = "saveNewUser", method = RequestMethod.POST)
	public String saveNewUser(User newUser, BindingResult bindingResult) {
		userService.saveUser(newUser);
		return "redirect:/index.jsp";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
