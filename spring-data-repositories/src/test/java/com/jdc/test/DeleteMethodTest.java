package com.jdc.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.jpa.config.JpaConfiguration;
import com.jdc.jpa.entity.State;
import com.jdc.jpa.entity.State.Type;
import com.jdc.jpa.repository.StateRepository;

@SpringJUnitConfig(classes = JpaConfiguration.class)
@Sql(scripts = {
		"/init-state.sql",
		"/load-data.sql"
})
public class DeleteMethodTest {
	
	@Autowired
	private StateRepository repository;
	
//	@Disabled
	@ParameterizedTest
	@CsvSource(
			delimiter = '\t',
			value = {
					"1	Ayeyarwady	Region	Lower	Pathein	6184829	14"
			}
			)
	void test_delete_by_entity(int id, String name, Type type, String region, String capital, int porpulation, long remains) {
		var input = new State(id, name, type, region, capital, porpulation);
		
		repository.delete(input);
		
		assertThat(repository.count(), is(remains));
	}
	
//	@Disabled// disabled this test method
	@ParameterizedTest
	@CsvSource({
		"1, 14"
	})
	void test_delete_by_id(int id, long remains) {
		
		repository.deleteById(id);
		
		assertThat(repository.count(), is(remains));
	}
	
//	@Disabled
	@Test
	void test_delete_all() {
		repository.deleteAll();
		
		assertThat(repository.count(), is(0L));
	}
	
//	@Disabled
	@Test
	void test_delete_all_in_batch() {
		repository.deleteAllInBatch();
		
		assertThat(repository.count(), is(0L));
	}
	
//	@Disabled
	@ParameterizedTest
	@CsvSource(
			delimiter = '\t',
			value = "1,3,5	12"
			)
	void test_delete_all_by_ids(String ids, long remains) {
		var array = ids.split(",");
		var idList = Arrays.stream(array).map(a -> Integer.parseInt(a)).toList();
		
		repository.deleteAllById(idList);
		
		assertThat(repository.count(), is(remains));
	}
	
//	@Disabled
	@ParameterizedTest
	@MethodSource("idsForDelete") //@MethodSource must be static method and must return Stream<Arguments>
	void test_delete_all_by_id_in_batch(List<Integer> idList, long remains) {
		
		repository.deleteAllByIdInBatch(idList);
		
		assertThat(repository.count(), is(remains));
	}
	
	static Stream<Arguments> idsForDelete() {
		return Stream.of(
				Arguments.of(List.of(1,2,3), 12),
				Arguments.of(List.of(1,2,3,11,15), 10)
				);
	}
	
//	@Disabled
	@ParameterizedTest
	@MethodSource("entityForDelete")
	void test_delete_all_by_entity(List<State> stateList, long remains) {
		repository.deleteAll(stateList);
		
		assertThat(repository.count(), is(remains));
	}
	
	@ParameterizedTest
	@MethodSource("entityForDelete")
	void test_delete_all_by_entity_in_batch(List<State> stateList, long remains) {
		repository.deleteAllInBatch(stateList);
		
		assertThat(repository.count(), is(remains));
	}
	
	static Stream<Arguments> entityForDelete(){
		return Stream.of(
				Arguments.of(List.of(
						new State(1, "Ayeyarwady", Type.Region, "Lower", "Pathein", 6184829)
						), 14),
				Arguments.of(List.of(
						new State(1, "Ayeyarwady", Type.Region, "Lower", "Pathein", 6184829),
						new State(2, "Bago", Type.Region, "Lower", "Bago", 4867373)
						), 13)
				);
	}
}
