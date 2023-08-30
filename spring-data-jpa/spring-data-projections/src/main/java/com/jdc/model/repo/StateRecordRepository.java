package com.jdc.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.model.entity.State;
import com.jdc.model.record.StateRecord;

public interface StateRecordRepository extends JpaRepository<State, Integer>{
	
	StateRecord findOneById(int id);
}
