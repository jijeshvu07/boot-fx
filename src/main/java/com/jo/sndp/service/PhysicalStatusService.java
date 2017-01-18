package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.PhysicalStatus;

public interface PhysicalStatusService {
  public void savePhysicalStatus(PhysicalStatus physicalStatus);
  public List<PhysicalStatus>findAllPhysicalStatus();
  public PhysicalStatus findPhysicalStatusById(long id);
  public void deletePhysicalStatus(long id);
}
