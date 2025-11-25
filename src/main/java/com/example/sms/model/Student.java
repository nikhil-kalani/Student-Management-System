package com.example.sms.model;


import java.sql.Date;


public class Student {
private int id;
private String name;
private String email;
private String phone;
private String course;
private Date dob;
public Student(int id, String name, String email, String phone, String course, Date dob) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.course = course;
	this.dob = dob;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}


// constructors
//public Student() {}



}