package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.BloodGroupDAO;
import com.jo.sndp.entity.BloodGroup;
import com.jo.sndp.service.BloodGroupService;

@Service("BloodGroupService")
public class BloodGroupServiceImpl implements BloodGroupService {
	@Autowired
	private BloodGroupDAO bloodGroupDAO;

	@Override
	public void saveBloodGroup(BloodGroup bloodGroup) {
		bloodGroupDAO.saveOrUpdate(bloodGroup);
	}

	@Override
	public List<BloodGroup> findAllBloodGroup() {
		return bloodGroupDAO.findAllBloodGroup();
	}

	@Override
	public BloodGroup findBloodGroupById(long id) {
		return bloodGroupDAO.findByPrimaryKey(id);
	}

	@Override
	public void deleteBloodGroup(long id) {
		BloodGroup group = findBloodGroupById(id);
		group.setDelete(true);
		saveBloodGroup(group);
	}

}
