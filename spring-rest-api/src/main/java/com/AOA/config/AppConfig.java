package com.AOA.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.AOA.model.Employee;

@Configuration
public class AppConfig {
	
	@Bean
	public List<Employee> employeeList(){
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("1", "AO", "A"));
		employeeList.add(new Employee("2", "KM", "S"));
		employeeList.add(new Employee("3", "BM", "T"));
		employeeList.add(new Employee("4", "SK", "L"));
		employeeList.add(new Employee("5", "SK", "P"));
		employeeList.add(new Employee("6", "DK", "L"));
		employeeList.add(new Employee("7", "SK", "L"));
		
		return employeeList;
		
	}

}
