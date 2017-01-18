package com.jo.sndp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.BloodGroupDAO;
import com.jo.sndp.entity.BloodGroup;

@Repository("BloodGroupDAO")
public class BloodGroupDAOImpl extends GenericDAOImpl<BloodGroup, Long> implements BloodGroupDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<BloodGroup> findAllBloodGroup() {
		return getSession().createQuery("from BloodGroup where isDelete='false'").list();
	}

}
