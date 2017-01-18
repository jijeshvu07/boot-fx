package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.MaritalStatusDAO;
import com.jo.sndp.entity.MaritalStatus;
import com.jo.sndp.service.MaritalStatusService;

@Service("MaritalStatusService")
public class MaritalStatusServiceImpl implements MaritalStatusService {

	@Autowired
	private MaritalStatusDAO maritalStatusDAO;
	@Override
	public void saveMaritalStatus(MaritalStatus maritalStatus) {
		maritalStatusDAO.saveOrUpdate(maritalStatus);
	}

	@Override
	public List<MaritalStatus> findAllMaritalStatus() {
		return maritalStatusDAO.findAllMaritalStatuses();
	}

	@Override
	public MaritalStatus findMaritalStatusById(long id) {
		return maritalStatusDAO.findByPrimaryKey(id);
	}

	@Override
	public void deleteMaritalStatus(long id) {
		MaritalStatus status = findMaritalStatusById(id);
		status.setDelete(true);
		saveMaritalStatus(status);
	}

}
