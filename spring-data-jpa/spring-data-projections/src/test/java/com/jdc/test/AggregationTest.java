package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.model.JpaConfiguration;
import com.jdc.model.repo.StateInterfaceRepository;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class AggregationTest {
	
	@Autowired
	private StateInterfaceRepository repo;
	
	@Test
	void test() {
		var result = repo.searchStateList("North");
		
		for(var dto : result) {
			dto.show();
		}
	}
}
