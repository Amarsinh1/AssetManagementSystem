package com.cg.ams.exception;

public class UpdateFailedException extends Exception {
    
	public UpdateFailedException() {
		super();
		System.out.println("Updation of info is failed...please try again.. ");
	}
}
