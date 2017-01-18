package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.Ward;

public interface WardDAO extends GenericDAO<Ward, Long> {
  public List<Ward>findAllWards();
  public List<Ward>findAllWardsByPanchayath(long panchayathId);
}
