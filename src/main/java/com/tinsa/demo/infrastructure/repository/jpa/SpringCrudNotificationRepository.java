package com.tinsa.demo.infrastructure.repository.jpa;

import org.springframework.data.repository.CrudRepository;

public interface SpringCrudNotificationRepository extends CrudRepository<Notification, Long>
{
	Notification findByMessageAndStatusAndClientId(String message, String status, long clientId);
}
