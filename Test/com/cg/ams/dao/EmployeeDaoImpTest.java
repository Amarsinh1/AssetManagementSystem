package com.cg.ams.dao;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.ams.bean.Employee;
import com.cg.ams.exception.AssetAlreadyExistException;
import com.cg.ams.exception.InvalidIdException;
import com.cg.ams.exception.ReadOperationFailed;
import com.cg.ams.exception.UpdateFailedException;

public class EmployeeDaoImpTest {

	public static EmployeeDao emp = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emp = new EmployeeDaoImp();
		EmployeeDaoImp.mockData();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		emp = null;
	}

	@Test
	public void testReadEmployeeSuccessfully() throws ReadOperationFailed {
		assertEquals("Abhishek", emp.readEmployee("456").getEname());
	}
	@Test(expected=ReadOperationFailed.class)
	public void testReadEmployeeFailed() throws ReadOperationFailed {
		assertEquals("Abhi", emp.readEmployee("45").getEname());
	}
	
	@Test
	public void testCreateEmployeeSuccessfully() throws AssetAlreadyExistException {
		assertTrue(emp.createEmployee(new Employee("461","Ajay","Analyst","Samiran", LocalDate.parse("2002-02-17"),"KLM3")));
	}
	@Test(expected=AssetAlreadyExistException.class)
	public void testCreateEmployeeFailed() throws AssetAlreadyExistException {
		assertTrue(emp.createEmployee(new Employee("461","Ajay","Analyst","Samiran", LocalDate.parse("2002-02-17"),"KLM3")));
	}
	
	@Test
	public void testUpdateEmployeeSuccessfully() throws UpdateFailedException {
		assertTrue(emp.updateEmployee("458", new Employee("458","Amarsinh","Analyst","Rakesh", LocalDate.parse("2012-02-15"),"KLM2")));
	}
	@Test(expected=UpdateFailedException.class)
	public void testUpdateEmployeeFailed() throws UpdateFailedException {
		assertTrue(emp.updateEmployee("458", new Employee("458","Amarsinh","Analyst","Rakesh", LocalDate.parse("2012-02-15"),"KLM1")));
	}
	
	@Test
	public void testDeleteEmployeeSuccessfully() throws InvalidIdException{
		assertTrue(emp.deleteEmployee("460"));
	}
	@Test(expected=InvalidIdException.class)
	public void testDeleteEmployeeFailed() throws InvalidIdException{
		assertTrue(emp.deleteEmployee("461"));
	}

}
