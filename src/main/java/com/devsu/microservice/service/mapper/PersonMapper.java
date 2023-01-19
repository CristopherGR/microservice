package com.devsu.microservice.service.mapper;

import com.devsu.microservice.domain.Person;
import com.devsu.microservice.service.dto.PersonDto;

public class PersonMapper {
	
	public Person personDtoToPerson(PersonDto personDto) {
		Person person = new Person();
		person.setIdentification(personDto.getIdentification());
		person.setName(personDto.getName());
		return person;
	}

	public PersonDto personToPersonDto(Person person) {
		PersonDto personDto = new PersonDto();
		return personDto;
	}
	
}
