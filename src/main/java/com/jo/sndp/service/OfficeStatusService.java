package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.OfficeStatus;

public interface OfficeStatusService {
  public void saveOfficeStatus(OfficeStatus officeStatus);
  public List<OfficeStatus>findAllOfficeStatus();
  public OfficeStatus findOfficeStatusById(long id);
  public void deleteOfficeStatus(long id);
}
