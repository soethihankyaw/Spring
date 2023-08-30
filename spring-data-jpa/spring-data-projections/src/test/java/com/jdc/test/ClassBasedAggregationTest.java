package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.model.JpaConfiguration;
import com.jdc.model.repo.StateAggregateRepository;
import com.jdc.model.repo.StateRecordRepository;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class ClassBasedAggregationTest {
	
	@Autowired
	private StateAggregateRepository repo;
	
	@Test
	void test() {
		var result = repo.findOneById(1);
		System.out.println(result);
	}
}
