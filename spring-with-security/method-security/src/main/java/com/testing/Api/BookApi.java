package com.testing.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.testing.entity.Employee;
import com.testing.service.EmployeeService;

@RestController
public class BookApi {
	
	@Autowired
	private EmployeeService bookService;
	
	@PostAuthorize("returnObject.roles.contains('reader')")
	@GetMapping("/employee/details/{name}")
	public Employee getEmployeeByName(@PathVariable String name) {
		return bookService.getEmployeeDetails(name);
	}
}
