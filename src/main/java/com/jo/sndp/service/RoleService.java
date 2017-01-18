package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.Role;


public interface RoleService {
	
	public List<Role> findAllRoles() throws BusinessLogicException;;
    
    public Role findUserByRoleName(String roleName) throws BusinessLogicException;
    
}
