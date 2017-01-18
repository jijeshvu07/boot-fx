package com.jo.sndp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.PostOfficeDAO;
import com.jo.sndp.entity.PostOffice;

/**
 * Created by JO on 4/30/2016.
 */

@Repository("PostOfficeDAO")
public class PostOfficeDAOImpl extends GenericDAOImpl<PostOffice, Long> implements PostOfficeDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<PostOffice> findAllPostOffice() {
		return getSession().createQuery("from PostOffice where isDelete='false'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PostOffice> findAllPostofficeByDistrictName(String districtName) {
		Session session = getSession();
		List<PostOffice> postOffices = session
				.createQuery("from PostOffice where isDelete='false' and district.districtName=:districtName")
				.setParameter("districtName", districtName).list();
		return postOffices;
	}

	@Override
	public PostOffice findPostOfficeByName(String name) {
		return (PostOffice) getSession()
				.createQuery("from PostOffice where isDelete='false' and postOfficeName=:postOfficeName")
				.setParameter("postOfficeName", name).uniqueResult();
	}
}
