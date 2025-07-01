package com.AOA.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.AOA.model.Employee;
import com.AOA.model.UpdateEmployeeRequest;

@Repository
public class EmployeeRepository {
	
	@Autowired
	private List<Employee> employeeList;

	public List<Employee> getAllEmployeeList(){
		return employeeList;
	}
	

	public Employee getEmployeeById(String id) {
		Employee findEmployee = null; 
		for (Employee employee : employeeList) {
			if(id.equals(employee.getIdString())) {
				findEmployee = employee;
				break;
			}
		}
		return findEmployee;
	}
	
	public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
		List<Employee> employeeWithParams = new ArrayList<>();
		if (firstName == null && lastName == null) {
			return employeeList;
		}
		for (Employee employee : employeeList) {
			if (firstName != null && lastName != null) {
				if (employee.getFirstName().equalsIgnoreCase(firstName)
						&& employee.getLastName().equalsIgnoreCase(lastName)) {
					employeeWithParams.add(employee);
				}
			}
			if (firstName != null && lastName == null) {
				if (employee.getFirstName().equalsIgnoreCase(firstName)) {
					employeeWithParams.add(employee);
				}
			}
			if (lastName != null && firstName == null) {
				if (employee.getLastName().equalsIgnoreCase(lastName)) {
					employeeWithParams.add(employee);
				}
			}
		}
		return employeeWithParams;
	}
	
	public Employee saveEmployee(Employee newEmployee) {
		employeeList.add(newEmployee);
		return newEmployee;
	}
	
	public Boolean deleteEmployee(String idString){
		for (Employee employee : employeeList) {
			if(idString.equalsIgnoreCase(employee.getIdString())) {
				employeeList.remove(employee);
				return true;
			}
		}
		return false;
	}
	
	private Employee findEmployeeById(String id){
		for (Employee employee : employeeList) {
			if(employee.getIdString().equals(id)) {
				return employee;
			}
			
		}
		return null;
	}
	
	public Employee updateEmployee(String id, UpdateEmployeeRequest updateRequest) {
		Employee foundEmployee = findEmployeeById(id);
		
		if(foundEmployee != null) {
			foundEmployee.setFirstName(updateRequest.getFirstName());
			foundEmployee.setLastName(updateRequest.getLastName());
		}
		
		return foundEmployee;
	}
}
