package com.jdc.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.spring.config.JpaConfiguration;
import com.spring.model.entity.State;
import com.spring.model.entity.State.Type;
import com.spring.model.repository.StateRepository;

import jakarta.transaction.Transactional;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class StateRepoTest {
	
	@Autowired
	private StateRepository repo;
	
	//find by type 
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"State,7",
		"Region,7",
		"Union,1"
	})
	void test_find_by_type(Type type, int size) {
		var result = repo.findByType(type);
		assertThat(result, hasSize(size));
	}
	
	//stream by type
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"State,7",
		"Region,7",
		"Union,1"
	})
	@Transactional 
	void test_stream_by_type(Type type,long size) {
		Stream<State> result = repo.strestreamByType(type);
		assertThat(result.count(), is(size));
	}
	
	//count by region
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"lower,3",
		"ceter,0"
	})
	void test_count_by_region(String region, long size) {
		var result = repo.countByRegion(region);
		assertThat(result, is(size));
	}
	
	//exists by region
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"lower,true",
		"center,false"
	})
	void test_exists_by_region(String region, Boolean expected) {
		var result = repo.existsByRegion(region);
		assertThat(result, is(expected));
	}
	
	//existsByRegion
	@Disabled
	@ParameterizedTest
	@ValueSource(strings = {
		"Yangon","Bago"
	})
	void test_exists_by_region(String name) {
		var result = repo.findOneByName(name);
		assertThat(result, notNullValue());
	}
	
	//FindFirst3ByType
	@Disabled
	@ParameterizedTest
	@ValueSource(strings = {
		"Region,3",
		"State,3",
		"Union,1"
		
	})
	void test_find_first_3_by_type(Type type, int size) {
		var result = repo.findFirst3ByType(type);
		assertThat(result, hasSize(3));
	}
	
	//removeByType
	@ParameterizedTest
	@ValueSource(strings = {
			"Region", "State", "Union"
	})
	void test_remove_by_type(Type type) {
		repo.removeByType(type);
		var result = repo.countByType(type);
		assertThat(result, is(0L));
	}
}
