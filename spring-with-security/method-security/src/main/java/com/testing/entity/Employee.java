package com.testing.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
	
	private String name;
	private List<String> books;
	private List<String> roles;
}
