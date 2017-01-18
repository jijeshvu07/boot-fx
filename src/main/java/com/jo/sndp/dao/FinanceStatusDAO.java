package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.FinanceStatus;

public interface FinanceStatusDAO extends GenericDAO<FinanceStatus, Long>{
  List<FinanceStatus>findAllFinanceStatuses();
}
