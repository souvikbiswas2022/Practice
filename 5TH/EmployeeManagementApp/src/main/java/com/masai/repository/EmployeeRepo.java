package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.model.Employee;



@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	
	
  // Employee findManager(@Param("empid") Long empid);	
	
   List<Employee> findByManagerID(Long managerID);
	
	
}
