package com.devsu.microservice.service.mapper;

import java.util.ArrayList;
import java.util.List;

import com.devsu.microservice.domain.Account;
import com.devsu.microservice.service.dto.AccountDto;

public class AccountMapper {
	
	private ClientMapper clientMapper;
	
	public AccountMapper() {
		super();
		clientMapper = new ClientMapper();
	}

	public Account accountDtoToAccount(AccountDto accountDto) {
		Account account = new Account();
		account.setAccountNumber(accountDto.getAccountNumber());
		account.setState(accountDto.isState());
		account.setInitialAmount(accountDto.getInitialAmount());
		account.setAccountType(accountDto.getAccountType());
		account.setClient(clientMapper.clientDtoToClient(accountDto.getClient()));
		return account;
	}
	
	public AccountDto accountToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountNumber(account.getAccountNumber());
		accountDto.setState(account.isState());
		accountDto.setInitialAmount(account.getInitialAmount());
		accountDto.setAccountType(account.getAccountType());
		accountDto.setClient(clientMapper.clientToClientDto(account.getClient()));
		return accountDto;
	}
	
	/**
	 * se vuelve a usar la funcion accountToAccountDto() 
	 * para no volver a escribir las mismas lineas de codigo
	 * dentro del for, luego se usa directamente accountDtoList.add()
	 */
	public List<AccountDto> accountListToAccountDtoList(List<Account> accountList){
		
		if (accountList.isEmpty()) {
			return null;
		}
		
		List<AccountDto> accountDtoList = new ArrayList<>();
		

		for(Account account : accountList) {
			accountDtoList.add(accountToAccountDto(account));
		}	
		
		return accountDtoList;
	}
}
