package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.SakhaDetailsDAO;
import com.jo.sndp.entity.SakhaDetails;
import com.jo.sndp.service.SakhaDetailsService;

@Service("SakhaDetailsService")
public class SakhaDetailsServiceImpl implements SakhaDetailsService {
	@Autowired
	private SakhaDetailsDAO sakhaDetailsDAO;

	@Override
	public void saveSakhaDetails(SakhaDetails sakhaDetails) {
		sakhaDetailsDAO.saveOrUpdate(sakhaDetails);
	}

	@Override
	public List<SakhaDetails> findAllSakhaDetails() {
		return sakhaDetailsDAO.findAllSakhaDetails();
	}

	@Override
	public SakhaDetails findSakhaDetailsById(long id) {
		return sakhaDetailsDAO.findByPrimaryKey(id);
	}

	@Override
	public void deleteSakhaDetails(long id) {
		SakhaDetails details = findSakhaDetailsById(id);
		details.setDelete(true);
		saveSakhaDetails(details);
	}

	@Override
	public SakhaDetails findSakhaDetailsBySakhaName(String name) {
		return sakhaDetailsDAO.findSakhaDetailsBySakhaName(name);
	}

	@Override
	public SakhaDetails findSakhaDetailsBySakhaCode(String code) {
		return sakhaDetailsDAO.findSakhaDetailsBySakhaCode(code);
	}

	@Override
	public List<SakhaDetails> findAllSakhaDetailsByUnion(long unionid) {
		return sakhaDetailsDAO.findAllSakhaDetailsByUnion(unionid);
	}

}
