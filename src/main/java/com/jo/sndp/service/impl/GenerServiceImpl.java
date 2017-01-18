package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.GenderDAO;
import com.jo.sndp.entity.Gender;
import com.jo.sndp.service.GenderService;

@Service("GenderService")
public class GenerServiceImpl implements GenderService {

	@Autowired
	private GenderDAO genderDAO;

	@Override
	public void saveGender(Gender gender) {
		genderDAO.saveOrUpdate(gender);
	}

	@Override
	public List<Gender> findAllGender() {
		return genderDAO.findAllGenders();
	}

	@Override
	public Gender findGenderByid(long id) {
		return genderDAO.findByPrimaryKey(id);
	}

	@Override
	public void deleteGender(long id) {
		Gender gender = findGenderByid(id);
		gender.setDelete(true);
		saveGender(gender);
	}

}
