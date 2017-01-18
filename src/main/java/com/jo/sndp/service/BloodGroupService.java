package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.BloodGroup;

public interface BloodGroupService {
  public void saveBloodGroup(BloodGroup bloodGroup);
  public List<BloodGroup>findAllBloodGroup();
  public BloodGroup findBloodGroupById(long id);
  public void deleteBloodGroup(long id);
}
