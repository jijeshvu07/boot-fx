package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.District;

public interface DistrictDAO extends GenericDAO<District, Long>{
   public List<District>findAllDistricts();
   public List<District> findAllDistrictByStateName(String name);
}
