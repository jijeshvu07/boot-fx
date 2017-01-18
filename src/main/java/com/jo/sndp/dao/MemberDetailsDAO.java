package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.MemeberDetails;

public interface MemberDetailsDAO extends GenericDAO<MemeberDetails, Long>{
  public List<MemeberDetails> findAllMemeberDetailsByMemberId(long id);
  public MemeberDetails findMemeberDetailsByMemberCode(String code);
}
