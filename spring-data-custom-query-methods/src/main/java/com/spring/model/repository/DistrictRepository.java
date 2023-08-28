package com.spring.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.model.entity.District;

public interface DistrictRepository extends JpaRepository<District, Long>{
	
	//queryMethod
	List<District> findByStateRegion(String region);
	
	List<District> findByNameStartingWithIgnoringCaseOrderBy(String name);
	
	List<District> findByStateIdAndNameStartingWithIgnoringCaseOrderBy(int stateId, String name);
	
	//namedQuery
	List<District> findForState(int id, String name);
	
	@Query(name = "District.findForState") //with different name same query method
	List<District> findWithNamedQuery(@Param("stateId") int id,@Param("name") String name);
	
	@Query(value = """
			select d from District d where d.state.id = :stateId
				 and lower(d.name) like lower(:name) order by d.name
			""")
	List<District> findWithQueryAnnotation(@Param("stateId") int id, @Param("name") String name);
	
	
}
