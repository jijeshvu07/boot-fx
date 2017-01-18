package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.Union;

public interface UnionService {
  public void saveUnion(Union union);
  public List<Union>findAllUnion();
  public Union findUnionById(long id);
  public void deleteUnion(long id);
  public Union findUnionByUnionName(String name);
  public Union findUnionByUnionCode(String code);
}
