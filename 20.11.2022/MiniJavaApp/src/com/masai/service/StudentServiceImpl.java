package com.masai.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import com.masai.model.SortStudentByName;
import com.masai.model.Student;
import com.masai.model.sortStudentByMarks;

public class StudentServiceImpl implements StudentService {

	
	public static List<Student> studentList = new ArrayList<>();
	

	public static Integer count=1;
	
	@Override
	public Student addStudent(Student student) {
		
		student.setId(count++);
		
		studentList.add(student);
		System.out.println(studentList);
		return student;
		
		
	}

	
	@Override
	public String deleteStudent(Integer id) {


	ListIterator<Student> iTR = studentList.listIterator();
	
	while(iTR.hasNext()) {
		
		if(iTR.next().getId()==id) {
			iTR.remove();
			return "Student deleted with id"+id;
		}
		
	}
		return "No student found with this id";
	
		
	}
	
	

	@Override
	public Student findStudent(Integer id) {


		ListIterator<Student> itr = studentList.listIterator();
		
		Student s;
		while(itr.hasNext()) {
			
			if( itr.next().getId()==id) {
				return itr.next();
			}
			
			
		}
		
	  return null;
		
	}

	@Override
	public Student findStudentWithPincode(String pinCode) {
		
		
		for(Student s:studentList) {
			
			if((s.getAddress().getPinCode()).equals(pinCode)) {
				return s;
				
			}
			
			
		}
		return null;
		
	}

	
	
	@Override
	public List<Student> sortWithName() {

		
		Collections.sort(studentList,new SortStudentByName());

		return studentList;
	}

	@Override
	public List<Integer> setOfMarks() {

		Set<Integer> uniqueMarks = new HashSet<>();
		
		for(Student s:studentList) {
			uniqueMarks.add(s.getMarks());
		}
		
		return new ArrayList<Integer>(uniqueMarks);
	

	}

	@Override
	public List<Student> addAllStudents(List<Student> list) {


		for(Student s:list) {
			studentList.add(s);
		}
		
		
		Collections.sort(studentList,new sortStudentByMarks());
		
		return studentList;
	}

}
