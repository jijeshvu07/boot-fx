package com.jo.sndp.service;

import java.util.List;

import com.jo.sndp.entity.PostOffice;

public interface PostOfficeService {
  public void savePostOffice(PostOffice postOffice);
  public List<PostOffice>findAllPostOffice();
  public PostOffice findPostOfficeById(long id);
  public void deletePostOffice(long id);
  public List<PostOffice> findAllPostofficeByDistrictName(String districtName);
  public PostOffice findPostOfficeByName(String name);
}
