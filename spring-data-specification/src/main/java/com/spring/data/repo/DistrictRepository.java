package com.spring.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.data.entity.District;

public interface DistrictRepository extends JpaRepository<District, Integer>{
	long deleteByRegion(String state);
}
