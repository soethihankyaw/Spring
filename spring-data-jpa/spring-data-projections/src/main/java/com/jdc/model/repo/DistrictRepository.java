package com.jdc.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.model.entity.District;

public interface DistrictRepository extends JpaRepository<District, Integer>{
	
	List<District> findByStateId(int stateId);
}
