package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.PanchayathOffice;

public interface PanchayathOfficeService {
  public void savePanchayathOffice(PanchayathOffice panchayathOffice);
  public List<PanchayathOffice>findAllPanchayathOffice();
  public PanchayathOffice findPanchayathOfficeById(long id);
  public void deletePanchayathOffice(long id);
  public List<PanchayathOffice> findAllPanchayathOfficeByDistrict(long districtId);
}
