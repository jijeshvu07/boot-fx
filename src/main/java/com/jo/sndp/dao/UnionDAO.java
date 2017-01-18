package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.Union;

public interface UnionDAO extends GenericDAO<Union, Long> {
  public List<Union>findAllUnions();
  public Union findUnionByUnionName(String name);
  public Union findUnionByUnionCode(String code);
}
