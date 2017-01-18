package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.FinanceStatus;

public interface FinanceStatusService {
 public void saveFinanceStatus(FinanceStatus financeStatus);
 public List<FinanceStatus>findAllFinanceStatus();
 public FinanceStatus finFinanceStatusById(long id);
 public void deleteFinanceStatusById(long id);
}
