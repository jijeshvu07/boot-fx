package com.jo.sndp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jo.sndp.dao.JobDAO;
import com.jo.sndp.entity.Job;

@Repository("JobDAO")
public class JobDAOImpl extends GenericDAOImpl<Job, Long> implements JobDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<Job> findAllJobs() {
		return getSession().createQuery("from Job where isDelete='false'").list();
	}

}
