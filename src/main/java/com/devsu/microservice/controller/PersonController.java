package com.devsu.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.microservice.service.PersonService;
import com.devsu.microservice.service.dto.PersonDto;
import com.devsu.microservice.utils.ResponseMessage;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/jeje")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@PostMapping("/create")
	public ResponseEntity<ResponseMessage> create(@RequestBody PersonDto personDto){
		ResponseMessage resposeMessage = personService.create(personDto);
		return new ResponseEntity<>(resposeMessage, new HttpHeaders(), HttpStatus.OK);
	}
}
