package org.seke.filmania.utils;

import org.seke.filmania.domain.Genre;
import org.seke.filmania.domain.User;
import org.seke.filmania.domain.User.Role;
import org.seke.filmania.service.GenreService;
import org.seke.filmania.service.MovieService;
import org.seke.filmania.service.UserService;

public class DatabasePopulate {

	private GenreService genreService;

	private MovieService movieService;

	private UserService userService;

	public void databasePopulate() {
		
		User adminUser = new User();
		adminUser.setUsername("admin");
		adminUser.setPassword("1");
		adminUser.setAccountNonExpired(true);
		adminUser.setAccountNonLocked(true);
		adminUser.setCredentialsNonExpired(true);
		adminUser.setEmail("zika@zika.com");
		adminUser.setEnabled(true);
		adminUser.setRole(Role.ADMIN);
		getUserService().saveUser(adminUser);
		
		User memberUser = new User();
		memberUser.setUsername("member");
		memberUser.setPassword("1");
		memberUser.setAccountNonExpired(true);
		memberUser.setAccountNonLocked(true);
		memberUser.setCredentialsNonExpired(true);
		memberUser.setEmail("memberUser@memberUser.com");
		memberUser.setEnabled(true);
		memberUser.setRole(Role.MEMBER);
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

}
