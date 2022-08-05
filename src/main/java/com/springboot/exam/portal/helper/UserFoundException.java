package com.springboot.exam.portal.helper;

public class UserFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
		public UserFoundException() {
		super("User With This Username Already Exist");
		}

		public UserFoundException(String message) {
			super(message);
		}

		
	
		
		
}
