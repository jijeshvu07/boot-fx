package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.Designation;

public interface DesignationDAO extends GenericDAO<Designation, Long>{
   public List<Designation> findAllDesignations();
   public Designation findDesignationByName(String name);
}
