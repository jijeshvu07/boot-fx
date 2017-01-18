package com.jo.sndp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.UnionDAO;
import com.jo.sndp.entity.Union;

/**
 * Created by JO on 4/30/2016.
 */

@Repository("UnionDAO")
public class UnionDAOImpl extends GenericDAOImpl<Union, Long> implements UnionDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@SuppressWarnings("unchecked")
	public List<Union> findAllUnions() {
		return getSession().createQuery("from Union where isDelete='false'").list();
	}

	@Override
	public Union findUnionByUnionName(String name) {
		Session session = getSession();
		Union union = (Union) session.createQuery("from Union where isDelete='false' and unionName=:unionName")
				.setParameter("unionName", name).uniqueResult();
		return union;
	}

	@Override
	public Union findUnionByUnionCode(String code) {
		Session session = getSession();
		Union union = (Union) session.createQuery("from Union where isDelete='false' and unionCode=:unionCode")
				.setParameter("unionCode", code).uniqueResult();
		return union;
	}
}
