package com.devsu.microservice.exception;

public class ClientException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public ClientException(String message) {
		super(message);
	}
}
