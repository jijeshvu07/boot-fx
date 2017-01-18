package com.jo.sndp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.PhysicalStatusDAO;
import com.jo.sndp.entity.PhysicalStatus;

@Repository("PhysicalStatusDAO")
public class PhysicalStatusDAOImpl extends GenericDAOImpl<PhysicalStatus, Long>implements PhysicalStatusDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<PhysicalStatus> findAllPhysicalStatus() {
		return getSession().createQuery("from PhysicalStatus where isDelete='false'").list();
	}

}
