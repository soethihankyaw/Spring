package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.jpa.config.JpaConfiguration;
import com.jdc.jpa.repository.StateRepository;

import jakarta.transaction.Transactional;

@SpringJUnitConfig(classes = JpaConfiguration.class)
@Sql(scripts = {
		"/init-state.sql",
		"/load-data.sql"
})
public class GetReferenceTest {
	
	@Autowired
	private StateRepository stateRepository;
	
	@Test
	@Transactional
	void test() {
		var entity = stateRepository.getReferenceById(1);
		
		System.out.println(entity.getName());
	}
}
