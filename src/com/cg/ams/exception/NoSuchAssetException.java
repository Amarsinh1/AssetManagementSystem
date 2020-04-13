package com.cg.ams.exception;

public class NoSuchAssetException extends Exception{

	public NoSuchAssetException() {
		super();
        System.out.println("No Such Asset present in asset list.");
	}
}
