package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.OfficeBarrier;

public interface OfficeBarrierService {
	public List<OfficeBarrier> findAllOfficeBarrier();
	public void saveOfficeBarrier(OfficeBarrier barrier);
	public OfficeBarrier findOfficeBarrierById(long id);
	public void deleteOfficeBarrier(long id);
}
