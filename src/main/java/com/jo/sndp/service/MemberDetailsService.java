package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.MemeberDetails;

public interface MemberDetailsService {
	public void saveMemberDetails(MemeberDetails memeberDetails);

	public List<MemeberDetails> findAllMemberDetailsByMemberId(long id);

	public MemeberDetails findMemeberDetailsById(long id);

	public void deleteMemeberDetails(long id);

	public MemeberDetails findMemeberDetailsByMemberCode(String code);

	public void saveAllMemeberDetails(List<MemeberDetails> details);
}
