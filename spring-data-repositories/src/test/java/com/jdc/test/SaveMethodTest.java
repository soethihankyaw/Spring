package com.jdc.test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.jpa.config.JpaConfiguration;
import com.jdc.jpa.entity.State;
import com.jdc.jpa.entity.State.Type;
import com.jdc.jpa.repository.StateRepository;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class SaveMethodTest {
	
	@Autowired
	private StateRepository stateRepository;
	
	@Sql(scripts = "/init-state.sql ")
	@ParameterizedTest
	@CsvFileSource(resources = "/save/test_insert.txt", delimiter = '\t')
	void test_insert(String name, Type type, String region, String capital, int porpulation) {
		
		//Prepare Input
		var input = new State(name, type, region, capital, porpulation);
		//Execute Test Method
		var result = stateRepository.saveAndFlush(input);
		//check result
		assertThat(result, hasProperty("id", is(1)));
	}
	
	@ParameterizedTest
	@Sql(scripts = {
			"/init-state.sql",
			"/load-data.sql"
	})
	@CsvSource({
		"1,albama,State,America,UnitedState,100",
	})
	void test_update(int id, String name, Type type, String region, String capital, int porpulation) {
		
		var input = new State(id, name, type, region, capital, porpulation);
		
		stateRepository.save(input);
		
		var result = stateRepository.findById(id).get();
		
		assertThat(result, allOf(
				notNullValue(),
				hasProperty("id", is(id)),
				hasProperty("name", is(name)),
				hasProperty("type", is(type)),
				hasProperty("region", is(region)),
				hasProperty("capital", is(capital)),
				hasProperty("porpulation", is(porpulation))
				));
	}
	
	
}
