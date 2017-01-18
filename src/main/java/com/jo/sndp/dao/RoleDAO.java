package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.Role;

public interface RoleDAO extends GenericDAO<Role, Long> {

	Role findUserByRoleName(String roleName) throws DataAccessException;

	List<Role> getAllRoless() throws DataAccessException;

}