package org.seke.filmania.service.impl;

import org.seke.filmania.dao.UserDAO;
import org.seke.filmania.domain.User;
import org.seke.filmania.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	/*
	 * (non-Javadoc)
	 * @see org.seke.filmania.service.UserService#saveUser(org.seke.filmania.domain.User)
	 */
	public void saveUser(User user) {
		getUserDAO().create(user);
	}

	/*
	 * (non-Javadoc)
	 * @see org.seke.filmania.service.UserService#retrieveUser(int)
	 */
	public User retrieveUser(int id) {
		return getUserDAO().getUser(id);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
