package com.AOA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.AOA.model.Employee;
import com.AOA.model.UpdateEmployeeRequest;
import com.AOA.service.EmployeeService;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping(path="/list")
	public List<Employee> getAllEmployeeList(){
		return employeeService.getAllEmployeeList();
	}

	@GetMapping(path="/list/{id}")
	public Employee getEmployeeById(@PathVariable(name = "id", required = true) String id){
		return employeeService.getEmployeeById(id);
	}


	@GetMapping(path="/with-params")
	public List<Employee> getEmployeeWithParams(@RequestParam(name = "firstName", required = false) String firstName,
												@RequestParam(name = "lastName", required = false) String lastName){
		System.out.println("/with-params:\t" + firstName + " " + lastName);
		return employeeService.getEmployeeWithParams(firstName, lastName);
	}

	@PostMapping(path="/save-employee")
	public Employee saveEmployee(@RequestBody Employee newEmployee){
		System.out.println("/save-employee:\t" + newEmployee.toString());
		return employeeService.saveEmployee(newEmployee);
	}

	@DeleteMapping(path="/delete-employee/{idString}")
	public Boolean deleteEmployee(@PathVariable(name = "idString", required = true) String idString){
		System.out.println("/delete-employee:\t" + "idString: " + idString);
		return employeeService.deleteEmployee(idString);
	}
	
	@PutMapping(path="/update-employee/{id}")
	public Employee updateEmployee(@PathVariable(name = "id") String id, @RequestBody UpdateEmployeeRequest updateRequest){
		System.out.println("/update-employee:\t" + "id: " + id + "\tUpadateEmployeeRequest: " + updateRequest.toString());

		return employeeService.updateEmployee(id, updateRequest);
	}
	
}
