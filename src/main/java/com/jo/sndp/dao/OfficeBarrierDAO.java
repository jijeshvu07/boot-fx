package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.OfficeBarrier;

public interface OfficeBarrierDAO extends GenericDAO<OfficeBarrier, Long>{
  public List<OfficeBarrier> findAllOfficeBarrier();
}
