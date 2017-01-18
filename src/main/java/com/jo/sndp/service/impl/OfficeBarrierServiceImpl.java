package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.OfficeBarrierDAO;
import com.jo.sndp.entity.OfficeBarrier;
import com.jo.sndp.service.OfficeBarrierService;

@Service("OfficeBarrierService")
public class OfficeBarrierServiceImpl implements OfficeBarrierService {
	@Autowired
	private OfficeBarrierDAO officeBarrierDAO;

	@Override
	public List<OfficeBarrier> findAllOfficeBarrier() {
		return officeBarrierDAO.findAllOfficeBarrier();
	}

	@Override
	public void saveOfficeBarrier(OfficeBarrier barrier) {
		officeBarrierDAO.saveOrUpdate(barrier);
	}

	@Override
	public OfficeBarrier findOfficeBarrierById(long id) {
		return officeBarrierDAO.findByPrimaryKey(id);
	}

	@Override
	public void deleteOfficeBarrier(long id) {
		OfficeBarrier barrier = findOfficeBarrierById(id);
		barrier.setDelete(true);
		saveOfficeBarrier(barrier);
	}

}
