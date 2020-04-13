package com.cg.ams.dao;

import com.cg.ams.bean.Department;
import com.cg.ams.bean.UserMaster;
import com.cg.ams.exception.AssetAlreadyExistException;
import com.cg.ams.exception.AuthenticationFailedException;
import com.cg.ams.exception.InvalidIdException;
import com.cg.ams.exception.UpdateFailedException;

public interface UserMasterDao {
	UserMaster readUserMaster(String userId) throws InvalidIdException;
    boolean createUserMaster(UserMaster u) throws AssetAlreadyExistException;
    boolean updateUserMaster(String userId, UserMaster u) throws UpdateFailedException;
    boolean deleteUserMaster(String userId) throws InvalidIdException;
    
	public UserMaster verifyDao(String username, String password) throws AuthenticationFailedException;
}
