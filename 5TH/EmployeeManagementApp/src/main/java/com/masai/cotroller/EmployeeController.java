package com.masai.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.service.EmployeeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService eS;
	
	
	@PostMapping("/employees")
   public ResponseEntity<Employee> addEmployee(@RequestBody  Employee employee) throws EmployeeException{
	   
	   
	  return new ResponseEntity<Employee>(eS.addEmployee(employee),HttpStatus.OK);
	   
	   
   }
	

  @GetMapping("/get-employees/{employee-id}")
   public ResponseEntity<Employee> getEmployee( @PathVariable("employee-id") Long empID) throws EmployeeException{
	
	   return new ResponseEntity<Employee>(eS.getEmployee(empID),HttpStatus.OK);
	

  }
	
  @GetMapping("get-employee-manager/{employee-id}")
  public ResponseEntity<Employee> getEmployeeManager(@PathVariable("employee-id") Long empID) throws EmployeeException{
	  
	  return new ResponseEntity<Employee>(eS.getEmployeeManager(empID),HttpStatus.OK);
	  

  }
	
	
	@GetMapping("/get-all-reportees/{employee-id}")
  public ResponseEntity<List<Employee>> getAllReportees(@PathVariable("employee-id") Long empID) throws EmployeeException {
	  
		 return new ResponseEntity<List<Employee>>(eS.getAllReportees(empID),HttpStatus.OK); 
	  
	  
	  
	  
  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
