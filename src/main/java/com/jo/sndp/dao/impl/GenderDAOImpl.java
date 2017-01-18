package com.jo.sndp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.GenderDAO;
import com.jo.sndp.entity.Gender;

@Repository("GenderDAO")
public class GenderDAOImpl extends GenericDAOImpl<Gender, Long> implements GenderDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<Gender> findAllGenders() {
		return getSession().createQuery("from Gender where isDelete='false'").list();
	}

}
