package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.DesignationDAO;
import com.jo.sndp.entity.Designation;
import com.jo.sndp.service.DesignationService;

@Service("DesignationService")
public class DesignationServiceImpl implements DesignationService{
    @Autowired
	private DesignationDAO designationDAO;
	
	public void saveDesignation(Designation designation) {
		designationDAO.saveOrUpdate(designation);		
	}

	public List<Designation> findAllDesignations() {
		return designationDAO.findAllDesignations();
	}

	public Designation findDesignationById(long id) {
		return designationDAO.findByPrimaryKey(id);
	}

	@Override
	public Designation findDesignationByName(String name) {
		return designationDAO.findDesignationByName(name);
	}

}
