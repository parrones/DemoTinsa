package com.tinsa.demo.domain.ports.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tinsa.demo.domain.model.CommunicationTypes;
import com.tinsa.demo.domain.ports.secondary.NotificationRepository;
import com.tinsa.demo.infrastructure.repository.rest.FaxNotificationWsRepository;
import com.tinsa.demo.infrastructure.repository.rest.SmsNotificationWsRepository;

@Component
public class NotificationFactory 
{
	@Autowired
	SmsNotificationWsRepository smsNotificationRepository;
	@Autowired
	FaxNotificationWsRepository faxNotificationRepository;
	
	public NotificationRepository getInstance(String communication)
	{
		if(CommunicationTypes.SMS.name().equalsIgnoreCase(communication))
		{
			return smsNotificationRepository;
		}
		return faxNotificationRepository;
	}
}
