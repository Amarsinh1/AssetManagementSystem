package com.cg.ams.service;

import com.cg.ams.bean.AssetForm;
import com.cg.ams.bean.Department;
import com.cg.ams.bean.Employee;
import com.cg.ams.exception.ReadOperationFailed;
import com.cg.ams.exception.UpdateFailedException;

public interface UserService {
	public  boolean raiseRequest(AssetForm form) throws UpdateFailedException;
	public String checkStatus(String assetRequestId);
	public Employee  employeeData(String empId) throws ReadOperationFailed;
	public Department deptData(String deptId) throws ReadOperationFailed;
}
