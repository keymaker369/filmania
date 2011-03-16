package org.seke.filmania.service;

import org.seke.filmania.domain.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

	/**
	 * Saves new user.
	 */
	@Transactional
	public void saveUser(User user);
}
