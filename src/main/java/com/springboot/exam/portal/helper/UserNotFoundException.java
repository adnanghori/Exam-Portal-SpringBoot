package com.springboot.exam.portal.helper;

public class UserNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(String exception) {
		super(exception);
	}
	public UserNotFoundException() {
		super("User Not Found");
	}

}
