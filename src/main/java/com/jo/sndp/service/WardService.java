package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.Ward;

public interface WardService {
 public void saveWard(Ward ward);
 public List<Ward>findAllWard();
 public Ward findWardById(long id);
 public void deleteWard(long id);
 public List<Ward> findAllWardsByPanchayath(long panchayathId);
}
