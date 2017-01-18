package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.UnionDAO;
import com.jo.sndp.entity.Union;
import com.jo.sndp.service.UnionService;

@Service("UnionService")
public class UnionServiceImpl implements UnionService {
	@Autowired
	private UnionDAO unionDAO;

	@Override
	public void saveUnion(Union union) {
		unionDAO.saveOrUpdate(union);
	}

	@Override
	public List<Union> findAllUnion() {
		return unionDAO.findAllUnions();
	}

	@Override
	public Union findUnionById(long id) {
		return unionDAO.findByPrimaryKey(id);
	}

	@Override
	public void deleteUnion(long id) {
       Union union = findUnionById(id);
       union.setDelete(true);
       saveUnion(union);
	}

	@Override
	public Union findUnionByUnionName(String name) {
		return unionDAO.findUnionByUnionName(name);
	}

	@Override
	public Union findUnionByUnionCode(String code) {
		return unionDAO.findUnionByUnionCode(code);
	}

}
