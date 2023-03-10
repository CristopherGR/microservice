package com.devsu.microservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsu.microservice.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	Optional <Client> findByIdClient(Long idClient);
	
	void deleteByIdClient(Long idClient);
	
	Optional <Client> findByIdentification(String identification);
}
