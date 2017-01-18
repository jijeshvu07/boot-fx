package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.StateDAO;
import com.jo.sndp.entity.State;
import com.jo.sndp.service.StateService;

@Service("StateService")
public class StateServiceImpl implements StateService {
    @Autowired
	private StateDAO  stateDAO;
	
	@Override
	public void saveState(State state) {
		stateDAO.saveOrUpdate(state);
	}

	@Override
	public List<State> findAllState() {
		return stateDAO.findAllState();
	}

	@Override
	public State findStateById(long id) {
		return stateDAO.findByPrimaryKey(id);
	}

	@Override
	public void deleteState(long id) {
        State state = findStateById(id);
        state.setDelete(true);
        saveState(state);
	}

	@Override
	public State findStateByName(String name) {
		return stateDAO.findStateByName(name);
	}

}
