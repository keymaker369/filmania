package org.seke.filmania.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.seke.filmania.dao.UserDAO;
import org.seke.filmania.domain.User;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;

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
	public User getUser(Long id) {
		EntityManager manager = getJpaTemplate().getEntityManagerFactory().createEntityManager();
		return (User) manager.createNamedQuery(User.GET_USER_BY_ID).setParameter("id", id).getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.dao.UserDAO#getAllUsers()
	 */
	public List<User> getAllUsers() {
		EntityManager manager = getJpaTemplate().getEntityManagerFactory().createEntityManager();
		return getJpaTemplate().findByNamedQuery(User.GET_All_USERS);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.dao.UserDAO#getUser(java.lang.String)
	 */
	public User getUser(String username) {
		EntityManager manager = getJpaTemplate().getEntityManagerFactory().createEntityManager();
		return (User) manager.createNamedQuery(User.GET_USER_BY_USERNAME).setParameter("username", username).getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.seke.filmania.dao.UserDAO#updateUser(org.seke.filmania.domain.User)
	 */
	public void updateUser(User user) {
		getJpaTemplate().merge(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.dao.UserDAO#deleteUser(java.lang.String)
	 */
	public void deleteUser(String username) {
		EntityManager manager = getJpaTemplate().getEntityManagerFactory().createEntityManager();
		User user = (User)manager.createNamedQuery(User.GET_USER_BY_USERNAME).setParameter("username", username).getSingleResult();
		user = getJpaTemplate().find(User.class, user.getId());
		getJpaTemplate().remove(user);
	}

	
	
}
