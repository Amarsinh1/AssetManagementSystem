package com.cg.ams.dao;

import com.cg.ams.bean.Department;
import com.cg.ams.bean.Employee;
import com.cg.ams.exception.AssetAlreadyExistException;
import com.cg.ams.exception.InvalidIdException;
import com.cg.ams.exception.ReadOperationFailed;
import com.cg.ams.exception.UpdateFailedException;

public interface EmployeeDao {
	Employee readEmployee(String Employee_no) throws ReadOperationFailed;
    boolean createEmployee(Employee e) throws AssetAlreadyExistException;
    boolean updateEmployee(String Employee_no,Employee e) throws UpdateFailedException;
    boolean deleteEmployee(String Employee_no) throws InvalidIdException;
	
}
