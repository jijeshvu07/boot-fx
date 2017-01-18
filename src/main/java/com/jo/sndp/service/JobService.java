package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.Job;

public interface JobService {
 public void saveJob(Job job);
 public List<Job>findAllJob();
 public Job findJobById(long id);
 public void deleteJob(long id);
}
