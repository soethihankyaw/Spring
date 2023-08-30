package com.jdc.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.model.entity.State;
import com.jdc.model.record.StateWIthDistrictCount;

public interface StateAggregateRepository extends JpaRepository<State, Integer>{
	
	@Query("""
			select new com.jdc.model.record.StateWIthDistrictCount(s.id, s.name, size(s.district))
			from State s where s.id = :id
			""")
	StateWIthDistrictCount findOneById(@Param("id")int id);
}
