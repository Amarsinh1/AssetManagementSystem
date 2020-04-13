package com.cg.ams.bean;

import java.time.LocalDate;

public class Employee {
private String Employee_no;
private String Ename;
private String job;
private String mgr;
private LocalDate hireDate;
private String dept_Id;
 public Employee() {
	 
 }
 
public Employee(String employee_no, String ename, String job, String mgr, LocalDate hireDate, String dept_Id) {
	super();
	Employee_no = employee_no;
	Ename = ename;
	this.job = job;
	this.mgr = mgr;
	this.hireDate = hireDate;
	this.dept_Id = dept_Id;
}

public String getEmployee_no() {
	return Employee_no;
}
public void setEmployee_no(String employee_no) {
	Employee_no = employee_no;
}
public String getEname() {
	return Ename;
}
public void setEname(String ename) {
	Ename = ename;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public String getMgr() {
	return mgr;
}
public void setMgr(String mgr) {
	this.mgr = mgr;
}
public LocalDate getHireDate() {
	return hireDate;
}
public void setHireDate(LocalDate hireDate) {
	this.hireDate = hireDate;
}
public String getDept_Id() {
	return dept_Id;
}
public void setDept_Id(String dept_Id) {
	this.dept_Id = dept_Id;
}
@Override
public String toString() {
	return "Employee [Employee_no=" + Employee_no + ", Ename=" + Ename + ", job=" + job + ", mgr=" + mgr + ", hireDate="
			+ hireDate + ", dept_Id=" + dept_Id + "]";
}
 
}
