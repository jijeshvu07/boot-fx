package com.jo.sndp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.OfficeStatusDAO;
import com.jo.sndp.entity.OfficeStatus;

@Repository("OfficeStatusDAO")
public class OfficeStatusDAOImpl extends GenericDAOImpl<OfficeStatus, Long>implements OfficeStatusDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<OfficeStatus> findAllOfficeStatuses() {
		return getSession().createQuery("from OfficeStatus where isDelete='false'").list();
	}

}
