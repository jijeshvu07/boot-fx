package com.jo.sndp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jo.sndp.model.BloodGroup;

@Repository
public interface BloodRepository extends JpaRepository<BloodGroup, Integer>{
}
