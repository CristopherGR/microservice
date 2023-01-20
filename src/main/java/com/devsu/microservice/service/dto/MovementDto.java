package com.devsu.microservice.service.dto;

import java.util.Date;

public class MovementDto {

	private Long movementId;
	
	private String movementType;
	
	private float value;
	
	private Date date;
	
	private float totalAmount;
	
	private AccountDto account;

	public MovementDto() {
		super();
	}

	public MovementDto(Long movementId, String movementType, Date date, float value, float totalAmount, AccountDto account) {
		super();
		this.movementId = movementId;
		this.movementType = movementType;
		this.date = date;
		this.value = value;
		this.totalAmount = totalAmount;
		this.account = account;
	}

	public Long getMovementId() {
		return movementId;
	}

	public void setMovementId(Long movementId) {
		this.movementId = movementId;
	}

	public String getMovementType() {
		return movementType;
	}

	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public AccountDto getAccount() {
		return account;
	}

	public void setAccount(AccountDto account) {
		this.account = account;
	}

}
