package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.DistrictDAO;
import com.jo.sndp.entity.District;
import com.jo.sndp.service.DistrictService;

@Service("DistrictService")
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictDAO districtDAO;

	@Override
	public void saveDistrict(District district) {
		districtDAO.saveOrUpdate(district);
	}

	@Override
	public List<District> findAllDistrict() {
		return districtDAO.findAllDistricts();
	}

	@Override
	public District findDistrictById(long id) {
		return districtDAO.findByPrimaryKey(id);
	}

	@Override
	public void deleteDistrict(long id) {
		District district = findDistrictById(id);
		district.setDelete(true);
		saveDistrict(district);
	}

	@Override
	public List<District> findAllDistrictByStateName(String name) {
		return districtDAO.findAllDistrictByStateName(name);
	}

}
