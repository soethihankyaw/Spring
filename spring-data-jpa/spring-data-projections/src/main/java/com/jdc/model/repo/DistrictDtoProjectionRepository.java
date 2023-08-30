package com.jdc.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.model.dto.DistrictDtoInterface;
import com.jdc.model.entity.District;

public interface DistrictDtoProjectionRepository extends JpaRepository<District, Integer>{
	
	List<DistrictDtoInterface> findByStateId(int stateId);
}
