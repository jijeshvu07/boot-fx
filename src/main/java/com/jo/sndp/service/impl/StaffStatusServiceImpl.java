package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.StaffStatusDAO;
import com.jo.sndp.entity.StaffStatus;
import com.jo.sndp.service.StaffStatusService;

@Service("StaffStatusService")
public class StaffStatusServiceImpl implements StaffStatusService {
	@Autowired
	private StaffStatusDAO staffStatusDAO;

	@Override
	public void saveStaffStaus(StaffStatus staffStatus) {
		staffStatusDAO.saveOrUpdate(staffStatus);
	}

	@Override
	public List<StaffStatus> findAllStaffStatus() {
		return staffStatusDAO.findAllStaffStatus();
	}

	@Override
	public StaffStatus findStaffStatusById(long id) {
		return staffStatusDAO.findByPrimaryKey(id);
	}

	@Override
	public void deleteStaffStatus(long id) {
		StaffStatus status = findStaffStatusById(id);
		status.setDelete(true);
		saveStaffStaus(status);
	}

}
