package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.MemberDetailsDAO;
import com.jo.sndp.entity.MemeberDetails;
import com.jo.sndp.service.MemberDetailsService;

@Service("MemberDetailsService")
public class MemberDetailsServiceImpl implements MemberDetailsService{
    @Autowired
	private MemberDetailsDAO memberDetailsDAO;
	
	@Override
	public void saveMemberDetails(MemeberDetails memeberDetails) {
		memberDetailsDAO.saveOrUpdate(memeberDetails);
	}

	@Override
	public List<MemeberDetails> findAllMemberDetailsByMemberId(long id) {
		return memberDetailsDAO.findAllMemeberDetailsByMemberId(id);
	}

	@Override
	public MemeberDetails findMemeberDetailsById(long id) {
		return memberDetailsDAO.findByPrimaryKey(id);
	}

	@Override
	public void deleteMemeberDetails(long id) {
		MemeberDetails details = findMemeberDetailsById(id);
		details.setDelete(true);
		saveMemberDetails(details);
	}

	@Override
	public MemeberDetails findMemeberDetailsByMemberCode(String code) {
		return memberDetailsDAO.findMemeberDetailsByMemberCode(code);
	}

	@Override
	public void saveAllMemeberDetails(List<MemeberDetails> details) {
		memberDetailsDAO.saveOrUpdateAll(details);		
	}

}
