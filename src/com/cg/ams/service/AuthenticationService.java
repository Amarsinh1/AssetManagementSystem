package com.cg.ams.service;

import com.cg.ams.bean.UserMaster;
import com.cg.ams.exception.AuthenticationFailedException;

public interface AuthenticationService {
	public UserMaster verify(String username, String password) throws AuthenticationFailedException;
}
