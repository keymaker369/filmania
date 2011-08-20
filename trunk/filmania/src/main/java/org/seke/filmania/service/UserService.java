package org.seke.filmania.service;

import java.util.List;

import org.seke.filmania.domain.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

	/**
	 * Saves new user.
	 */
	public void saveUser(User user);

	/**
	 * Retrieve user for given id.
	 * 
	 * @param id
	 */
	public User retrieveUser(Long id);

	/**
	 * Retrieve all users.
	 */
	public List<User> retrieveAllUsers();

	/**
	 * Retrieve user for given username.
	 * 
	 * @param id
	 */
	public User retrieveUser(String username);
	
	/**
	 * Updates users data.
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * Delete user from database for given username.
	 * @param user
	 */
	public void deleteUser(String username);
}
