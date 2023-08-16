package com.spring.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.entity.State;
import com.spring.model.entity.State.Type;

public interface StateRepository extends JpaRepository<State, Long>{
	
	//What we want & How we search
	
	List<State> findByType(Type type);
}
