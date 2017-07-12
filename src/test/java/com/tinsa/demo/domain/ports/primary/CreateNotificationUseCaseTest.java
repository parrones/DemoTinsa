package com.tinsa.demo.domain.ports.primary;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.tinsa.demo.domain.model.Client;
import com.tinsa.demo.domain.model.Communication;
import com.tinsa.demo.domain.model.NotificationResult;
import com.tinsa.demo.domain.ports.secondary.ClientRepository;
import com.tinsa.demo.domain.ports.secondary.CommunicationRepository;
import com.tinsa.demo.domain.ports.secondary.NotificationRepository;
import com.tinsa.demo.infrastructure.repository.rest.FaxNotificationWsRepository;
import com.tinsa.demo.infrastructure.repository.rest.SmsNotificationWsRepository;

@RunWith(MockitoJUnitRunner.class)
public class CreateNotificationUseCaseTest 
{
	private static final String FAX_COMMUNICATION = "FAX";
	private static final String ANY_RECIPIENT = "recipient";
	private static final String SMS_COMMUNICATION = "SMS";
	private static final String ANY_NAME = "name";
	private static final String ANY_MESSAGE = "message";
	private static final long ANY_CLIENT_ID = 1l;
	@Mock
	private ClientRepository clientRepository;
	@Mock
	private NotificationFactory notificationfactory;
	@Mock
	private CommunicationRepository communicationRepository;
	@InjectMocks
	private CreateNotificationUseCase createNotificationUseCase;
	
	private CreateNotificationRequest request;
	private CreateNotificationResponse response;
	
	@Before
	public void setUp()
	{
		request = new CreateNotificationRequest(ANY_CLIENT_ID, ANY_MESSAGE);
		response = new CreateNotificationResponse();
	}
	
	@Test
	public void createNotificationBySmsSuccessfully()
	{
		Client client = new Client(ANY_NAME, SMS_COMMUNICATION, ANY_RECIPIENT);
		NotificationRepository smsRepository = Mockito.mock(SmsNotificationWsRepository.class);
		when(clientRepository.findByClientId(request.getClientId())).thenReturn(Optional.of(client));
		when(notificationfactory.getInstance(SMS_COMMUNICATION)).thenReturn(smsRepository);
		when(smsRepository.sendNotification(ANY_RECIPIENT, ANY_MESSAGE)).thenReturn(NotificationResult.OK);
		
		createNotificationUseCase.execute(request, response);
		
		verify(communicationRepository).save(any(Communication.class));
		assertEquals(NotificationResult.OK,response.getNotificatioResult());
	}
	
	@Test
	public void createNotificationClientNotFound()
	{
		when(clientRepository.findByClientId(request.getClientId())).thenReturn(Optional.empty());
		
		createNotificationUseCase.execute(request, response);
		
		verify(notificationfactory, never()).getInstance(any(String.class));
		verify(communicationRepository,never()).save(any(Communication.class));
		assertEquals(NotificationResult.CLIENT_NOT_FOUND, response.getNotificatioResult());
	}
	
	@Test
	public void createNotificationBySmsErrorInSendNotificationService()
	{
		Client client = new Client(ANY_NAME, SMS_COMMUNICATION, ANY_RECIPIENT);
		NotificationRepository smsRepository = Mockito.mock(SmsNotificationWsRepository.class);
		when(clientRepository.findByClientId(request.getClientId())).thenReturn(Optional.of(client));
		when(notificationfactory.getInstance(SMS_COMMUNICATION)).thenReturn(smsRepository);
		when(smsRepository.sendNotification(ANY_RECIPIENT, ANY_MESSAGE)).thenReturn(NotificationResult.KO);
		
		createNotificationUseCase.execute(request, response);
		
		verify(communicationRepository).save(any(Communication.class));
		assertEquals(NotificationResult.KO,response.getNotificatioResult());
	}
	
	@Test
	public void createNotificationByFaxSuccessfully()
	{
		Client client = new Client(ANY_NAME, FAX_COMMUNICATION, ANY_RECIPIENT);
		NotificationRepository faxRepository = Mockito.mock(FaxNotificationWsRepository.class);
		when(clientRepository.findByClientId(request.getClientId())).thenReturn(Optional.of(client));
		when(notificationfactory.getInstance(FAX_COMMUNICATION)).thenReturn(faxRepository);
		when(faxRepository.sendNotification(ANY_RECIPIENT, ANY_MESSAGE)).thenReturn(NotificationResult.OK);
		
		createNotificationUseCase.execute(request, response);
		
		verify(communicationRepository).save(any(Communication.class));
		assertEquals(NotificationResult.OK,response.getNotificatioResult());
	}
	
	@Test
	public void createNotificationByFaxErrorInSendNotificationService()
	{
		Client client = new Client(ANY_NAME, FAX_COMMUNICATION, ANY_RECIPIENT);
		NotificationRepository faxRepository = Mockito.mock(FaxNotificationWsRepository.class);
		when(clientRepository.findByClientId(request.getClientId())).thenReturn(Optional.of(client));
		when(notificationfactory.getInstance(FAX_COMMUNICATION)).thenReturn(faxRepository);
		when(faxRepository.sendNotification(ANY_RECIPIENT, ANY_MESSAGE)).thenReturn(NotificationResult.KO);
		
		createNotificationUseCase.execute(request, response);
		
		verify(communicationRepository).save(any(Communication.class));
		assertEquals(NotificationResult.KO,response.getNotificatioResult());
	}
}
