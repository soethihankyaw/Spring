package com.jdc.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.model.dto.StateIdDisplayName;
import com.jdc.model.dto.StateValueDto;
import com.jdc.model.dto.StateWithDistrictCount;
import com.jdc.model.entity.State;

public interface StateInterfaceRepository extends JpaRepository<State, Integer> {
	
	@Query("""
			select s.id id, s.name name, size(s.district) districtCount
			from State s where s.region = :region
			""")
	List<StateWithDistrictCount> searchStateList(@Param("region") String region);
	
	//repo for open projection using interface default method
//	StateIdDisplayName findOneById(int id);
	 
	StateValueDto findOneById(int id);
}
