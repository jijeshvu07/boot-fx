package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.Gender;

public interface GenderDAO extends GenericDAO<Gender, Long> {
  public List<Gender>findAllGenders();
}
