package com.cg.ams.bean;

public class Department {
private String Dept_id;
private String Dept_Name;
 public Department() {
	 
 }
public Department(String dept_id, String dept_Name) {
	super();
	Dept_id = dept_id;
	Dept_Name = dept_Name;
}
public String getDept_id() {
	return Dept_id;
}
public void setDept_id(String dept_id) {
	Dept_id = dept_id;
}
public String getDept_Name() {
	return Dept_Name;
}
public void setDept_Name(String dept_Name) {
	Dept_Name = dept_Name;
}
@Override
public String toString() {
	return "Department [Dept_id=" + Dept_id + ", Dept_Name=" + Dept_Name + "]";
}
 
}
