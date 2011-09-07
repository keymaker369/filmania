package org.seke.filmania.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.seke.filmania.controller.validation.UserValidator;
import org.seke.filmania.domain.Role;
import org.seke.filmania.domain.User;
import org.seke.filmania.model.UserCommand;
import org.seke.filmania.service.RoleService;
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

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/user/add")
	public ModelAndView openAddNewUserPage() {
		return new ModelAndView("/user/add", "newUser", new UserCommand());
	}

	@InitBinder(value = { "user", "newUser" })
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new UserValidator());
	}

	@RequestMapping(value = "/user/add", params = "saveNewUser", method = RequestMethod.POST)
	public String saveNewUser(@Valid @ModelAttribute("newUser") UserCommand command, BindingResult result) {
		if (result.hasErrors()) {
			return "/user/add";
		}

		User newUser = new User();
		newUser.setUsername(command.getUsername());
		newUser.setPassword(command.getPassword());
		newUser.setAccountNonExpired(command.isAccountNonExpired());
		newUser.setAccountNonLocked(command.isAccountNonLocked());
		newUser.setEmail(command.getEmail());
		newUser.setCredentialsNonExpired(command.isCredentialsNonExpired());
		newUser.setEnabled(command.isEnabled());

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
	public ModelAndView loadEditUserPage(@RequestParam("username") String username, HttpSession httpSession) {
		User userToEdit = getUserService().retrieveUser(username);

		UserCommand user = new UserCommand();
		user.setId(userToEdit.getId());
		user.setUsername(userToEdit.getUsername());
		httpSession.setAttribute("password", userToEdit.getPassword());
		user.setEmail(userToEdit.getEmail());
		user.setAccountNonExpired(userToEdit.isCredentialsNonExpired());
		user.setAccountNonLocked(userToEdit.isAccountNonLocked());
		user.setCredentialsNonExpired(userToEdit.isCredentialsNonExpired());
		user.setEnabled(userToEdit.isEnabled());

		for (Role role : userToEdit.getRoles()) {
			if (role.getName().equals("member"))
				user.setMember(true);
			if (role.getName().equals("admin"))
				user.setAdmin(true);
		}

		return new ModelAndView("/user/edit", "user", user);
	}

	@RequestMapping(value = "/user/edit", params = "updateUser", method = RequestMethod.POST)
	public String updateUser(@Valid UserCommand command, BindingResult result, HttpSession httpSession) {
		if (result.hasErrors()) {
			return "/user/edit";
		}

		User user = getUserService().retrieveUser(command.getId());
		user.setPassword(httpSession.getAttribute("password").toString());
		httpSession.removeAttribute("password");
		user.setAccountNonExpired(command.isAccountNonExpired());
		user.setAccountNonLocked(command.isAccountNonLocked());
		user.setEmail(command.getEmail());
		user.setCredentialsNonExpired(command.isCredentialsNonExpired());
		user.setEnabled(command.isEnabled());

		List<Role> allRoles = getRoleService().retrieveAll();
		for (Role role : allRoles) {
			if (getRoleFromSetOfRolesByName(user.getRoles(), role.getName()) == null && role.getName().equals("member") && command.isMember()) {
				user.getRoles().add(role);
			}
			if (getRoleFromSetOfRolesByName(user.getRoles(), role.getName()) == null && role.getName().equals("admin") && command.isAdmin()) {
				user.getRoles().add(role);
			}
			if (getRoleFromSetOfRolesByName(user.getRoles(), role.getName()) != null && role.getName().equals("member") && !command.isMember()) {
				removeRoleFromSet(user.getRoles(), role.getName());
			}
			if (getRoleFromSetOfRolesByName(user.getRoles(), role.getName()) != null && role.getName().equals("admin") && !command.isAdmin()) {
				removeRoleFromSet(user.getRoles(), role.getName());
			}
		}

		getUserService().updateUser(user);
		return "redirect:/index.jsp";
	}

	private Role getRoleFromSetOfRolesByName(Set<Role> roles, String name) {
		for (Role role : roles) {
			if (role.getName().equals(name))
				return role;
		}
		return null;
	}

	private void removeRoleFromSet(Set<Role> roles, String roleName) {
		for (Role role : roles) {
			if (role.getName().equals(roleName))
				roles.remove(role);
		}
	}

	@RequestMapping(value = "/user/deleteUser", method = RequestMethod.GET, params = "username")
	public ModelAndView loadDeleteUserPage(@RequestParam("username") String username) {
		User userToDelete = getUserService().retrieveUser(username);
		UserCommand command = new UserCommand();
		command.setUsername(userToDelete.getUsername());
		return new ModelAndView("/user/deleteUser", "user", command);
	}

	@RequestMapping(value = "/user/deleteUser", method = RequestMethod.POST, params = "delete")
	public String deleteUser(@RequestParam("username") String username) {
		getUserService().deleteUser(username);
		return "redirect:/user/viewUsers";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

}
