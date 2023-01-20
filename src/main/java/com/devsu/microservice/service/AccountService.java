package com.devsu.microservice.service;

import java.util.List;

import com.devsu.microservice.exception.AccountException;
import com.devsu.microservice.service.dto.AccountDto;
import com.devsu.microservice.utils.ResponseMessage;

public interface AccountService {
	
	public List<AccountDto> getAll() throws AccountException;
	
	public float getInitialAmountById(Long accountNumber) throws AccountException;
	
	public ResponseMessage create(AccountDto accountDto) throws AccountException;
	
	public ResponseMessage edit(AccountDto accountDto) throws AccountException;
	
	public ResponseMessage delete(Long accountNumber) throws AccountException;
}
