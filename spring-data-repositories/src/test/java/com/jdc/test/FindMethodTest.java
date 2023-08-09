package com.jdc.test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.jpa.config.JpaConfiguration;
import com.jdc.jpa.entity.State.Type;
import com.jdc.jpa.repository.StateRepository;

@SpringJUnitConfig(classes = JpaConfiguration.class)
@Sql(scripts = {
		"/init-state.sql",
		"/load-data.sql"
})
public class FindMethodTest {
	
	@Autowired
	private StateRepository repo;
	
	//count()
	@Test
	void test_count() {
		assertThat(repo.count(), is(15L));
	}
	
	//existsById()
	@ParameterizedTest
	@CsvSource({
		"1,true",
		"15,true",
		"16,false"
	})
	void test_exists_by_id(int id, boolean expected) {
		assertThat(repo.existsById(id), is(expected));
	}
	
	//findall()
	@Test
	void test_find_all() {
		assertThat(repo.findAll(), allOf(
					notNullValue(),
					hasSize(15)
				));
	}
	
	//findById()
	@ParameterizedTest
	@CsvSource(delimiter = '\t', value= {
			"4	Kachin	State	North	Myitkyina	1689441",
			"5	Kayah	State	East	Loikaw	286627",
			"6	Kayin	State	South	Hpa-an	1574079",
			"7	Magway	Region	Central	Magwe	3917055",
			"8	Mandalay	Region	Central	Mandalay	6165723",
	})
	void test_find_by_id(int id, String name, Type type, String region, String capital, int porpulation) {
		var result = repo.findById(id).get();
		
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
	
	@ParameterizedTest
	@MethodSource("idForFind")
	void test_find_all_by_id(List<Integer> ids, int count) {
		var result = repo.findAllById(ids);
		
		assertThat(result, hasSize(count));
	}
	
	static Stream<Arguments> idForFind() {
		return Stream.of(
				Arguments.of(List.of(1,2,3), 3),
				Arguments.of(List.of(1,3,16,18), 2)
				);
	}
}

