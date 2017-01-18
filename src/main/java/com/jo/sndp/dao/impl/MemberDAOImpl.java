package com.jo.sndp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.MemberDAO;
import com.jo.sndp.entity.Member;

@Repository("MemberDAO")
public class MemberDAOImpl extends GenericDAOImpl<Member, Long> implements MemberDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> findAllMembers() {
		return getSession().createQuery("from Member where isDelete='false'").list();
	}

	@Override
	public Member findMemberByMemberCode(String code) {
		Session session = getSession();
		Member member = (Member) session.createQuery("from Member where isDelete='false' and memeberCode=:memeberCode")
				.setParameter("memeberCode", code).setMaxResults(1).uniqueResult();
		return member;
	}

}
