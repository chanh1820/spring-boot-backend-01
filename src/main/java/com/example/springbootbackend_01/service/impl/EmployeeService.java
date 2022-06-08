package com.example.springbootbackend_01.service.impl;

import java.util.List;


import com.example.springbootbackend_01.model.Employee;


public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(int id);
	Employee updateEmployee(Employee employee, int id);
	void deleteEmployee(int id);
}
