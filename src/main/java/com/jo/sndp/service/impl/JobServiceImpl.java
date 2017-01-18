package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.JobDAO;
import com.jo.sndp.entity.Job;
import com.jo.sndp.service.JobService;

@Service("JobService")
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDAO jobDAO;

	@Override
	public void saveJob(Job job) {
		jobDAO.saveOrUpdate(job);
	}

	@Override
	public List<Job> findAllJob() {
		return jobDAO.findAllJobs();
	}

	@Override
	public Job findJobById(long id) {
		return jobDAO.findByPrimaryKey(id);
	}

	@Override
	public void deleteJob(long id) {
		Job job = findJobById(id);
		job.setDelete(true);
		saveJob(job);
	}

}
