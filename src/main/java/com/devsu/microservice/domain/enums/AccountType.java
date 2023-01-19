package com.devsu.microservice.domain.enums;

public enum AccountType {
	CREDIT("Credit"), DEBIT("Debit");

	private final String name;
	
	private AccountType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isCredit() {
		return this.equals(CREDIT);
	}
	
}
