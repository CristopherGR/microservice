package com.devsu.microservice.service.impl;

import java.util.List;
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

	public AccountServiceImpl() {
		super();
		this.accountMapper = new AccountMapper();
	}

	@Override
	public List<AccountDto> getAll() throws AccountException {
		List<Account> accountList = accountRepository.findAll();
		return accountMapper.accountListToAccountDtoList(accountList);
	}

	@Override
	public ResponseMessage create(AccountDto accountDto) throws AccountException {
		Optional<Account> accountTemp = accountRepository.findByAccountNumber(accountDto.getAccountNumber());

		if (accountTemp.isPresent()) {
			return (new ResponseMessage("La cuenta con ID " + accountDto.getAccountNumber() + ", ya existe"));
		} else {
			accountRepository.save(accountMapper.accountDtoToAccount(accountDto));
			return (new ResponseMessage("Cuenta creada con exito"));
		}
	}

	@Override
	public ResponseMessage edit(AccountDto accountDto) throws AccountException {
		Optional<Account> accountTemp = accountRepository.findByAccountNumber(accountDto.getAccountNumber());

		if (accountTemp.isPresent()) {
			accountRepository.save(accountMapper.accountDtoToAccount(accountDto));
			return (new ResponseMessage("Cuenta actualizada con exito"));
		} else {
			return (new ResponseMessage("Error al actuaizar la cuenta"));
		}
	}

	@Override
	public ResponseMessage delete(Long accountNumber) throws AccountException {
		Optional<Account> accountTemp = accountRepository.findByAccountNumber(accountNumber);

		if (accountTemp.isPresent()) {
			accountRepository.deleteByAccountNumber(accountNumber);
			return (new ResponseMessage("Cuenta eliminada con exito"));
		} else {
			return (new ResponseMessage("El cliente con ID: " + accountNumber + " no fue encontrado"));
		}
	}

}
