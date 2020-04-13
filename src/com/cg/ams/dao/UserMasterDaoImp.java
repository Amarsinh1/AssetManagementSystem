
package com.cg.ams.dao;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.ams.bean.AssetAllocation;
import com.cg.ams.bean.Department;
import com.cg.ams.bean.UserMaster;
import com.cg.ams.exception.AssetAlreadyExistException;
import com.cg.ams.exception.AuthenticationFailedException;
import com.cg.ams.exception.InvalidIdException;
import com.cg.ams.exception.UpdateFailedException;


public class UserMasterDaoImp implements UserMasterDao {
	private static HashMap<String, UserMaster>users = new HashMap<String, UserMaster>();
 static final Logger logger = Logger.getLogger(UserMasterDaoImp.class);

	static {
		PropertyConfigurator.configure("C:\\Users\\Abhishek\\Desktop\\CoreJava\\Ab\\log4j\\log4j.properties");
	}
	@Override
	public UserMaster readUserMaster(String userId) throws InvalidIdException {
		UserMaster u = users.get(userId);
		if(u != null) {
			logger.info("read successfully");
			return u;
			}
			else {
				logger.info("read operation failed");
				throw new InvalidIdException();
				
			}
	}
	@Override
public UserMaster verifyDao(String username, String password) throws AuthenticationFailedException{
		
		UserMaster result=null;
		
		
		for(UserMaster um : users.values()){
			if(um.getUsername().equalsIgnoreCase(username) && um.getPassword().equalsIgnoreCase(password)){
				result= um;
				logger.info("Authentication Successful");
				return um;
			}
			
		}
		throw new AuthenticationFailedException();
		}
	@Override
	public boolean createUserMaster(UserMaster u) throws  AssetAlreadyExistException {
		UserMaster result=users.putIfAbsent(u.getUserId(), u);
	    if(result==null) {
	    	logger.info("User Master Created Successfully");
	    	return true;
	    }
	    logger.info("User Master not created Successfully");
	    throw new  AssetAlreadyExistException();
		
	}
	@Override
	public boolean updateUserMaster(String userId, UserMaster u) throws UpdateFailedException{
		UserMaster result = users.put(userId, u);
		if (result != null) {
			logger.info("Updation Successful");
			return true;
		}
		logger.info("Updation Failed");
		throw new UpdateFailedException();
		
	}
	@Override
	public boolean deleteUserMaster(String userId) throws InvalidIdException {
		UserMaster u = users.remove(userId);
		if (u != null) {
			logger.info("Deletion Successful");
			return true;
		}
		logger.info("Deletion Failed");
		throw new InvalidIdException();
		
	}
	public static void mockData(){
		users.put("1",new UserMaster("123456","Abhishek","987456","admin","456"));
		users.put("2",new UserMaster("423456","Samiran","902860@ab","Admin","457"));
		users.put("3",new UserMaster("523456","Amarsinh","456879@wr","Manager","458"));
		users.put("4",new UserMaster("923456","manager","1234","manager","460"));
		users.put("5",new UserMaster("1823456","Abhinash","Kamla@48","Manager","460"));
		users.put("6",new UserMaster("923456","Sonu","Kapoor@234","Admin","459"));
		users.put("7",new UserMaster("723456","Aakash","abhhish@345","Manager","461"));
	}
	public void print() {
		System.out.println(users);
	}
}
