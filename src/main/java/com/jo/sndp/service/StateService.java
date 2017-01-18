package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.State;

public interface StateService {
 public void saveState(State state);
 public List<State>findAllState();
 public State findStateById(long id);
 public void deleteState(long id);
 public State findStateByName(String name);
}
