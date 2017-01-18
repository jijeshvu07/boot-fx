package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.SelfHelpGroup;

public interface SelfHelpGroupDAO extends GenericDAO<SelfHelpGroup, Long> {
	public List<SelfHelpGroup> findAllSelfHelpGroup();
}
