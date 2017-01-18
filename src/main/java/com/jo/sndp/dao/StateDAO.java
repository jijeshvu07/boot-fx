package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.State;

public interface StateDAO extends GenericDAO<State, Long> {
  public List<State>findAllState();
  public State findStateByName(String name);
}
