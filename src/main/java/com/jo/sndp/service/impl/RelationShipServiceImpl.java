package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.RelationShipDAO;
import com.jo.sndp.entity.RelationShip;
import com.jo.sndp.service.RelationShipService;

@Service("RelationShipService")
public class RelationShipServiceImpl implements RelationShipService {

	@Autowired
	private RelationShipDAO relationShipDAO;

	@Override
	public void saveRelationShip(RelationShip relationShip) {
		relationShipDAO.saveOrUpdate(relationShip);
	}

	@Override
	public List<RelationShip> findAllRelationShip() {
		return relationShipDAO.findAllRelationShip();
	}

	@Override
	public RelationShip findRelationShipById(long id) {
		return relationShipDAO.findByPrimaryKey(id);
	}

	@Override
	public void deleteRelationShip(long id) {
		RelationShip relationShip = findRelationShipById(id);
		relationShip.setDelete(true);
		saveRelationShip(relationShip);
	}

}
