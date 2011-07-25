package org.seke.filmania.dao.impl;

import java.util.List;

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

	/*
	 * (non-Javadoc)
	 * @see org.seke.filmania.dao.UserDAO#getAllUsers()
	 */
	public List<User> getAllUsers() {
		EntityManager manager = getJpaTemplate().getEntityManagerFactory().createEntityManager();
		return getJpaTemplate().findByNamedQuery(User.GET_All_USERS);
	}
	/*
	 * (non-Javadoc)
	 * @see org.seke.filmania.dao.UserDAO#getUser(java.lang.String)
	 */
	public User getUser(String username) {
		EntityManager manager = getJpaTemplate().getEntityManagerFactory().createEntityManager();
		return (User) manager.createNamedQuery(User.GET_USER_BY_USERNAME).setParameter("username", username).getSingleResult();
	}

	public void updateUser(User user){
		getJpaTemplate().merge(user);
	}
	

}
