package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.model.JpaConfiguration;
import com.jdc.model.dto.StateDtoInterface;
import com.jdc.model.entity.State;
import com.jdc.model.record.StateRecord;
import com.jdc.model.repo.StateDynamicRepository;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class DynamicProjectionDemo {
	
	@Autowired
	private StateDynamicRepository repo;
	
	//entity.class,
	@Test
	void test_entity() {
		var result = repo.findOneById(1, State.class);
		System.out.println(result.getName());
	}
	//interface.class
	@Test
	void test_interface() {
		var result = repo.findOneById(1,  StateDtoInterface.class);
		System.out.println(result.getName());
	}
	
	//record.class
	@Test
	void test_record() {
		var result = repo.findOneById(1,  StateRecord.class);
		System.out.println(result.name());
	}
	
	
}
