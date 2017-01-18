package com.jo.sndp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.PanchayathOfficeDAO;
import com.jo.sndp.entity.PanchayathOffice;

@Repository("PanchayathOfficeDAO")
public class PanchayathOfficeDAOImpl extends GenericDAOImpl<PanchayathOffice, Long> implements PanchayathOfficeDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<PanchayathOffice> findAllPanchayathOffices() {
		return getSession().createQuery("from PanchayathOffice where isDelete='false'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PanchayathOffice> findAllPanchayathOfficeByDistrict(long districtId) {
		return getSession().createQuery("from PanchayathOffice where isDelete='false' and district.id=:districtId")
				.setParameter("districtId", districtId)
				.list();
	}

}
