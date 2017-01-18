package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.VillageOffice;

public interface VillageOfficeDAO extends GenericDAO<VillageOffice, Long> {
  public List<VillageOffice>findAllVillageOffice();
  public List<VillageOffice>findAllVillageOfficeByDistrict(long districtId);
}
