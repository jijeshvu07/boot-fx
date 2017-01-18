package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.EducationQualification;

public interface EducationQualificationDAO extends GenericDAO<EducationQualification, Long>{
  List<EducationQualification>findAllEducationQualifications();
}
