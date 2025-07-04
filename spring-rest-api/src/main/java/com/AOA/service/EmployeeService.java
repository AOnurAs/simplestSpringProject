package com.AOA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AOA.model.Employee;
import com.AOA.model.UpdateEmployeeRequest;
import com.AOA.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployeeList(){
		
		return employeeRepository.getAllEmployeeList();
	}
	
	public Employee getEmployeeById(String id){
		return employeeRepository.getEmployeeById(id);
	}
	
	public List<Employee> getEmployeeWithParams(String firstName, String lastName){
		return employeeRepository.getEmployeeWithParams(firstName, lastName);
	}
	
	public Employee saveEmployee(Employee newEmployee) {
		return employeeRepository.saveEmployee(newEmployee);
	}
	
	public Boolean deleteEmployee(String idString){
		return employeeRepository.deleteEmployee(idString);
	}
	
	public Employee updateEmployee(String id, UpdateEmployeeRequest updateRequest){
		return employeeRepository.updateEmployee(id,  updateRequest);
	}

}
