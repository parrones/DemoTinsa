package com.tinsa.demo.infrastructure.repository.jpa;

import org.springframework.data.repository.CrudRepository;

public interface SpringCrudCommunicationRepository extends CrudRepository<Communication, Long>
{
	Communication findByMessageAndStatusAndClientId(String message, String status, long clientId);
}
