package com.exam.encasderreur;

public class UserNotFoundException extends Exception {
	 
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String username) {
        super(String.format("User with id '%s' is not found", username));
    }
}