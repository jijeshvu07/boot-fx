package com.jo.sndp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.RelationShipDAO;
import com.jo.sndp.entity.RelationShip;

/**
 * Created by JO on 4/30/2016.
 */
@Repository("RelationShipDAO")
public class RelationShipDAOImpl extends GenericDAOImpl<RelationShip,Long>implements RelationShipDAO {
    /**
	 * 
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<RelationShip> findAllRelationShip() {
        return getSession().createQuery("from RelationShip where isDelete='false'").list();
    }
}
