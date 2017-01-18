package com.jo.sndp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.WardDAO;
import com.jo.sndp.entity.Ward;

/**
 * Created by JO on 4/30/2016.
 */

@Repository("WardDAO")
public class WardDAOImpl extends GenericDAOImpl<Ward, Long> implements WardDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<Ward> findAllWards() {
		return getSession().createQuery("from Ward where isDelete='false'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ward> findAllWardsByPanchayath(long panchayathId) {
		return getSession().createQuery("from Ward where isDelete='false' and panchayathOffice.id=:panchayathId")
				.setParameter("panchayathId", panchayathId)
				.list();
	}
}
