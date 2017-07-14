package com.tinsa.demo.infrastructure.repository.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tinsa.demo.domain.model.Notification;
import com.tinsa.demo.domain.ports.secondary.NotificationRepository;

@Component
@Transactional
public class JpaNotificationRepository implements NotificationRepository {

	@Autowired
	private SpringCrudNotificationRepository crudRepository;

	@Override
	public long save(Notification notification) 
	{
		return crudRepository.save(createRepoNotification(notification)).getId();
	}

	@Override
	public boolean exist(String message, String status, long clientId) {
		return crudRepository.findByMessageAndStatusAndClientId(message, status, clientId) != null;
	}
	
	private com.tinsa.demo.infrastructure.repository.jpa.Notification createRepoNotification (Notification notification)
	{
		return new com.tinsa.demo.infrastructure.repository.jpa.Notification(
				notification.getMessage(), notification.getStatus(), notification.getClientId());
	}
}
