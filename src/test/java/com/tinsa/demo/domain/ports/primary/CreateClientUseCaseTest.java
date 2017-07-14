package com.tinsa.demo.domain.ports.primary;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tinsa.demo.domain.model.Client;
import com.tinsa.demo.domain.ports.secondary.ClientRepository;

@RunWith(MockitoJUnitRunner.class)
public class CreateClientUseCaseTest 
{
	@Mock
	private ClientRepository clientRepository;
	@InjectMocks
	private CreateClientUseCase useCase;
	
	@Test
	public void createClientSuccessfully()
	{
		ClientRequest request = new ClientRequest("name", "notificationType", "recipient");
		ClientResponse response = new ClientResponse();
		
		useCase.execute(request, response);
		
		verify(clientRepository).save(any(Client.class));
	}
}
