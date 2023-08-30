package com.jdc.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.model.JpaConfiguration;
import com.jdc.model.repo.StateRecordRepository;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class ClassBasedProjection {
	
	@Autowired
	private StateRecordRepository repo;
	
	@Test
	void test() {
		var result = repo.findOneById(1);
		
		assertNotNull(result);
		System.out.println(result);
		
		System.out.println(result.displayName());
	}
}
