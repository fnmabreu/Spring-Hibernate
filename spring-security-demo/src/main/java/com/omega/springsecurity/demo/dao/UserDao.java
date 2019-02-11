package com.omega.springsecurity.demo.dao;

import com.omega.springsecurity.demo.entity.User;

public interface UserDao {

	User findByUserName(String userName);

	void save(User user);
}
