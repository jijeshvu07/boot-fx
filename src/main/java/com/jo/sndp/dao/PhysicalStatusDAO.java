package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.PhysicalStatus;

public interface PhysicalStatusDAO extends GenericDAO<PhysicalStatus, Long> {
  public List<PhysicalStatus>findAllPhysicalStatus();
}
