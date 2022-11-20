package com.masai.service;

import java.util.List;

import com.masai.model.Student;

public interface StudentService {

	
	Student addStudent(Student student);
	
	String deleteStudent(Integer id);
	
	Student findStudent(Integer id);
	
	Student findStudentWithPincode(String pinCode);
	
	List<Student> sortWithName();
	
	List<Integer> setOfMarks();
	
	List<Student> addAllStudents(List<Student> list);
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

