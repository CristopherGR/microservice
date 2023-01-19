package com.devsu.microservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsu.microservice.repository.PersonRepository;
import com.devsu.microservice.service.PersonService;
import com.devsu.microservice.service.dto.PersonDto;
import com.devsu.microservice.service.mapper.PersonMapper;
import com.devsu.microservice.utils.Constants;
import com.devsu.microservice.utils.ResponseMessage;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	private PersonMapper personMapper;
	
	

	public PersonServiceImpl() {
		super();
		this.personMapper = new PersonMapper();
	}



	@Override
	public ResponseMessage create(PersonDto personDto){
		personRepository.save(personMapper.personDtoToPerson(personDto));
		return (new ResponseMessage(Constants.PERSON_CREATED));
	}
	
	
}
