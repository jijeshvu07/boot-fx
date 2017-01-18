package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.MaritalStatus;

public interface MaritalStatusService {
  public void saveMaritalStatus(MaritalStatus maritalStatus);
  public List<MaritalStatus>findAllMaritalStatus();
  public MaritalStatus findMaritalStatusById(long id);
  public void deleteMaritalStatus(long id);
}
