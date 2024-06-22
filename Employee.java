package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")// to provide table details
public class Employee {
	
	@Id    @GeneratedValue(generator="increment")  //to provide primary key
	//@GeneratedValue(strategy= GenerationType.IDENTITY)//to generate primary key
   private int id;
	
	@Column(name="first_name")//to map column to this filed
   private String firstName;
	
	@Column(name="last_name")
   private String lastName;
	
	@Column(name="email")
   private String email;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
   
}

