package com.example.springbootbackend_01.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springbootbackend_01.exception.ResourceNotFoundException;
import com.example.springbootbackend_01.model.Employee;
import com.example.springbootbackend_01.repository.EmployeeRepository;
import com.example.springbootbackend_01.service.impl.EmployeeService;

@Service	
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return  employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Employee", "Id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, int id) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee", "Id", id));
		existingEmployee.setFisrtName(employee.getFisrtName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}
}
