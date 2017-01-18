package com.jo.sndp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.SelfHelpGroupDAO;
import com.jo.sndp.entity.SelfHelpGroup;

@Repository("SelfHelpGroupDAO")
public class SelfHelpGroupDAOImpl extends GenericDAOImpl<SelfHelpGroup, Long> implements SelfHelpGroupDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<SelfHelpGroup> findAllSelfHelpGroup() {
		return getSession().createQuery("from SelfHelpGroup where isDelete='false'").list();
	}

}
