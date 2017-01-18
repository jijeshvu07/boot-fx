package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.Gender;

public interface GenderService {
	public void saveGender(Gender gender);

	public List<Gender> findAllGender();

	public Gender findGenderByid(long id);

	public void deleteGender(long id);
}
