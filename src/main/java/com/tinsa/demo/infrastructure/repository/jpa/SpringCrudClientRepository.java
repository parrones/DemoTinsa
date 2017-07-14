package com.tinsa.demo.infrastructure.repository.jpa;

import org.springframework.data.repository.CrudRepository;

public interface SpringCrudClientRepository extends CrudRepository<Client, Long>
{
	Client findByNameAndNotificationType(String name, String notificationType);
}
