package com.jo.sndp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.DistrictDAO;
import com.jo.sndp.entity.District;

@Repository("DistrictDAO")
public class DistrictDAOImpl extends GenericDAOImpl<District, Long> implements DistrictDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<District> findAllDistricts() {
		return getSession().createQuery("from District where isDelete='false'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<District> findAllDistrictByStateName(String name) {
		Session session = getSession();
		List<District> districts = session
				.createQuery("from District where isDelete='false' and state.stateName=:stateName")
				.setParameter("stateName", name).list();
		return districts;
	}

}
