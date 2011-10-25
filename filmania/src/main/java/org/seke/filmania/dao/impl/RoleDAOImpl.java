package org.seke.filmania.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.seke.filmania.dao.RoleDAO;
import org.seke.filmania.domain.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "roleDAO")
public class RoleDAOImpl implements RoleDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Role saveRole(Role role) {
		if (role.getId() == null)
			em.persist(role);
		else
			em.merge(role);
		return role;
	}

	public List<Role> retrieveAll() {
		return em.createNamedQuery("from Role").getResultList();
	}

	
}
