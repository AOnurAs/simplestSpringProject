package com.AOA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AOA.model.Employee;
import com.AOA.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployeeList(){
		
		return employeeRepository.getAllEmployeeList();
	}
}
