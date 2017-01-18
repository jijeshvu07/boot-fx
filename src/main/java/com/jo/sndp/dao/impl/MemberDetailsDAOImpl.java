package com.jo.sndp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.MemberDetailsDAO;
import com.jo.sndp.entity.MemeberDetails;

@Repository("MemberDetailsDAO")
public class MemberDetailsDAOImpl extends GenericDAOImpl<MemeberDetails, Long> implements MemberDetailsDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<MemeberDetails> findAllMemeberDetailsByMemberId(long id) {
		Session session = getSession();
		List<MemeberDetails> memeberDetails = session
				.createQuery("from MemeberDetails where isDelete='false' and member.id=:memberId")
				.setParameter("memberId", id).list();
		return memeberDetails;
	}

	@Override
	public MemeberDetails findMemeberDetailsByMemberCode(String code) {
		Session session = getSession();
		MemeberDetails details = (MemeberDetails) session
				.createQuery("from MemeberDetails where isDelete='false' and memberCode=:memberCode")
				.setParameter("memberCode", code).setMaxResults(1).uniqueResult();
		return details;
	}

}
