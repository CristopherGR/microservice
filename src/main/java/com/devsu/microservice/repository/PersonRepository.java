package com.devsu.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devsu.microservice.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
	
}
