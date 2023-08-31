package com.spring.data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.data.entity.State;
import com.spring.data.entity.State.Type;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class StateCriteriaService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	//select s from State s where s.region = region
	public List<State> findByRegion(String region) {
		
		//create criteria builder
		var criteriaBuilder = entityManager.getCriteriaBuilder();
		//create criteria query
		var criteriaQuery = criteriaBuilder.createQuery(State.class);
		//create root object
		var root = criteriaQuery.from(State.class);
		//select s from State
		criteriaQuery.select(root);
		//s.region = region
		var predicate = criteriaBuilder.equal(root.get("region"), region);
		//select s from State s where s.region = region
		criteriaQuery.where(predicate);
		
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
	public List<State> findByType(Type type) {
		//create criteria builder
		var criteriaBuilder = entityManager.getCriteriaBuilder();
		//create cirteria query
		var criteriaQuery = criteriaBuilder.createQuery(State.class);
		//create root object 
		var root = criteriaQuery.from(State.class);
		//select s from State s
		criteriaQuery.select(root);
		//s.type = type 
		var predicate = criteriaBuilder.equal(root.get("type"), type);
		//combine predicate and root
		criteriaQuery.where(predicate);
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
}
