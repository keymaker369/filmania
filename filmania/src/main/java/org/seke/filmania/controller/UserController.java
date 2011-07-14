package org.seke.filmania.controller;

import java.util.List;

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
		getUserService().saveUser(newUser);
		return "redirect:/index.jsp";
	}

	@RequestMapping(value = "/user/viewUsers", method = RequestMethod.GET)
	public ModelAndView viewUsers() {
		List<User> users = getUserService().retrieveAllUsers();
		ModelAndView mav = new ModelAndView("/user/users", "users", users);
		return mav;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
