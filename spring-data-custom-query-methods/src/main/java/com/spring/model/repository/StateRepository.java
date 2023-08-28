package com.spring.model.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.entity.State;
import com.spring.model.entity.State.Type;

@Transactional(readOnly = true)
public interface StateRepository extends JpaRepository<State, Long>{
	
	//What we want & How we search
	
	List<State> findByType(Type type);
	
	Stream<State> strestreamByType(Type Type);
	
	long countByRegion(String region);
	
	State existsByRegion(String region);
	
	String findOneByName(String name);
	
	List<State> findFirst3ByType(Type type);
	
	void removeByType( Type type);
	
	@Transactional
	List<State> findDistinctByType(Type type);
	
	long countByType(Type type);
}
