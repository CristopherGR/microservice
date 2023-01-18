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
	


	@Override
	public ResponseMessage create(PersonDto personDto){
		System.out.println(personDto.getIdentification());
		System.out.println(personDto.getAddress());
		System.out.println(personDto.getGender());
		System.out.println(personDto.getName());
		System.out.println(personDto.getPhone());
		System.out.println(personDto.getAge());


		personRepository.save(personMapper.personDtoToPerson(personDto));
		return (new ResponseMessage(Constants.PERSON_CREATE));
	}
	
	
}
