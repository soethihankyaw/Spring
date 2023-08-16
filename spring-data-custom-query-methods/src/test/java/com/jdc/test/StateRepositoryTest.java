package com.jdc.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.spring.config.JpaConfiguration;
import com.spring.model.entity.State.Type;
import com.spring.model.repository.StateRepository;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class StateRepositoryTest {
	
	
	private final StateRepository stateRepository;

	
	
	public StateRepositoryTest(StateRepository stateRepository) {
		super();
		this.stateRepository = stateRepository;
	}

	@Disabled
	@ParameterizedTest
	@CsvSource({
		"State,7",
		"Region,7",
		"Union,1"
	})
	void test_find_by_type(Type type, int size) {
		var result = stateRepository.findByType(type);
		assertThat(result, hasSize(size));
	}
	
	@Test
	void test_find_by_id() {
		
	}
	
}
