package com.devsu.microservice.service;

import com.devsu.microservice.service.dto.PersonDto;
import com.devsu.microservice.utils.ResponseMessage;

public interface PersonService {
	public ResponseMessage create(PersonDto personDto);
}
