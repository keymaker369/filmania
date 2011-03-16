package org.seke.filmania.dao;

import org.seke.filmania.domain.User;

/**
 * 
 * @author nenad.seke
 *
 */
public interface UserDAO {

	/**
	 * Persist user object in database.
	 * @param user
	 */
	public void create(User user);
}
