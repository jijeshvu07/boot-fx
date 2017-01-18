package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.District;

public interface DistrictService {
   public  void saveDistrict(District district);
   public List<District> findAllDistrict();
   public District findDistrictById(long id);
   public void deleteDistrict(long id);
   public List<District> findAllDistrictByStateName(String name);
}
