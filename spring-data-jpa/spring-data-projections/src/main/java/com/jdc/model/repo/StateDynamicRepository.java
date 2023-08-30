package com.jdc.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.model.entity.State;

public interface StateDynamicRepository extends JpaRepository<State, Integer>{
	
	<T> T findOneById(int id, Class<T> type);
}	
