package com.tinsa.demo.infrastructure.repository.jpa;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tinsa.demo.domain.model.Communication;
import com.tinsa.demo.domain.ports.secondary.CommunicationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class JpaCommunicationRepositoryIT 
{
	private static final String STATUS_KO = "KO";
	private static final String STATUS_OK = "OK";
	private static final String TIPO_ENVIO = "SMS";
	private static final String MENSAJE = "mensaje";
	private static final String DESTINATARIO = "6000000";
	
	@Autowired
	private CommunicationRepository communicationRepository;
	
	@Test
	public void saveOKCommunications()
	{
		Communication communication = new Communication(DESTINATARIO, MENSAJE, TIPO_ENVIO, STATUS_OK);
		
		assertFalse(communicationRepository.exist(DESTINATARIO, TIPO_ENVIO));
		
		communicationRepository.save(communication);
		
		assertTrue(communicationRepository.exist(DESTINATARIO, TIPO_ENVIO));
	}
	
	@Test
	public void saveKOCommunications()
	{
		Communication communication = new Communication(DESTINATARIO, MENSAJE, TIPO_ENVIO, STATUS_KO);
		
		assertFalse(communicationRepository.exist(DESTINATARIO, TIPO_ENVIO));
		
		communicationRepository.save(communication);
		
		assertTrue(communicationRepository.exist(DESTINATARIO, TIPO_ENVIO));
	}
}
