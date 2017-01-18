package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.VillageOfficeDAO;
import com.jo.sndp.entity.VillageOffice;
import com.jo.sndp.service.VillageOfficeService;

@Service("VillageOfficeService")
public class VillageOfficeServiceImpl implements VillageOfficeService {
	@Autowired
	private VillageOfficeDAO villageOfficeDAO;

	@Override
	public void saveVillageOffice(VillageOffice villageOffice) {
		villageOfficeDAO.saveOrUpdate(villageOffice);
	}

	@Override
	public List<VillageOffice> findAllVillageOffice() {
		return villageOfficeDAO.findAllVillageOffice();
	}

	@Override
	public VillageOffice findVillageOfficeById(long id) {
		return villageOfficeDAO.findByPrimaryKey(id);
	}

	@Override
	public void deleteVillageOffice(long id) {
		VillageOffice office = findVillageOfficeById(id);
		office.setDelete(true);
		saveVillageOffice(office);
	}

	@Override
	public List<VillageOffice> findAllVillageOfficeByDistrict(long districtId) {
		return villageOfficeDAO.findAllVillageOfficeByDistrict(districtId);
	}

}
