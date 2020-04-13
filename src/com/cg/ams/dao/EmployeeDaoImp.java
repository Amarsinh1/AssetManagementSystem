package com.cg.ams.dao;

import java.time.LocalDate;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.ams.bean.AssetAllocation;
import com.cg.ams.bean.Department;
import com.cg.ams.bean.Employee;
import com.cg.ams.bean.UserMaster;
import com.cg.ams.exception.AssetAlreadyExistException;
import com.cg.ams.exception.InvalidIdException;
import com.cg.ams.exception.ReadOperationFailed;
import com.cg.ams.exception.UpdateFailedException;

public class EmployeeDaoImp implements EmployeeDao {
	private static HashMap<String,Employee> employees=new HashMap<String,Employee>();

	 static final Logger logger = Logger.getLogger(EmployeeDaoImp.class);
	 static {
			PropertyConfigurator.configure("C:\\Users\\Abhishek\\Desktop\\CoreJava\\Ab\\log4j\\log4j.properties");
		}
	@Override
	public Employee readEmployee(String Employee_no)throws ReadOperationFailed {
		Employee e=employees.get(Employee_no);
		if(e != null) {
			logger.info("Asset Read Successfully");
			return e;
			}
			else {
				logger.info("Asset Read UnSuccessfully");
				throw new ReadOperationFailed();
				
			}
	}
	@Override
	public boolean createEmployee(Employee e) throws AssetAlreadyExistException{
		Employee result=employees.putIfAbsent(e.getEmployee_no(), e);
	    if(result!=null) {
	    	logger.info("Employee TAble Created");
	    	return true;
	    }
	    throw new AssetAlreadyExistException();
	}
	@Override
	public boolean updateEmployee(String Employee_no, Employee e)throws UpdateFailedException {
		Employee result = employees.put(Employee_no, e);
		if (result != null) {
			logger.info("Update OPeration SuccessFul");
			return true;
		}
		logger.info("Update OPeration Failed");
		throw new UpdateFailedException();
		
	}
	@Override
	public boolean deleteEmployee(String Employee_no) throws InvalidIdException {
		Employee e = employees.remove(Employee_no);
		if (e != null) {
			logger.info("deleted");
			return true;
		}
		throw new  InvalidIdException();
	}
	
	public static void mockData() {
		employees.put("1",new Employee("456","Abhishek","Analyst","Rakesh", LocalDate.parse("2010-02-27"),"KLM2"));
		employees.put("2",new Employee("457","Samiran","Manager","Rakesh", LocalDate.parse("2015-03-15"),"KLM2"));
		employees.put("3",new Employee("458","Amarsinh","Consultant","Rakesh", LocalDate.parse("2012-02-15"),"KLM2"));
		employees.put("4",new Employee("459","Shailesh","CEO","Rakesh", LocalDate.parse("2017-03-14"),"KLM2"));
		employees.put("5",new Employee("450","Sidhharth","Associate","Rakesh", LocalDate.parse("2020-02-27"),"KLM2"));
		employees.put("6",new Employee("451","Sonu","Director","Rakesh", LocalDate.parse("2009-01-15"),"KLM2"));
		

	}
	public void print() {
		System.out.println(employees);
	}
}
