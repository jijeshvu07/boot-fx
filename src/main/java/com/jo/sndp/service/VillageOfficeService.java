package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.VillageOffice;

public interface VillageOfficeService {
  public void saveVillageOffice(VillageOffice villageOffice);
  public List<VillageOffice>findAllVillageOffice();
  public VillageOffice findVillageOfficeById(long id);
  public void deleteVillageOffice(long id);
  public List<VillageOffice> findAllVillageOfficeByDistrict(long districtId);
}
