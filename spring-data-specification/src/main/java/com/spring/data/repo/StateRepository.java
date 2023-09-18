package com.spring.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.spring.data.entity.State;

public interface StateRepository extends JpaRepositoryImplementation<State, Integer>{
	
}
