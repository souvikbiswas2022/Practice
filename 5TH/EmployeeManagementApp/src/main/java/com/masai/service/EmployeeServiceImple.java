package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.repository.EmployeeRepo;

import io.swagger.v3.oas.annotations.servers.Server;

@Service
public class EmployeeServiceImple implements EmployeeService {

	@Autowired
	private EmployeeRepo eR;
	
	
	@Override
	public Employee getEmployee(Long empID) throws EmployeeException {


		 Optional<Employee> employee = eR.findById(empID);
		 
		 if(employee.isPresent()) {
			 return employee.get();
		 }else {
			 throw new EmployeeException("Invalid id...!");
		 }
		

	}

	@Override
	public Employee getEmployeeManager(Long empID) throws EmployeeException {
		// TODO Auto-generated method stub
		
		Optional<Employee> emp1= eR.findById(empID);
		
		if(emp1.isPresent()) {
			
			return eR.findById(emp1.get().getManagerID()).get();
			
			
		}else {
			
			 throw new EmployeeException("Invalid id...!");
		}
		

	}

	@Override
	public List<Employee> getAllReportees(Long empID) throws EmployeeException {


		List<Employee> empList = eR.findByManagerID(empID);
		
		
		if(empList.size() !=0) {
			return empList;
		}else {
			 throw new EmployeeException("No Employee found...!");
		}
		
		

		
		
	}

	@Override
	public Employee addEmployee(Employee employee) throws EmployeeException {

		Employee emp = eR.save(employee);
		return emp;
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
