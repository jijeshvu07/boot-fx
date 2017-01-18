package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.StaffStatus;

public interface StaffStatusService {
  public void saveStaffStaus(StaffStatus staffStatus);
  public  List<StaffStatus>findAllStaffStatus();
  public StaffStatus findStaffStatusById(long id);
  public void deleteStaffStatus(long id);
}
