package com.jdc.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.spring.config.JpaConfiguration;
import com.spring.model.repository.DistrictRepository;

@SpringJUnitConfig(classes = JpaConfiguration.class)
@Sql(scripts = {
	"/init-table.sql",
	"/load-data.sql"
})
public class DistrictRepoTest {
	
	@Autowired
	private DistrictRepository repo;
	
	// findByStateRegion
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"West,9"
	})
	void test_find_by_district(String region, int size) {
		var result = repo.findByStateRegion(region);
		assertThat(result, hasSize(size));
	}
	
	//findByNameStartingWithIgnoringCaseOrderBy
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"Hpa,2"
	})
	void test_find_by_name_starting_with(String name, int size) {
		var result = repo.findByNameStartingWithIgnoringCaseOrderBy(name);
		assertThat(result, hasSize(size));
	}
	//findByStateIdAndNameStartingWithIgnoringCaseOrderBy
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"13,Mo,3"
	})
	void test_find_by_state_and_name(int stateId, String name, int size) {
		var result = repo.findByStateIdAndNameStartingWithIgnoringCaseOrderBy(stateId, name);
		assertThat(result, hasSize(size));
	}
	
	//test_find_by_named_query
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"13,Mo,3"
	})
	void test_find_by_named_query(int stateId, String name, int size) {
		var result = repo.findForState(stateId, name.concat("%"));
		assertThat(result, hasSize(size));
	}
	
	@ParameterizedTest
	@CsvSource({
		"13,Mo,3"
	})
	void test_find_with_query_annotation(int stateId, String name, int size) {
		var result = repo.findForState(stateId, name.concat("%"));
		assertThat(result, hasSize(size));
	}
	
}
