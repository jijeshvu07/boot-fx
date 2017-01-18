package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.FinanceStatusDAO;
import com.jo.sndp.entity.FinanceStatus;
import com.jo.sndp.service.FinanceStatusService;

@Service("FinanceStatusService")
public class FinanceStatusServiceImpl implements FinanceStatusService {

	@Autowired
	private FinanceStatusDAO financeStatusDAO;
	@Override
	public void saveFinanceStatus(FinanceStatus financeStatus) {
		financeStatusDAO.saveOrUpdate(financeStatus);
	}

	@Override
	public List<FinanceStatus> findAllFinanceStatus() {
		return financeStatusDAO.findAllFinanceStatuses();
	}

	@Override
	public FinanceStatus finFinanceStatusById(long id) {
		return financeStatusDAO.findByPrimaryKey(id);
	}

	@Override
	public void deleteFinanceStatusById(long id) {
		FinanceStatus status = finFinanceStatusById(id);
		status.setDelete(true);
		saveFinanceStatus(status);
	}

}
