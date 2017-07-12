package com.tinsa.demo.infrastructure.repository.jpa;

import org.springframework.data.repository.CrudRepository;

public interface SpringCrudClientRepository extends CrudRepository<Client, Long>
{
	Client findByNameAndCommunication(String name, String communication);
}
