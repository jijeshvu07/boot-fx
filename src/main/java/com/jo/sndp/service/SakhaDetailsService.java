package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.SakhaDetails;

public interface SakhaDetailsService {
  public void saveSakhaDetails(SakhaDetails sakhaDetails);
  public List<SakhaDetails>findAllSakhaDetails();
  public SakhaDetails findSakhaDetailsById(long id);
  public void deleteSakhaDetails(long id);
  public SakhaDetails findSakhaDetailsBySakhaName(String name);
  public SakhaDetails findSakhaDetailsBySakhaCode(String code);
  public List<SakhaDetails> findAllSakhaDetailsByUnion(long unionid);
}
