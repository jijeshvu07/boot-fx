package com.jo.sndp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.OfficeBarrierDAO;
import com.jo.sndp.entity.OfficeBarrier;

@Repository("OfficeBarrierDAO")
public class OfficeBarrierDAOImpl extends GenericDAOImpl<OfficeBarrier, Long> implements OfficeBarrierDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<OfficeBarrier> findAllOfficeBarrier() {
		return getSession().createQuery("from OfficeBarrier where isDelete='false'").list();
	}

}
