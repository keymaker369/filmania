package org.seke.filmania.service;

import org.seke.filmania.dao.UserDAO;
import org.seke.filmania.domain.User;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.service.UserService#saveUser(org.seke.filmania.domain.User)
	 */
	public void saveUser(User user) {
		getUserDAO().create(user);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
