package com.jo.sndp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo.sndp.dao.PostOfficeDAO;
import com.jo.sndp.entity.PostOffice;
import com.jo.sndp.service.PostOfficeService;

@Service("PostOfficeService")
public class PostOfficeServiceImpl implements PostOfficeService {
	@Autowired
	private PostOfficeDAO postOfficeDAO;

	@Override
	public void savePostOffice(PostOffice postOffice) {
		postOfficeDAO.saveOrUpdate(postOffice);
	}

	@Override
	public List<PostOffice> findAllPostOffice() {
		return postOfficeDAO.findAllPostOffice();
	}

	@Override
	public PostOffice findPostOfficeById(long id) {
		return postOfficeDAO.findByPrimaryKey(id);
	}

	@Override
	public void deletePostOffice(long id) {
		PostOffice office = findPostOfficeById(id);
		office.setDelete(true);
		savePostOffice(office);
	}

	@Override
	public List<PostOffice> findAllPostofficeByDistrictName(String districtName) {
		return postOfficeDAO.findAllPostofficeByDistrictName(districtName);
	}

	@Override
	public PostOffice findPostOfficeByName(String name) {
		return postOfficeDAO.findPostOfficeByName(name);
	}

}
