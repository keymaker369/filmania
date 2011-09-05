package org.seke.filmania.utils;

import org.seke.filmania.dao.RoleDAO;
import org.seke.filmania.domain.Genre;
import org.seke.filmania.domain.Role;
import org.seke.filmania.domain.User;
import org.seke.filmania.service.GenreService;
import org.seke.filmania.service.MovieService;
import org.seke.filmania.service.UserService;

public class DatabasePopulate {

	private GenreService genreService;

	private MovieService movieService;

	private UserService userService;

	private RoleDAO roleDAO;

	public void databasePopulate() {
		Role admin = new Role();
		admin.setName("admin");
		getRoleDAO().saveRole(admin);
		
		Role member = new Role();
		member.setName("member");
		getRoleDAO().saveRole(member);
		
		User adminUser = new User();
		adminUser.setUsername("admin");
		adminUser.setPassword("1");
		adminUser.setAccountNonExpired(true);
		adminUser.setAccountNonLocked(true);
		adminUser.setCredentialsNonExpired(true);
		adminUser.setEmail("zika@zika.com");
		adminUser.setEnabled(true);
		adminUser.getRoles().add(member);
		adminUser.getRoles().add(admin);
		getUserService().saveUser(adminUser);
		
		User memberUser = new User();
		memberUser.setUsername("member");
		memberUser.setPassword("1");
		memberUser.setAccountNonExpired(true);
		memberUser.setAccountNonLocked(true);
		memberUser.setCredentialsNonExpired(true);
		memberUser.setEmail("memberUser@memberUser.com");
		memberUser.setEnabled(true);
		memberUser.getRoles().add(member);
		getUserService().saveUser(memberUser);
		
		Genre akcija = new Genre();
		akcija.setName("akcija");
		getGenreService().saveGenre(akcija);
		
		Genre triler = new Genre();
		triler.setName("triler");
		getGenreService().saveGenre(triler);
		
		Genre komedija = new Genre();
		komedija.setName("komedija");
		getGenreService().saveGenre(komedija);
		
		
		
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

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

}
