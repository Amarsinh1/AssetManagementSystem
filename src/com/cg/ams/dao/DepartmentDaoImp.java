package com.cg.ams.dao;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.ams.bean.Asset;
import com.cg.ams.bean.Department;
import com.cg.ams.exception.AssetAlreadyExistException;
import com.cg.ams.exception.InvalidIdException;
import com.cg.ams.exception.ReadOperationFailed;
import com.cg.ams.exception.UpdateFailedException;

public class DepartmentDaoImp implements DepartmentDao {
	private static HashMap<String,Department> departments=new HashMap<String,Department>();
	static final Logger logger = Logger.getLogger(UserMasterDaoImp.class);
	static {
		PropertyConfigurator.configure("C:\\Users\\Abhishek\\Desktop\\CoreJava\\Ab\\log4j\\log4j.properties");
	}
	@Override
	public Department readDepartment(String Dept_id) throws ReadOperationFailed {
		Department d=departments.get(Dept_id);
		if(d != null) {
			logger.info("Asset Read Successfully");
			return d;
			}
			else {
				logger.info("Asset Read UnSuccessFully");
				throw new ReadOperationFailed();
				
				
			}
	}
	@Override
	public boolean createDepartment(Department d) throws AssetAlreadyExistException  {
		Department result=departments.putIfAbsent(d.getDept_id(), d);
	    if(result!=null) {
	    	logger.info("Department data created Successfully");
	    	return true;
	    }
	    logger.info("Department data created UnSuccessfully");
	    throw new AssetAlreadyExistException();
	
	}
	@Override
	public boolean updateDepartment(String Dept_id, Department d)throws UpdateFailedException {
		Department result = departments.put(Dept_id, d);
		if (result != null) {
			logger.info("Update OPeration SuccessFul");
			return true;
		}
		logger.info("Update OPeration UnSuccessFul");
		throw new UpdateFailedException();
		
	}
	@Override
	public boolean deleteDepartment(String Dept_id)throws InvalidIdException {
		Department a = departments.remove(Dept_id);
		if (a != null) {
			logger.info("DEletion Successful");
			return true;
		}logger.info("Deletion failed");
		throw new InvalidIdException();
		
	
	}
	public static void mockData() {
		departments.put("1",new Department("KLM1","HR"));
		departments.put("2",new Department("KLM2","L&D"));
		departments.put("3",new Department("KLM3","CFWG"));
		departments.put("4",new Department("KLM4","HR"));
		departments.put("5",new Department("KLM5","L&D"));
	}
	public void print() {
		System.out.println(departments);
	}
}
