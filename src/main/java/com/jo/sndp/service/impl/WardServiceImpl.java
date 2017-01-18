package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.WardDAO;
import com.jo.sndp.entity.Ward;
import com.jo.sndp.service.WardService;

@Service("WardService")
public class WardServiceImpl implements WardService {
	@Autowired
	private WardDAO wardDAO;

	@Override
	public void saveWard(Ward ward) {
		wardDAO.saveOrUpdate(ward);
	}

	@Override
	public List<Ward> findAllWard() {
		return wardDAO.findAllWards();
	}

	@Override
	public Ward findWardById(long id) {
		return wardDAO.findByPrimaryKey(id);
	}

	@Override
	public void deleteWard(long id) {
		Ward ward = findWardById(id);
		ward.setDelete(true);
		saveWard(ward);
	}

	@Override
	public List<Ward> findAllWardsByPanchayath(long panchayathId) {
		return wardDAO.findAllWardsByPanchayath(panchayathId);
	}

}
