package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.BloodGroup;

public interface BloodGroupDAO extends GenericDAO<BloodGroup, Long>{
  public List<BloodGroup>findAllBloodGroup();
}
