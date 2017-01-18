package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.Member;
import com.jo.sndp.entity.MemeberDetails;

public interface MemberService {
  public void saveMember(Member member);
  public List<Member> findAllMembers();
  public Member findMemberById(long id);
  public void deleteMember(long id);
  public Member findMemberByMemberCode(String code);
  public void saveMember(Member member,List<MemeberDetails> details);
}
