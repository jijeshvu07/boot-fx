package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.PanchayathOfficeDAO;
import com.jo.sndp.entity.PanchayathOffice;
import com.jo.sndp.service.PanchayathOfficeService;

@Service("PanchayathOfficeService")
public class PanchayathOfficeServiceImpl implements PanchayathOfficeService {

	@Autowired
	private PanchayathOfficeDAO panchayathOfficeDAO;
	
	@Override
	public void savePanchayathOffice(PanchayathOffice panchayathOffice) {
		panchayathOfficeDAO.saveOrUpdate(panchayathOffice);
	}

	@Override
	public List<PanchayathOffice> findAllPanchayathOffice() {
		return panchayathOfficeDAO.findAllPanchayathOffices();
	}

	@Override
	public PanchayathOffice findPanchayathOfficeById(long id) {
		return panchayathOfficeDAO.findByPrimaryKey(id);
	}

	@Override
	public void deletePanchayathOffice(long id) {
		PanchayathOffice office = findPanchayathOfficeById(id);
		office.setDelete(true);
		savePanchayathOffice(office);
	}

	@Override
	public List<PanchayathOffice> findAllPanchayathOfficeByDistrict(
			long districtId) {
		return panchayathOfficeDAO.findAllPanchayathOfficeByDistrict(districtId);
	}

}
