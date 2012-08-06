package org.seke.filmania.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.seke.filmania.domain.User;

public class UserDaolMockImpl implements UserDAO {

	HashMap<Long, User> users = new HashMap<Long, User>();
	
	@Override
	public void create(User user) {
		users.put(user.getId(), user);
	}

	@Override
	public User getUser(Long id) {
		return users.get(id);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> lista = new ArrayList<User>();
		for (User user : users.values()) {
			lista.add(user);
		}
		return lista;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub

	}

}
