package com.spring.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.spring.data.entity.District;
import com.spring.data.entity.State;
import com.spring.data.entity.State.Type;
import com.spring.data.repo.DistrictRepository;
import com.spring.data.repo.StateRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class StateSpecificationService {
	
	@Autowired
	private StateRepository repo;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	//select s from state s where s.region = region
	public List<State> findByRegion(String region) {
		return repo.findAll(byRegion(region));
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
	
	@Transactional
	public long deletByRegion(String region) {
		deleteDistrictByRegion(region);
	 return	repo.delete(byRegion(region));
	}
	
	private long deleteDistrictByRegion(String region) {
		
		Specification<District> spec = (root, query, criteriaBuilder) -> 
		criteriaBuilder.equal(root.get("State").get("region"), region);
		
		return districtRepository.deleteByRegion(region);
	}

	private Specification<State> byRegion(String region) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("region"), region);
	}
}
