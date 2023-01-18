package com.devsu.microservice.service.mapper.impl;

import com.devsu.microservice.domain.Person;
import com.devsu.microservice.service.dto.PersonDto;
import com.devsu.microservice.service.mapper.PersonMapper;

public class PersonMapperImpl implements PersonMapper{

	public PersonMapperImpl() {
		
	}
	
	@Override
	public Person personDtoToPerson(PersonDto personDto) {
		return (new Person(personDto));
	}

	@Override
	public PersonDto personToPersonDto(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

}
