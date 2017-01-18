package com.jo.sndp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.EducationQualificationDAO;
import com.jo.sndp.entity.EducationQualification;

@Repository("EducationQualificationDAO")
public class EducationQualificationDAOImpl extends GenericDAOImpl<EducationQualification, Long>
		implements EducationQualificationDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<EducationQualification> findAllEducationQualifications() {
		return getSession().createQuery("from EducationQualification where isDelete='false'").list();
	}

}
