package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.PhysicalStatusDAO;
import com.jo.sndp.entity.PhysicalStatus;
import com.jo.sndp.service.PhysicalStatusService;

@Service("PhysicalStatusService")
public class PhysicalStatusServiceImpl implements PhysicalStatusService {
   @Autowired
	private PhysicalStatusDAO physicalStatusDAO;
	
	@Override
	public void savePhysicalStatus(PhysicalStatus physicalStatus) {
		physicalStatusDAO.saveOrUpdate(physicalStatus);
	}

	@Override
	public List<PhysicalStatus> findAllPhysicalStatus() {
		return physicalStatusDAO.findAllPhysicalStatus();
	}

	@Override
	public PhysicalStatus findPhysicalStatusById(long id) {
		return physicalStatusDAO.findByPrimaryKey(id);
	}

	@Override
	public void deletePhysicalStatus(long id) {
		PhysicalStatus physicalStatus = findPhysicalStatusById(id);
		physicalStatus.setDelete(true);
		savePhysicalStatus(physicalStatus);
	}

}
