package com.masai.service;

import com.masai.model.Address;
import com.masai.model.Student;

public class Demo {

	public static void main(String[] args) {


		
		
		
		
	StudentService st = new StudentServiceImpl();
	
	Student s1= new Student();
	
	s1.setName("Souvik");
	s1.setMarks(520);
	s1.setSection("A");
	s1.setAddress(new Address("Berhampore","WB","456123"));
	
	Student std= st.addStudent(s1);
	System.out.println(std);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
