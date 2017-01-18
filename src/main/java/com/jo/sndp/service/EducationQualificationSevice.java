package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.EducationQualification;

public interface EducationQualificationSevice {
  public void saveEducationQualification(EducationQualification educationQualification);
  public List<EducationQualification>findAllEducationQualification();
  public EducationQualification findEducationQualificationById(long id);
  public void deleteEducationQualification(long id);
}
