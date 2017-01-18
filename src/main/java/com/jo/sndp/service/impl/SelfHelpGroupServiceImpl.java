package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.SelfHelpGroupDAO;
import com.jo.sndp.entity.SelfHelpGroup;
import com.jo.sndp.service.SelfHelpGroupService;

@Service("SelfHelpGroupService")
public class SelfHelpGroupServiceImpl implements SelfHelpGroupService{
    @Autowired
	private SelfHelpGroupDAO selfHelpGroupDAO;
	@Override
	public void saveSelfHelpGroup(SelfHelpGroup group) {
		selfHelpGroupDAO.saveOrUpdate(group);
	}

	@Override
	public List<SelfHelpGroup> findAllSelfHelpGroup() {
		return selfHelpGroupDAO.findAllSelfHelpGroup();
	}

	@Override
	public SelfHelpGroup findSelfHelpGroupById(long id) {
		return selfHelpGroupDAO.findByPrimaryKey(id);
	}

	@Override
	public void deleteSelfHelpGroup(long id) {
		SelfHelpGroup group = findSelfHelpGroupById(id);
		group.setDelete(true);
		saveSelfHelpGroup(group);
	}

}
