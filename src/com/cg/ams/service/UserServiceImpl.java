package com.cg.ams.service;

import java.util.HashMap;

import com.cg.ams.bean.AssetForm;
import com.cg.ams.bean.Department;
import com.cg.ams.bean.Employee;
import com.cg.ams.dao.AssetFormDao;
import com.cg.ams.dao.AssetFormDaoImp;
import com.cg.ams.dao.DepartmentDaoImp;
import com.cg.ams.dao.EmployeeDaoImp;
import com.cg.ams.exception.ReadOperationFailed;
import com.cg.ams.exception.UpdateFailedException;

public class UserServiceImpl implements UserService{
	AssetFormDaoImp as=new AssetFormDaoImp();
	private static HashMap<String, AssetForm>forms = new HashMap<String, AssetForm>();
	public boolean raiseRequest(AssetForm form) throws UpdateFailedException{
		boolean result=as.update(form);
		return result;
	 
	}
	public String update(AssetForm form){
		AssetForm result=forms.putIfAbsent(form.getRequestId(), form);
	    return form.getRequestId();
	}
	
	public String checkStatus(String requestId)
	{
		String result = as.checkStatusDao(requestId);
		return result;
		
	}
	public Employee  employeeData(String empId) throws ReadOperationFailed{
		EmployeeDaoImp e = new EmployeeDaoImp();
		Employee emp = e.readEmployee(empId);
		return emp;
	}

	public Department deptData(String deptId) throws ReadOperationFailed{
		DepartmentDaoImp d = new DepartmentDaoImp();
		Department dept = d.readDepartment(deptId);
		return dept;
	}

}
