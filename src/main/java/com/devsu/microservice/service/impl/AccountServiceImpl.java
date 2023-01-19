package com.devsu.microservice.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsu.microservice.domain.Account;
import com.devsu.microservice.exception.AccountException;
import com.devsu.microservice.repository.AccountRepository;
import com.devsu.microservice.service.AccountService;
import com.devsu.microservice.service.dto.AccountDto;
import com.devsu.microservice.service.mapper.AccountMapper;
import com.devsu.microservice.utils.ResponseMessage;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	private AccountMapper accountMapper;

	public AccountServiceImpl(AccountMapper accountMapper) {
		super();
		this.accountMapper = new AccountMapper();
	}

	@Override
	public ResponseMessage create(AccountDto accountDto) throws AccountException {
		Optional<Account> findAccountById = accountRepository.findByAccountNumber(accountDto.getAccountNumber());

		if (findAccountById.isPresent()) {
			return new ResponseMessage("Error: La cuenta con ID " + accountDto.getAccountNumber() + ", ya existe");
		}

		accountRepository.save(accountMapper.accountDtoToAccount(accountDto));
		return new ResponseMessage("Registro exitoso!");
	}

	@Override
	public ResponseMessage edit(AccountDto accountDto) throws AccountException {
		Optional<Account> findAccountById = accountRepository.findByAccountNumber(accountDto.getAccountNumber());

		if (findAccountById.isEmpty()) {
			return new ResponseMessage("Error: La cuenta con ID " + accountDto.getAccountNumber() + ", no existe");
		}

		accountRepository.save(accountMapper.accountDtoToAccount(accountDto));
		return new ResponseMessage("Actualización exitosa!");
	}

	@Override
	public ResponseMessage delete(String accountNumber) throws AccountException {
		Optional<Account> findAccountById = accountRepository.findByAccountNumber(accountNumber);

		if (findAccountById.isEmpty()) {
			return new ResponseMessage("Error: La cuenta con ID " + accountNumber + ", no existe");
		}
		
		accountRepository.delete(findAccountById.get());
		return new ResponseMessage("Eliminación exitosa!");
	}

}
