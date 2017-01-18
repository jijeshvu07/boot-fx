package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.Job;

public interface JobDAO extends GenericDAO<Job, Long> {
  public List<Job>findAllJobs();
}
