package com.jo.sndp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.SakhaDetailsDAO;
import com.jo.sndp.entity.SakhaDetails;

/**
 * Created by JO on 4/30/2016.
 */
@Repository("SakhaDetailsDAO")
public class SakhaDetailsDAOImpl extends GenericDAOImpl<SakhaDetails, Long> implements SakhaDetailsDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<SakhaDetails> findAllSakhaDetails() {
		return getSession().createQuery("from SakhaDetails where isDelete='false'").list();
	}

	@Override
	public SakhaDetails findSakhaDetailsBySakhaName(String name) {
		SakhaDetails details = (SakhaDetails) getSession()
				.createQuery("from SakhaDetails where isDelete='false' and sakhaName=:sakhaName")
				.setParameter("sakhaName", name).uniqueResult();
		return details;
	}

	@Override
	public SakhaDetails findSakhaDetailsBySakhaCode(String code) {
		SakhaDetails details = (SakhaDetails) getSession()
				.createQuery("from SakhaDetails where isDelete='false' and sakhaCode=:sakhaCode")
				.setParameter("sakhaCode", code).uniqueResult();
		return details;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SakhaDetails> findAllSakhaDetailsByUnion(long unionid) {
		return getSession().createQuery("from SakhaDetails where isDelete='false' and union1.id=:unionId")
				.setParameter("unionId", unionid).list();
	}
}
