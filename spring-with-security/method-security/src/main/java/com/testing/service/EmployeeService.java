package com.testing.service;

import java.util.List;
import java.util.Map;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import com.testing.entity.Employee;

@Service
public class EmployeeService {
	
	private Map<String, Employee> records =
			Map.of(
			"soethi",
			new Employee("Soe Thi",List.of("Dhamman, Babylon"),List.of("developer", "reader")),
			"hankyaw",new Employee("HanKyaw",List.of("SpringBoot"),List.of("researcher"))
			);
	
	@PostAuthorize("returnObject.roles.contains('reader')")
	public Employee getEmployeeDetails(String name) {
		return records.get(name);
	}
}
