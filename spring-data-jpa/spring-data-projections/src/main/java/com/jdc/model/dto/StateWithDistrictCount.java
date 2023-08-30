package com.jdc.model.dto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.model.entity.State;

public interface StateWithDistrictCount extends JpaRepository<State, Integer>{
	
	int getId();
	String getName();
	int getDistrictCount();
	
	//open projection using interface default method
	default void show() {
		System.out.printf("ID : %2d, Name : %-12s, District : %d%n",
				getId(), getName(), getDistrictCount());
	}
}
