package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.EducationQualificationDAO;
import com.jo.sndp.entity.EducationQualification;
import com.jo.sndp.service.EducationQualificationSevice;

@Service("EducationQualificationSevice")
public class EducationQualificationSeviceImpl implements EducationQualificationSevice {
    @Autowired
	private EducationQualificationDAO educationQualificationDAO;
	@Override
	public void saveEducationQualification(EducationQualification educationQualification) {
		educationQualificationDAO.saveOrUpdate(educationQualification);
	}

	@Override
	public List<EducationQualification> findAllEducationQualification() {
		return educationQualificationDAO.findAllEducationQualifications();
	}

	@Override
	public EducationQualification findEducationQualificationById(long id) {
		return educationQualificationDAO.findByPrimaryKey(id);
	}

	@Override
	public void deleteEducationQualification(long id) {
		EducationQualification qualification = findEducationQualificationById(id);
		qualification.setDelete(true);
		saveEducationQualification(qualification);
	}

}
