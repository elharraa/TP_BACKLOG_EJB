package com.backlog.dao.agency;

import java.util.List;

import javax.ejb.Local;

import com.backlog.model.User;

@Local
public interface UserDaoLocal {

	void addUser(User u);

	List<User> getAllUsers();

	User getUser(int id);

	User findByName(String userName);
}
