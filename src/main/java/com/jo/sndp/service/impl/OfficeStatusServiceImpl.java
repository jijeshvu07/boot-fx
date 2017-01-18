package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.OfficeStatusDAO;
import com.jo.sndp.entity.OfficeStatus;
import com.jo.sndp.service.OfficeStatusService;

@Service("OfficeStatusService")
public class OfficeStatusServiceImpl implements OfficeStatusService {
    @Autowired
	private OfficeStatusDAO  officeStatusDAO;
	@Override
	public void saveOfficeStatus(OfficeStatus officeStatus) {
		officeStatusDAO.saveOrUpdate(officeStatus);
	}

	@Override
	public List<OfficeStatus> findAllOfficeStatus() {
		return officeStatusDAO.findAllOfficeStatuses();
	}

	@Override
	public OfficeStatus findOfficeStatusById(long id) {
		return officeStatusDAO.findByPrimaryKey(id);
	}

	@Override
	public void deleteOfficeStatus(long id) {
		OfficeStatus status = findOfficeStatusById(id);
		status.setDelete(true);
		saveOfficeStatus(status);
	}

}
