package com.tinsa.demo.infrastructure.repository.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tinsa.demo.domain.model.Communication;
import com.tinsa.demo.domain.ports.secondary.CommunicationRepository;

@Component
@Transactional
public class JpaCommunicationRepository implements CommunicationRepository {

	@Autowired
	private SpringCrudCommunicationRepository crudRepository;

	@Override
	public void save(Communication communication) 
	{
		crudRepository.save(createRepoCommunication(communication));
	}

	@Override
	public boolean exist(String message, String status, long clientId) {
		return crudRepository.findByMessageAndStatusAndClientId(message, status, clientId) != null;
	}
	
	private com.tinsa.demo.infrastructure.repository.jpa.Communication createRepoCommunication (Communication communication)
	{
		return new com.tinsa.demo.infrastructure.repository.jpa.Communication(
				communication.getMessage(), communication.getStatus(), communication.getClientId());
	}
}
