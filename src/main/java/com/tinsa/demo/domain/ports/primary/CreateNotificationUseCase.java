package com.tinsa.demo.domain.ports.primary;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tinsa.demo.domain.model.Client;
import com.tinsa.demo.domain.model.Notification;
import com.tinsa.demo.domain.model.NotificationResult;
import com.tinsa.demo.domain.ports.secondary.ClientRepository;
import com.tinsa.demo.domain.ports.secondary.NotificationRepository;
import com.tinsa.demo.domain.ports.secondary.NotifierRepository;

@Component
public class CreateNotificationUseCase 
{
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private NotificationFactory notificationfactory;
	@Autowired
	private NotificationRepository notificationRepository;
	
	public void execute(CreateNotificationRequest request, CreateNotificationResponse response)
	{
		Optional<Client> optClient = clientRepository.findByClientId(request.getClientId());
		if(optClient.isPresent())
		{
			NotifierRepository instanceOfNotificationRepository = notificationfactory.getInstance(optClient.get().getNotificationType());
			NotificationResult operationResult = instanceOfNotificationRepository.sendNotification(optClient.get().getRecipient(), request.getMessage());
			long notificationId = notificationRepository.save(new Notification(request.getMessage(), request.getClientId(), operationResult.name()));
			response.setNotificationId(notificationId);
			response.setNotificationResult(operationResult);
		}
		else
		{
			response.setNotificationResult(NotificationResult.CLIENT_NOT_FOUND);
		}	
	}
}
