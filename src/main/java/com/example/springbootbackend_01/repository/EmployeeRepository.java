package com.example.springbootbackend_01.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootbackend_01.model.Employee;

@Repository
public interface  EmployeeRepository extends JpaRepository<Employee, Integer>{
	

}
