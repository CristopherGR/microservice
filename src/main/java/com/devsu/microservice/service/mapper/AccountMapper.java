package com.devsu.microservice.service.mapper;

import com.devsu.microservice.domain.Account;
import com.devsu.microservice.service.dto.AccountDto;

public class AccountMapper {
	
	public Account accountDtoToAccount(AccountDto accountDto) {
		Account account = new Account();
		account.setAccountNumber(accountDto.getAccountNumber());
		account.setState(accountDto.isState());
		account.setOpeningBalance(accountDto.getOpeningBalance());
		account.setAccountType(accountDto.getAccountType());
		account.setClient(null);
		return account;
	}
	
	public AccountDto accountToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountNumber(account.getAccountNumber());
		accountDto.setState(account.isState());
		accountDto.setOpeningBalance(account.getOpeningBalance());
		accountDto.setAccountType(account.getAccountType());
		accountDto.setClient(null);
		return accountDto;
	}
}
