package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jo.sndp.dao.MemberDAO;
import com.jo.sndp.entity.Member;
import com.jo.sndp.entity.MemeberDetails;
import com.jo.sndp.service.MemberDetailsService;
import com.jo.sndp.service.MemberService;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private MemberDetailsService memberDetailsService;

	@Override
	public void saveMember(Member member) {
		memberDAO.saveOrUpdate(member);
	}

	@Override
	public List<Member> findAllMembers() {
		return memberDAO.findAllMembers();
	}

	@Override
	public Member findMemberById(long id) {
		return memberDAO.findByPrimaryKey(id);
	}

	@Override
	public void deleteMember(long id) {
		Member member = findMemberById(id);
		member.setDelete(true);
		saveMember(member);
	}

	@Override
	public Member findMemberByMemberCode(String code) {
		return memberDAO.findMemberByMemberCode(code);
	}

	@Override
	@Transactional
	public void saveMember(Member member, List<MemeberDetails> details) {
		memberDAO.saveOrUpdate(member);
		memberDetailsService.saveAllMemeberDetails(details);
	}

}
