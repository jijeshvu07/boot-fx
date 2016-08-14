package com.jo.sndp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.model.BloodGroup;
import com.jo.sndp.repository.BloodRepository;

@Service
public class BloodGroupServiceImpl implements BloodGroupService{
	@Autowired
	private BloodRepository  bloodRepository;

	@Override
	public Collection<BloodGroup> findAllBloodGroup() {
		return bloodRepository.findAll();
	}

}
