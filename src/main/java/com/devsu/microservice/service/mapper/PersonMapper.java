package com.devsu.microservice.service.mapper;

import com.devsu.microservice.domain.Person;
import com.devsu.microservice.service.dto.PersonDto;

public interface PersonMapper {

	public Person personDtoToPerson(PersonDto personDto);
	public PersonDto personToPersonDto(Person person);
	
}
