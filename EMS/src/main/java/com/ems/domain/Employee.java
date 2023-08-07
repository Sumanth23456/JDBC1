package com.ems.domain;
//employee id, first name, surname, gender, age, address, contact number etc
public class Employee {
   private int eid;
   private String ename;
   private int age;
   private String contactNumber;
   
public String getContactNumber() {
	return contactNumber;
}
public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
 
}
