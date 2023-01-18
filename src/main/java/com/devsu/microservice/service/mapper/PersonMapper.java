package com.devsu.microservice.service.mapper;

import org.mapstruct.Mapper;

import com.devsu.microservice.domain.Person;
import com.devsu.microservice.service.dto.PersonDto;

@Mapper(componentModel = "spring")
public interface PersonMapper {

	public Person personDtoToPerson(PersonDto personDto);
	public PersonDto personToPersonDto(Person person);
	
}
