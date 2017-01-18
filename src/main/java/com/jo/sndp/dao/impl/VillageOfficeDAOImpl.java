package com.jo.sndp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.VillageOfficeDAO;
import com.jo.sndp.entity.VillageOffice;

/**
 * Created by JO on 4/30/2016.
 */
@Repository("VillageOfficeDAO")
public class VillageOfficeDAOImpl extends GenericDAOImpl<VillageOffice,Long>implements VillageOfficeDAO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<VillageOffice> findAllVillageOffice() {
        return getSession().createQuery("from VillageOffice where isDelete='false'").list();
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<VillageOffice> findAllVillageOfficeByDistrict(long districtId) {
		 return getSession().createQuery("from VillageOffice where isDelete='false' and district.id=:districtId")
				 .setParameter("districtId", districtId)
				 .list();
	}
}
