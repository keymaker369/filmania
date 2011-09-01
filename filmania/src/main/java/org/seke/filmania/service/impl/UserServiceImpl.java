package org.seke.filmania.service.impl;

import java.util.List;

import org.seke.filmania.dao.UserDAO;
import org.seke.filmania.domain.User;
import org.seke.filmania.service.UserService;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceImpl implements UserService, UserDetailsService {

	private UserDAO userDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.seke.filmania.service.UserService#saveUser(org.seke.filmania.domain
	 * .User)
	 */
	@Transactional
	public void saveUser(User user) {
		getUserDAO().create(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.service.UserService#retrieveUser(int)
	 */
	public User retrieveUser(Long id) {
		return getUserDAO().getUser(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.service.UserService#retrieveAllUsers()
	 */
	public List<User> retrieveAllUsers() {
		return getUserDAO().getAllUsers();
	}

	/*
	 * (non-Javadoc)
	 * @see org.seke.filmania.service.UserService#retrieveUser(java.lang.String)
	 */
	public User retrieveUser(String username) {
		return getUserDAO().getUser(username);
	}

	/*
	 * (non-Javadoc)
	 * @see org.seke.filmania.service.UserService#updateUser(org.seke.filmania.domain.User)
	 */
	@Transactional
	public void updateUser(User user) {
		getUserDAO().updateUser(user);
	}

	/*
	 * (non-Javadoc)
	 * @see org.seke.filmania.service.UserService#deleteUser(java.lang.String)
	 */
	@Transactional
	public void deleteUser(String username) {
		getUserDAO().deleteUser(username);
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		return getUserDAO().getUser(username);
	}

	

}
