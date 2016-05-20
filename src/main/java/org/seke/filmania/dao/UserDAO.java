package org.seke.filmania.dao;

import java.util.List;

import org.seke.filmania.domain.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Interface for DAO User service.
 * 
 * @author Nenad Seke May 15, 2011
 */
public interface UserDAO {

	/**
	 * Persist user object in database.
	 * 
	 * @param user
	 */
	public void create(User user);

	/**
	 * Retrieves user for given id. 
	 * @param id
	 * @return
	 */
	public User getUser(Long id);

	/**
	 * Retrieves all users from database.
	 */
	public List<User> getAllUsers();
	
	/**
	 * Retrieves user for given username. 
	 * @param id
	 * @return
	 */
	public User getUser(String username);
	
	/**
	 * Updates users data.
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * Deletes user;
	 * @param username
	 */
	public void deleteUser(String username);

}
