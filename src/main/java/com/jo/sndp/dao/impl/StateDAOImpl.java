package com.jo.sndp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.StateDAO;
import com.jo.sndp.entity.State;

/**
 * Created by JO on 4/30/2016.
 */

@Repository("StateDAO")
public class StateDAOImpl extends GenericDAOImpl<State, Long> implements StateDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<State> findAllState() {
		return getSession().createQuery("from State where isDelete='false'").list();
	}

	@Override
	public State findStateByName(String name) {
		return (State) getSession().createQuery("from State where isDelete='false' and stateName=:stateName")
				.setParameter("stateName", name).uniqueResult();
	}
}
