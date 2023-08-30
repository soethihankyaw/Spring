package com.spring.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.spring.data.entity.State;

public interface StateRepository extends JpaRepository<State, Integer>, JpaSpecificationExecutor<State>{

}
