package org.seke.filmania.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.seke.filmania.domain.User;
import org.seke.filmania.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String saveNewUser(@ModelAttribute("newUser") User newUser) {
		getUserService().saveUser(newUser);
		return "redirect:/index.jsp";
	}

	@RequestMapping(value = "/user/viewUsers", method = RequestMethod.GET)
	public ModelAndView viewUsers() {
		List<User> users = getUserService().retrieveAllUsers();
		ModelAndView mav = new ModelAndView("/user/viewUsers", "users", users);
		return mav;
	}

	@RequestMapping(value = "/user/edit", method = RequestMethod.GET, params = "username")
	public ModelAndView loadEditUserPage(@RequestParam("username") String username) {
		User userToEdit = getUserService().retrieveUser(username);
		return new ModelAndView("/user/edit", "user", userToEdit);
	}

	@RequestMapping(value = "/user/edit", params = "updateUser", method = RequestMethod.POST)
	public String updateUser(User user, BindingResult result) {
		getUserService().updateUser(user);
		return "redirect:/index.jsp";
	}

	@RequestMapping(value = "/user/deleteUser", method = RequestMethod.GET, params = "username")
	public ModelAndView loadDeleteUserPage(@RequestParam("username") String username){
		User userToDelete = getUserService().retrieveUser(username);
		return new ModelAndView("/user/deleteUser", "user", userToDelete);
	}
	
	@RequestMapping(value = "/user/deleteUser", method = RequestMethod.POST, params = "delete")
	public String deleteUser(@RequestParam("username") String username){
		getUserService().deleteUser(username);
		return "redirect:/user/viewUsers";
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
