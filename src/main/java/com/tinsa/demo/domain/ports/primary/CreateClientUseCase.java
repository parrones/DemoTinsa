package com.tinsa.demo.domain.ports.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tinsa.demo.domain.model.Client;
import com.tinsa.demo.domain.ports.secondary.ClientRepository;

@Component
public class CreateClientUseCase 
{
	@Autowired
	ClientRepository clientRepository;
	
	public void execute(ClientRequest request, ClientResponse response) 
	{
		long clientId = clientRepository.save(new Client(request.getName(), request.getNotificationType(), request.getRecipient()));
		response.setClientId(clientId);
	}
}
