package com.masai.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.model.Address;
import com.masai.model.Student;
import com.masai.service.StudentService;
import com.masai.service.StudentServiceImpl;

public class Runner {

	public static void menu() {
		
StudentService std = new StudentServiceImpl();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Add student.");
		System.out.println("2. Deletete student");	
		System.out.println("3. Find student");
		System.out.println("4. Find student with pincode");
		System.out.println("5. Sort student with name");
		System.out.println("6. Set of marks");
		System.out.println("7. Add all Student");
        System.out.println("8. Exist");
		System.out.println("Please select your choice");
		
		int choice =sc.nextInt();
		
		while(true) {
			
			if(choice ==1) {
				Student s = new Student();
				
				System.out.println("Enter name:");
				s.setName(sc.next()); 
				
				System.out.println("Enter marks");
				s.setMarks(sc.nextInt());
				
				System.out.println("Enter section");
				s.setSection(sc.next());
				
				
				Address a = new Address();
				System.out.println("Enter city");
				a.setCity(sc.next());
				
				System.out.println("Enter pincode");
				a.setPinCode(sc.next());
				
				System.out.println("Enter state");
				a.setState(sc.next());
				
				s.setAddress(a);
				
				System.out.println(std.addStudent(s));
				Runner.menu();
			}else if(choice == 2) {
				
				System.out.println("Enter id");
				int id = sc.nextInt();
				
				System.out.println(std.deleteStudent(id));
				Runner.menu();
				
			}else if(choice==3) {
				
				System.out.println("Enter id");
				int id = sc.nextInt();
				
				System.out.println(std.findStudent(id));
				Runner.menu();
				
			}else if(choice==4) {
				
				System.out.println("Enter pincode");
				String pincode = sc.next();
				
				System.out.println(std.findStudentWithPincode(pincode));
				
				Runner.menu();
				
			}else if(choice==5) {
				
				System.out.println(std.sortWithName());
				
				Runner.menu();
				
			}else if (choice==6) {
				
				System.out.println(std.setOfMarks());
				Runner.menu();
			}else if(choice==7) {
				
				
			List<Student> students = new ArrayList<>();	
				
			System.out.println("Enter how many student you want to add.");
			Integer no = sc.nextInt();
			
			for(int i=0;i<no;i++) {
				System.out.println("Student: "+(i+1));
                Student s = new Student();
				
				System.out.println("Enter name:");
				s.setName(sc.next()); 
				
				System.out.println("Enter marks");
				s.setMarks(sc.nextInt());
				
				System.out.println("Enter section");
				s.setSection(sc.next());
				
				
				Address a = new Address();
				System.out.println("Enter city");
				a.setCity(sc.next());
				
				System.out.println("Enter pincode");
				a.setPinCode(sc.next());
				
				System.out.println("Enter state");
				a.setState(sc.next());
				
				s.setAddress(a);
				
				students.add(s);
				
			}
			
			System.out.println(std.addAllStudents(students));
			Runner.menu();
				
			}else if (choice==8) {
				break;
			}
	
		}
	}
	
	
	public static void main(String[] args) {
		
		Runner.menu();


	}
	
	
	
	
}
