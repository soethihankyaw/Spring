package com.spring.data.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.data.entity.District;
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
	
	@Transactional
	public long deleteByRegion(String region) {
		
		// Create Criteria Builder
		var criteriaBuilder = entityManager.getCriteriaBuilder();
		
		deleteDistrictByRegion(region);
		
		var delete = criteriaBuilder.createCriteriaDelete(State.class);
		var root = delete.from(State.class);
		delete.where(criteriaBuilder.equal(root.get("region"), region));
		
		return entityManager.createQuery(delete).executeUpdate();
	}


	private long deleteDistrictByRegion(String region) {
		// Create Criteria Builder
		var criteriaBuilder = entityManager.getCriteriaBuilder();
		
		var delete = criteriaBuilder.createCriteriaDelete(District.class);
		var root = delete.from(District.class);
		
		// Sub Query for Select district where region
		var districtByRegion = delete.subquery(District.class);
		// select ? from District
		var subRoot = districtByRegion.from(District.class);
		// select District from District
		districtByRegion.select(subRoot);
		// join district with state
		var join = subRoot.join("state");
		// where state.region = region
		districtByRegion.where(criteriaBuilder.equal(join.get("region"), region));
		
		// We can't create predicate from related entity because root criteria delete is single root 
		// delete.where(criteriaBuilder.equal(root.get("state").get("region"), region));
		
		delete.where(root.in(districtByRegion));
		
		return entityManager.createQuery(delete).executeUpdate();
	}
}
