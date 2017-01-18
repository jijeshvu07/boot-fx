package com.jo.sndp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.FinanceStatusDAO;
import com.jo.sndp.entity.FinanceStatus;

@Repository("FinanceStatusDAO")
public class FinanceStatusDAOImpl extends GenericDAOImpl<FinanceStatus, Long> implements FinanceStatusDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<FinanceStatus> findAllFinanceStatuses() {
		return getSession().createQuery("from FinanceStatus where isDelete='false'").list();
	}

}
