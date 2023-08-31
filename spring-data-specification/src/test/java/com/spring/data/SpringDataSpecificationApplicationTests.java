package com.spring.data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.data.entity.State.Type;
import com.spring.data.repo.StateRepository;
import com.spring.data.service.StateCriteriaService;

@SpringBootTest
class SpringDataSpecificationApplicationTests {
	
	@Autowired
	private StateCriteriaService service;
	
	@Autowired
	private StateRepository repo;
	
	//test for specification
	@Test
	void test_region_specification() {
		var list = service.findByRegion("East");
		assertThat(list, hasSize(2));
		
	}
	
	@Test
	void test_specification_type() {
		var list = service.findByType(Type.Region);
		assertThat(list, hasSize(7));
	}
	
	//test for criteria builder
	@Test
	void test_region_criteria() {
		var list = service.findByRegion("East");
		assertThat(list, hasSize(2));
		
	}
	
	@Test
	void test_criteria_type() {
		var list = service.findByType(Type.State);
		assertThat(list, hasSize(7));
	}
	
	

}
