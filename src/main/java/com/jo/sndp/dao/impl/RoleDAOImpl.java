package com.jo.sndp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.DataAccessException;
import com.jo.sndp.dao.RoleDAO;
import com.jo.sndp.entity.Role;

@Repository("RoleDAO")
public class RoleDAOImpl extends GenericDAOImpl<Role, Long> implements RoleDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Role findUserByRoleName(String roleName) throws DataAccessException {
		return findByUniqueField("name", roleName);
	}

	@SuppressWarnings("unchecked")
	public List<Role> getAllRoless() throws DataAccessException {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Role where isDelete = 'false' ").list();
	}

}
