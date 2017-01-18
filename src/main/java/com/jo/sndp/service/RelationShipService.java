package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.RelationShip;

public interface RelationShipService {
  public void saveRelationShip(RelationShip relationShip);
  public List<RelationShip>findAllRelationShip();
  public RelationShip findRelationShipById(long id);
  public void deleteRelationShip(long id);
}
