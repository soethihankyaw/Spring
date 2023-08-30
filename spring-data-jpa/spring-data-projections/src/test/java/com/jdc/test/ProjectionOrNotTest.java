package com.jdc.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.model.JpaConfiguration;
import com.jdc.model.dto.DistrictDtoInterface;
import com.jdc.model.repo.DistrictDtoProjectionRepository;
import com.jdc.model.repo.DistrictRepository;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class ProjectionOrNotTest {
	
	@Autowired
	private DistrictRepository repo;
	
	@Autowired
	private DistrictDtoProjectionRepository dtoRepo;
	
	//get district without projection
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"1,8"
	})
	void test(int state, int size) {
		var result = repo.findByStateId(state);
		assertThat(result, hasSize(size));
	}
	
	//get district with projection
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"1,8"
	})
	void test_dto_projections(int state, int size) {
		var result = dtoRepo.findByStateId(state);
		assertThat(result, hasSize(size));
	}
}
