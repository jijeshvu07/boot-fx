package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.MaritalStatus;

public interface MaritalStatusDAO extends GenericDAO<MaritalStatus, Long>{
  public List<MaritalStatus>findAllMaritalStatuses();
}
