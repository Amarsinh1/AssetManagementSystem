package com.cg.ams.exception;

public class AuthenticationFailedException extends Exception  {
	
	public AuthenticationFailedException() {
		super();
        System.out.println("Please enter valid login-id or password.");
	}
	
}
