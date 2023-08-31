package com.spring.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.spring.data.entity.State;
import com.spring.data.entity.State.Type;
import com.spring.data.repo.StateRepository;

@Service
public class StateSpecificationService {
	
	@Autowired
	private StateRepository repo;
	
	//select s from state s where s.region = region
	public List<State> findByRegion(String region) {
		Specification<State> specification = (root, query, criteriaBuilder) -> 
			criteriaBuilder.equal(root.get("region"), region);
		return repo.findAll(specification);
	}
	
	//select s from State s where s.type = type
	public List<State> findByType(Type type) {
		Specification<State> spec = (root, query, criteriaBuilder) -> 
		criteriaBuilder.equal(root.get("type"), type);
		
		return repo.findAll(spec);
	}
	
	
	public long findCountByType(Type type) {
		Specification<State> spec = (root, query, criteriaBuilder) -> 
		criteriaBuilder.equal(root.get("type"), type);
		
		return repo.count(spec);
	}
}
