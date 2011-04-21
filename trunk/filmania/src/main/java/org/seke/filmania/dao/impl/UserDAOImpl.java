package org.seke.filmania.dao.impl;

import org.seke.filmania.dao.UserDAO;
import org.seke.filmania.domain.User;
import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * 
 * @author nenad.seke
 * 
 */
public class UserDAOImpl extends JpaDaoSupport implements UserDAO {

	public void create(User user) {
		getJpaTemplate().persist(user);
	}

}
