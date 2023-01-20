package com.devsu.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.microservice.exception.AccountException;
import com.devsu.microservice.service.AccountService;
import com.devsu.microservice.service.dto.AccountDto;
import com.devsu.microservice.utils.ResponseMessage;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/cuentas/todas")
	public ResponseEntity<List<AccountDto>> getAll() {
		try {
			List<AccountDto> accountDtoList = accountService.getAll();
			return new ResponseEntity<>(accountDtoList, new HttpHeaders(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/cuentas/crear")
	public ResponseEntity<ResponseMessage> create(@RequestBody AccountDto accountDto) {
		try {
			ResponseMessage responseMessage = accountService.create(accountDto);
			return new ResponseEntity<>(responseMessage, new HttpHeaders(), HttpStatus.CREATED);
		} catch (AccountException e) {
			return new ResponseEntity<>(new ResponseMessage("Error: " + e.getMessage()), new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/cuentas/editar")
	public ResponseEntity<ResponseMessage> edit(@RequestBody AccountDto accountDto) {
		try {
			ResponseMessage responseMessage = accountService.edit(accountDto);
			return new ResponseEntity<>(responseMessage, new HttpHeaders(), HttpStatus.OK);
		} catch (AccountException e) {
			return new ResponseEntity<>(new ResponseMessage("Error: " + e.getMessage()), new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/cuentas/eliminar/{accountNumber}")
	@Transactional
	public ResponseEntity<ResponseMessage> delete(@PathVariable("accountNumber") Long accountNumber) {
		try {
			ResponseMessage responseMessage = accountService.delete(accountNumber);
			return new ResponseEntity<>(responseMessage, new HttpHeaders(), HttpStatus.OK);
		} catch (AccountException e) {
			return new ResponseEntity<>(new ResponseMessage("Error: " + e.getMessage()), new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
	}
}
