package com.spring.data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.data.service.StateCriteriaService;
import com.spring.data.service.StateSpecificationService;

@SpringBootTest
public class StateDeleteTest {
	
	@Autowired
	private StateSpecificationService service;
	
	@Autowired
	private StateCriteriaService criteriaService;
	
//	@Test
//	@Disabled
//	void test_spec_delete() {
//		var count = service.deletByRegion("East");
//		
//		assertThat(count, is(2));
//	}
	
	@Test
	void test_crit_delete() {
		var count = criteriaService.deleteByRegion("East");
		
		assertThat(count, is(2));
	}
}
