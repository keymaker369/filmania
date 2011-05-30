package org.seke.filmania.dao;

import org.seke.filmania.domain.User;

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
	public User getUser(int id);

}
