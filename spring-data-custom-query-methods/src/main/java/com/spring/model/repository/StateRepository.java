package com.spring.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.entity.State;

public interface StateRepository extends JpaRepository<State, Long>{

}
