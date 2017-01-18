package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.DataAccessException;
import com.jo.sndp.dao.RoleDAO;
import com.jo.sndp.entity.Role;
import com.jo.sndp.service.BusinessLogicException;
import com.jo.sndp.service.RoleService;

@Service("RoleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
    private RoleDAO roleDAO;
    
	public List<Role> findAllRoles() throws BusinessLogicException {
		try {
			return roleDAO.getAllRoless();
		} catch (DataAccessException e) {
			throw new BusinessLogicException(
					"Exception thrown while finding Role "
							+ " using the " + roleDAO.getClass().getSimpleName(), e);
		}
	}

	public Role findUserByRoleName(String roleName) throws BusinessLogicException {
		
		try {
			return roleDAO.findUserByRoleName(roleName);
		} catch (DataAccessException e) {
			throw new BusinessLogicException(
					"Exception thrown while finding Role "
							+ " using the " + roleDAO.getClass().getSimpleName(), e);
		}
	}

}
