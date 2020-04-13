package com.cg.ams.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.ams.bean.Department;
import com.cg.ams.exception.AssetAlreadyExistException;
import com.cg.ams.exception.InvalidIdException;
import com.cg.ams.exception.ReadOperationFailed;
import com.cg.ams.exception.UpdateFailedException;

public class DepartmentDaoImpTest {

	public static DepartmentDao dept = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dept = new DepartmentDaoImp();
		DepartmentDaoImp.mockData();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dept = null;
	}

	@Test
	public void testReadDepartmentSuccessfully() throws ReadOperationFailed {
		assertEquals("HR", dept.readDepartment("KLM1").getDept_Name());
	}
	@Test(expected=ReadOperationFailed.class)
	public void testReadDepartmentFailed() throws ReadOperationFailed {
		assertEquals("HR1", dept.readDepartment("KLM2").getDept_Name());
	}
	
	@Test
	public void testCreateDepartmentSuccessfully() throws AssetAlreadyExistException {
		assertTrue(dept.createDepartment(new Department("KLM10","BI")));
	}
	
	@Test
	public void testUpdateDepartmentSuccessfully() throws UpdateFailedException {
		assertTrue(dept.updateDepartment("KLM1", new Department("KLM10", "B")));
	}
	
	@Test
	public void testDeleteDepartmentSuccessfully() throws InvalidIdException {
		assertTrue(dept.deleteDepartment("KLM5"));
	}
}
