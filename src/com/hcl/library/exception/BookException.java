package com.hcl.library.exception;

public class BookException extends Exception {
	

	private static final long serialVersionUID = 1L;
	private String message;
	
	public BookException(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return this.message;
	}

}
