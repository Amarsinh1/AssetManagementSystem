package com.cg.ams.dao;

import com.cg.ams.bean.AssetAllocation;
import com.cg.ams.bean.Department;
import com.cg.ams.exception.AssetAlreadyExistException;
import com.cg.ams.exception.InvalidIdException;
import com.cg.ams.exception.ReadOperationFailed;
import com.cg.ams.exception.UpdateFailedException;

public interface DepartmentDao {
	Department readDepartment(String Dept_id) throws ReadOperationFailed;
    boolean createDepartment(Department d) throws AssetAlreadyExistException;
    boolean updateDepartment(String Dept_id, Department d) throws UpdateFailedException;
    boolean deleteDepartment(String Dept_id) throws InvalidIdException;
	

}
