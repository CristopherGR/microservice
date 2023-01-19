package com.devsu.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.microservice.service.ClientService;
import com.devsu.microservice.service.dto.ClientDto;
import com.devsu.microservice.utils.ResponseMessage;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class ClientController {

	@Autowired
	ClientService clientService;
	
	@PutMapping("/client/update/")
	public ResponseEntity<ResponseMessage> update(@RequestBody ClientDto clientDto){
		ResponseMessage responseMessage = clientService.update(clientDto);
		return new ResponseEntity<>(responseMessage, new HttpHeaders(), HttpStatus.OK);
	}
}
