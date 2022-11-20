package com.masai.model;

public class Student {

	
	private Integer id;
	private String name;
	private Integer marks;
	private String section;
	private Address address;
	
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}



	public Student(String name, Integer marks, String section, Address address) {
		super();
		this.name = name;
		this.marks = marks;
		this.section = section;
		this.address = address;
	}



	public Student(Integer id, String name, Integer marks, String section, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.section = section;
		this.address = address;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getMarks() {
		return marks;
	}



	public void setMarks(Integer marks) {
		this.marks = marks;
	}



	public String getSection() {
		return section;
	}



	public void setSection(String section) {
		this.section = section;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + ", section=" + section + ", address="
				+ address + "]";
	}
	
	
	
	
}
