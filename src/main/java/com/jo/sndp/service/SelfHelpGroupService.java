package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.SelfHelpGroup;

public interface SelfHelpGroupService {
 public void saveSelfHelpGroup(SelfHelpGroup group);
 public List<SelfHelpGroup>findAllSelfHelpGroup();
 public SelfHelpGroup findSelfHelpGroupById(long id);
 public void deleteSelfHelpGroup(long id);
}
