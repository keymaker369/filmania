package org.seke.filmania.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.seke.filmania.dao.UserDAO;
import org.seke.filmania.domain.User;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author nenad.seke
 * 
 */
@Repository(value = "userDAO")
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.dao.UserDAO#create(org.seke.filmania.domain.User)
	 */
	public void create(User user) {
		em.persist(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.dao.UserDAO#getUser(int)
	 */
	public User getUser(Long id) {
		return (User) em.createNamedQuery(User.GET_USER_BY_ID).setParameter("id", id).getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.dao.UserDAO#getAllUsers()
	 */
	public List<User> getAllUsers() {
		//return getJpaTemplate().findByNamedQuery(User.GET_All_USERS);
		return em.createNamedQuery(User.GET_All_USERS).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.dao.UserDAO#getUser(java.lang.String)
	 */
	public User getUser(String username) {

		Query query = em.createNamedQuery(User.GET_USER_BY_USERNAME).setParameter("username", username);
		query.setMaxResults(1);
		List resultList = query.getResultList();
		if (resultList != null && !resultList.isEmpty()) {
			return (User) resultList.get(0);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.seke.filmania.dao.UserDAO#updateUser(org.seke.filmania.domain.User)
	 */
	public void updateUser(User user) {
		em.merge(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seke.filmania.dao.UserDAO#deleteUser(java.lang.String)
	 */
	public void deleteUser(String username) {
		User user = (User) em.createNamedQuery(User.GET_USER_BY_USERNAME).setParameter("username", username).getSingleResult();
		user = em.find(User.class, user.getId());
		em.remove(user);
	}

}
