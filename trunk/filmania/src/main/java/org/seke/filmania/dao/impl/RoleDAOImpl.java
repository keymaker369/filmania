package org.seke.filmania.dao.impl;

import java.util.List;

import org.seke.filmania.dao.RoleDAO;
import org.seke.filmania.domain.Role;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class RoleDAOImpl extends JpaDaoSupport implements RoleDAO {

	@Transactional
	public Role saveRole(Role role) {
		if (role.getId() == null)
			getJpaTemplate().persist(role);
		else
			getJpaTemplate().merge(role);
		return role;
	}

	public List<Role> retrieveAll() {
		return getJpaTemplate().find("from Role");
	}

	
}
