package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.Member;

public interface MemberDAO extends GenericDAO<Member, Long>{
public List<Member>findAllMembers();
public Member findMemberByMemberCode(String code);
}
