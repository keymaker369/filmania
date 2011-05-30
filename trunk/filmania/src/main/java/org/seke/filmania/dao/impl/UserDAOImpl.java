package org.seke.filmania.dao.impl;

import javax.persistence.EntityManager;

import org.seke.filmania.dao.UserDAO;
import org.seke.filmania.domain.User;
import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * 
 * @author nenad.seke
 * 
 */
public class UserDAOImpl extends JpaDaoSupport implements UserDAO {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.dao.UserDAO#create(org.seke.filmania.domain.User)
	 */
	public void create(User user) {
		getJpaTemplate().persist(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.dao.UserDAO#getUser(int)
	 */
	public User getUser(int id) {
		EntityManager manager = getJpaTemplate().getEntityManagerFactory().createEntityManager();
		return (User) manager.createNamedQuery(User.GET_USER_BY_ID).setParameter("id", id).getSingleResult();
	}

}
