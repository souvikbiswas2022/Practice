package com.masai.service;

import java.util.List;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee) throws EmployeeException;
	
	public Employee getEmployee(Long empID) throws EmployeeException;
	
	public Employee getEmployeeManager(Long empID)throws EmployeeException;
	
	public List<Employee> getAllReportees(Long empID) throws EmployeeException;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
