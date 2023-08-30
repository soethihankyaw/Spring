package com.jdc.test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.model.JpaConfiguration;
import com.jdc.model.entity.State.Type;
import com.jdc.model.repo.StateInterfaceRepository;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class OpenProjectionTest {
	
	@Autowired
	private StateInterfaceRepository repo;
	
	//test for open projection using interface default method
//	@Test
//	void test_interface_default() {
//		var result = repo.findOneById(1);
//		
//		assertThat(result, allOf(
//				notNullValue(),
//				hasProperty("id", is(1)),
//				hasProperty("name",is("Ayeyarwady")),
//				hasProperty("type", is(Type.Region)),
//				hasProperty("displayName", is("Ayeyarwady Region"))
//				));
//	}
	
	@Disabled
	//test for open projection for @value and spel 
	@Test
	void test_value_spel() {
		var result = repo.findOneById(1);
		
		assertThat(result, allOf(
				notNullValue(),
				hasProperty("id", is(1)),
				hasProperty("displayName", is("Ayeyarwady Region"))
				));
	}
}
