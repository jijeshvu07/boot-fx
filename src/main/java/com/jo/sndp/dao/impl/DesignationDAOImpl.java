package com.jo.sndp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.DesignationDAO;
import com.jo.sndp.entity.Designation;

@Repository("DesignationDAO")
public class DesignationDAOImpl extends GenericDAOImpl<Designation, Long> implements DesignationDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<Designation> findAllDesignations() {
		return getSession().createQuery("from Designation where isDelete='false' ").list();
	}

	@Override
	public Designation findDesignationByName(String name) {
		Session session = getSession();
		Designation designation = (Designation) session
				.createQuery("from Designation where designationName=:designationName and isDelete='false'")
				.setParameter("designationName", name).setMaxResults(1).uniqueResult();
		return designation;
	}

}
