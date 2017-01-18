package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.OfficeStatus;

public interface OfficeStatusDAO extends GenericDAO<OfficeStatus, Long> {
 public List<OfficeStatus>findAllOfficeStatuses();
}
