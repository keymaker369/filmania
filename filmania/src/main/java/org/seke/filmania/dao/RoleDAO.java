package org.seke.filmania.dao;

import java.util.List;

import org.seke.filmania.domain.Role;

public interface RoleDAO {
	
	public Role saveRole(Role role);
	
	public List<Role> retrieveAll();
}