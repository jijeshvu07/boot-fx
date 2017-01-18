package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.RelationShip;

public interface RelationShipDAO extends GenericDAO<RelationShip, Long> {
  public List<RelationShip>findAllRelationShip();
}
