
package com.cg.ams.service;

import com.cg.ams.bean.UserMaster;
import com.cg.ams.dao.UserMasterDaoImp;
import com.cg.ams.exception.AuthenticationFailedException;


public class AuthenticationServiceImpl implements AuthenticationService {

	UserMasterDaoImp us=new UserMasterDaoImp();
		public UserMaster verify(String username, String password) throws AuthenticationFailedException{
			UserMaster result = us.verifyDao(username , password);
			return result;
			
		}
	}


