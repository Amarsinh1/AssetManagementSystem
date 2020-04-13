package com.cg.ams.exception;

public class UserAlreadyExistsException extends Exception {

	public UserAlreadyExistsException() {
		super();
        System.out.println("This user already exists.");
	}

}
