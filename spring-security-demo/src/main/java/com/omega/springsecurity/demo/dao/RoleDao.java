package com.omega.springsecurity.demo.dao;

import com.omega.springsecurity.demo.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);

}
