package org.seke.filmania.service.impl;

import java.util.List;

import org.seke.filmania.dao.RoleDAO;
import org.seke.filmania.domain.Role;
import org.seke.filmania.service.RoleService;

public class RoleServiceImpl implements RoleService {

	private RoleDAO roleDAO;

	public List<Role> retrieveAll() {
		return getRoleDAO().retrieveAll();
	}

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

}
