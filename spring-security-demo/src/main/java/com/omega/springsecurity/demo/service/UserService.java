package com.omega.springsecurity.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.omega.springsecurity.demo.entity.User;
import com.omega.springsecurity.demo.user.CrmUser;

public interface UserService extends UserDetailsService {

	User findByUserName(String userName);

	void save(CrmUser crmUser);
}
