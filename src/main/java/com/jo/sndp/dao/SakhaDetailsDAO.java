package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.SakhaDetails;

public interface SakhaDetailsDAO extends GenericDAO<SakhaDetails, Long> {
  public List<SakhaDetails>findAllSakhaDetails();
  public SakhaDetails findSakhaDetailsBySakhaName(String name);
  public SakhaDetails findSakhaDetailsBySakhaCode(String code);
  public List<SakhaDetails> findAllSakhaDetailsByUnion(long unionid);
}
