package com.tinsa.demo.infrastructure.repository.jpa;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tinsa.demo.domain.model.Client;
import com.tinsa.demo.domain.ports.secondary.ClientRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class JpaClientRepositoryIT 
{
	private static final String RECIPIENT = "613728328";
	private static final String NOTIFICATION_TYPE = "SMS";
	private static final String NAME = "Prueba";
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Test
	public void saveSuccessfully()
	{
		com.tinsa.demo.domain.model.Client client = new com.tinsa.demo.domain.model.Client(NAME, NOTIFICATION_TYPE, RECIPIENT);
		assertFalse(clientRepository.exist(NAME, NOTIFICATION_TYPE));
		
		clientRepository.save(client);
		
		assertTrue(clientRepository.exist(NAME, NOTIFICATION_TYPE));
	}
	
	@Test
	public void findByClientIdSuccessfully()
	{
		com.tinsa.demo.domain.model.Client client = new com.tinsa.demo.domain.model.Client("Test", "FAX", "916366734");
		long clientId = clientRepository.save(client);
		
		Optional<Client> optClient = clientRepository.findByClientId(clientId);
		
		assertTrue(optClient.isPresent());
	}
	
	@Test
	public void findByClientIdEmptyBecauseTheClientDoesntExist()
	{	
		Optional<Client> optClient = clientRepository.findByClientId(999l);
		
		assertFalse(optClient.isPresent());
	}
}
