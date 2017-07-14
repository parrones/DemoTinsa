package com.tinsa.demo.domain.ports.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tinsa.demo.domain.model.CommunicationTypes;
import com.tinsa.demo.domain.ports.secondary.NotifierRepository;
import com.tinsa.demo.infrastructure.repository.rest.FaxNotifierWsRepository;
import com.tinsa.demo.infrastructure.repository.rest.SmsNotifierWsRepository;

@Component
public class NotifierFactory 
{
	@Autowired
	SmsNotifierWsRepository smsNotifierRepository;
	@Autowired
	FaxNotifierWsRepository faxNotifierRepository;
	
	public NotifierRepository getInstance(String communication)
	{
		if(CommunicationTypes.SMS.name().equalsIgnoreCase(communication))
		{
			return smsNotifierRepository;
		}
		return faxNotifierRepository;
	}
}
