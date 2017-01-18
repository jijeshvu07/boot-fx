package com.jo.sndp.dao;

import java.util.List;

import com.jo.sndp.entity.PostOffice;

public interface PostOfficeDAO extends GenericDAO<PostOffice, Long> {
	public List<PostOffice> findAllPostOffice();
	public List<PostOffice> findAllPostofficeByDistrictName(String districtName);
	public PostOffice findPostOfficeByName(String name);
}
