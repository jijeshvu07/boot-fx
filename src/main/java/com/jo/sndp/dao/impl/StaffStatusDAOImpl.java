package com.jo.sndp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.StaffStatusDAO;
import com.jo.sndp.entity.StaffStatus;

/**
 * Created by JO on 4/30/2016.
 */

@Repository("StaffStatusDAO")
public class StaffStatusDAOImpl extends GenericDAOImpl<StaffStatus,Long>implements StaffStatusDAO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<StaffStatus> findAllStaffStatus() {
        return getSession().createQuery("from StaffStatus where isDelete='false'").list();
    }
}
