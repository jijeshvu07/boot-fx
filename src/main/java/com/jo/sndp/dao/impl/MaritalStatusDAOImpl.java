package com.jo.sndp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.MaritalStatusDAO;
import com.jo.sndp.entity.MaritalStatus;

@Repository("MaritalStatusDAO")
public class MaritalStatusDAOImpl extends GenericDAOImpl<MaritalStatus, Long> implements MaritalStatusDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<MaritalStatus> findAllMaritalStatuses() {
		return getSession().createQuery("from MaritalStatus where isDelete='false'").list();
	}

}
