package com.tinsa.demo.domain.ports.primary;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tinsa.demo.domain.model.Client;
import com.tinsa.demo.domain.model.Communication;
import com.tinsa.demo.domain.model.NotificationResult;
import com.tinsa.demo.domain.ports.secondary.ClientRepository;
import com.tinsa.demo.domain.ports.secondary.CommunicationRepository;
import com.tinsa.demo.domain.ports.secondary.NotificationRepository;

@Component
public class CreateNotificationUseCase 
{
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private NotificationFactory notificationfactory;
	@Autowired
	private CommunicationRepository communicationRepository;
	
	public void execute(CreateNotificationRequest request, CreateNotificationResponse response)
	{
		Optional<Client> optClient = clientRepository.findByClientId(request.getClientId());
		if(optClient.isPresent())
		{
			NotificationRepository instanceOfNotificationRepository = notificationfactory.getInstance(optClient.get().getCommunication());
			NotificationResult operationResult = instanceOfNotificationRepository.sendNotification(optClient.get().getRecipient(), request.getMessage());
			communicationRepository.save(new Communication(optClient.get().getRecipient(), request.getMessage(), optClient.get().getCommunication(), operationResult.name()));
			response.setNotificationResult(operationResult);
		}
		else
		{
			response.setNotificationResult(NotificationResult.CLIENT_NOT_FOUND);
		}	
	}
}
