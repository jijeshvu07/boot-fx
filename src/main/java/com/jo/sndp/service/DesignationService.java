package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.Designation;

public interface DesignationService {
	void saveDesignation(Designation designation);

	List<Designation> findAllDesignations();

	Designation findDesignationById(long id);
	
	Designation findDesignationByName(String name);
}
