package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.StaffStatus;

public interface StaffStatusDAO extends GenericDAO<StaffStatus, Long> {
  public List<StaffStatus>findAllStaffStatus();
}
