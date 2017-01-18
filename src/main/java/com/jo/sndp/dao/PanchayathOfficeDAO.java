package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.PanchayathOffice;

public interface PanchayathOfficeDAO extends GenericDAO<PanchayathOffice, Long> {
  public List<PanchayathOffice>findAllPanchayathOffices();
  public List<PanchayathOffice>findAllPanchayathOfficeByDistrict(long districtId);
}
