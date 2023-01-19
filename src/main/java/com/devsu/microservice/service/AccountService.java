package com.devsu.microservice.service;

import com.devsu.microservice.exception.AccountException;
import com.devsu.microservice.service.dto.AccountDto;
import com.devsu.microservice.utils.ResponseMessage;

public interface AccountService {
	
	public ResponseMessage create(AccountDto accountDto) throws AccountException;
	
	public ResponseMessage edit(AccountDto accountDto) throws AccountException;
	
	public ResponseMessage delete(String accountNumber) throws AccountException;
}
